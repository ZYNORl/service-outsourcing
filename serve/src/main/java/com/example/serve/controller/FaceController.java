package com.example.serve.controller;

import com.example.serve.Utils.GsonUtils;
import com.example.serve.service.face.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@SessionAttributes(value = "useinf")
public class FaceController {
    @Autowired
    private FaceService faceService;
    @RequestMapping("/searchface")
    @ResponseBody
    @CrossOrigin
    public  String searchface(@RequestBody @RequestParam(name = "imagebast64") StringBuffer imagebast64, Model model, HttpServletRequest request) throws IOException {
        Map<String, Object> searchface = faceService.searchface(imagebast64);
        if(searchface==null||searchface.get("user_id")==null){
            System.out.println("我进来了");
            String flag="fail";
            String s = GsonUtils.toJson(flag);
            return s;
        }
        String user_id = searchface.get("user_id").toString();
        String score=searchface.get("score").toString().substring(0,2);
        int i = Integer.parseInt(score);
        if(i>40){
            model.addAttribute("userinf",user_id);
            HttpSession session = request.getSession();
            session.setAttribute("userinf",user_id);
            System.out.println("存入session");
        }
        System.out.println(searchface);
        String s = GsonUtils.toJson(searchface);
        return s;
    }
}
