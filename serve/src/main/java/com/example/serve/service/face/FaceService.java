package com.example.serve.service.face;
import com.example.serve.Face.BaiduAIFace;
import com.example.serve.bean.face.ModelSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Map;
@Service
public class FaceService {
    @Autowired
    BaiduAIFace faceapi;
    @Autowired
    ModelSetting modelSetting;
    public Map<String,Object> searchface(StringBuffer imagebase64) throws IOException {
        String substring = imagebase64.substring(imagebase64.indexOf(",")+1, imagebase64.length());
        modelSetting.setImgpath(substring);
        modelSetting.setGroupID("zynorl");
        System.out.printf("Imgpath",substring);
        Map map = faceapi.FaceSearch(modelSetting);
        return map;
    }
}
