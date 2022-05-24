package com.example.serve.controller;

import com.aliyuncs.utils.StringUtils;
import com.example.serve.bean.CodeStatus;
import com.example.serve.bean.user.userLogin;
import com.example.serve.service.CompanyServiceImpl;
import com.example.serve.service.UserServiceImpl;
import com.example.serve.service.phone.SmsSendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
public class SendSmsController {
    @Autowired
    private SmsSendServiceImpl smsSendService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @RequestMapping("user/login/getTelCode")
    public CodeStatus UserSendSms(@RequestParam("tel") String tel ){
        CodeStatus codeStatus = new CodeStatus();
        Integer i = userService.loginByTelCode(tel);
        userLogin userlogin = new userLogin();
        if(i==-1){
            codeStatus.setCode(201);
            codeStatus.setMessage("用户不存在，请注册");
            return codeStatus;
        }else {
            String code = redisTemplate.opsForValue().get(tel);
            if(!StringUtils.isEmpty(code)){
                codeStatus.setCode(201);
                codeStatus.setMessage(tel + " : " + code + "已存在，还没有过期");
                return  codeStatus;
            }
            //生产随机验证码并存储到redis中
            Random random = new Random();
            //随机数：100000~999999
            int  randCode = random.nextInt(9000) +1000;
            code = randCode+"";
            String[] phoneNumber = {"+86"+tel};
            String[] templateParam = {code};
            boolean isOk = smsSendService.sendSms(phoneNumber,"908910","山楂树之恋",templateParam,"1400502965");
            if(!isOk){
                codeStatus.setCode(201);
                codeStatus.setMessage(tel + " : " + code + "发送失败");
                return codeStatus;
            }
            redisTemplate.opsForValue().set(tel,code,5, TimeUnit.MINUTES);
            codeStatus.setCode(i);
            codeStatus.setMessage(code);
        }
        return codeStatus;
    }

    /**
     * 公司账号注册，只有当账号未在本系统上注册，才能进行注册，才允许进一步填写工商信息，否侧返回提示信息
     * @param tel
     * @return
     */
    @RequestMapping("company/register/getTelCode")
    public CodeStatus companySendSms(@RequestParam("tel") String tel ){
        CodeStatus codeStatus = new CodeStatus();
        Integer i = companyService.loginByTelCode(tel);
        if(i!=-1){
            codeStatus.setCode(201);
            codeStatus.setMessage("账户已存在，请登录或尝试注册新的账号");
            return codeStatus;
        }else {
            String code = redisTemplate.opsForValue().get(tel);
            if(!StringUtils.isEmpty(code)){
                codeStatus.setCode(201);
                codeStatus.setMessage(tel + " : " + code + "已存在，还没有过期");
                return  codeStatus;
            }
            //生产随机验证码并存储到redis中
            Random random = new Random();
            //随机数：100000~999999
            int  randCode = random.nextInt(900000) +100000;
            code = randCode+"";
            String[] phoneNumber = {"+86"+tel};
            String[] templateParam = {code};
            System.out.println(tel);
            System.out.println(code);
            boolean isOk = smsSendService.sendSms(phoneNumber,"908910","山楂树之恋",templateParam,"1400502965");
            System.out.println(isOk);
            if(isOk){
                redisTemplate.opsForValue().set(tel,code,3, TimeUnit.SECONDS);
                codeStatus.setCode(200);
                codeStatus.setMessage(code);
                System.out.println(codeStatus);
            }else {
                codeStatus.setCode(201);
                codeStatus.setMessage(tel + " : " + code + "发送失败");
                return codeStatus;
            }
        }
        return codeStatus;
    }

}
