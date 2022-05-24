package com.example.serve.controller;

import com.example.serve.bean.CodeStatus;
import com.example.serve.bean.company.Toudi;
import com.example.serve.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class toudiController {
    @Autowired
    private CompanyServiceImpl companyService;
    @CrossOrigin
    @ResponseBody
    @GetMapping("/toudi/push")
    public CodeStatus push(@RequestParam("JobId") Integer jobid, @RequestParam("userid") Integer userid, @RequestParam("scores") double scores,
                           @RequestParam("position") String position,@RequestParam("comid") Integer comid) {
        companyService.addToudi(jobid, userid,new Date(),scores,position,comid);
        return new CodeStatus(200,"投递成功");
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("company/get/Toudi")
    public List<Toudi> getToudiGridData(Integer comid){
        return companyService.getToudiListByComId(comid);
    }
}
