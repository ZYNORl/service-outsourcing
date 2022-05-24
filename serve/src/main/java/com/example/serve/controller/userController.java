package com.example.serve.controller;

import com.example.serve.Utils.Decimal;
import com.example.serve.bean.*;
import com.example.serve.bean.company.Job;
import com.example.serve.bean.company.JobDetail;
import com.example.serve.bean.company.JobScoreList;
import com.example.serve.bean.company.SubmitJob;
import com.example.serve.bean.user.User;
import com.example.serve.bean.user.userInfo;
import com.example.serve.bean.user.userLogin;
import com.example.serve.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class userController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private HonorServiceImpl honorService;
    @Autowired
    private ExtrKillServiceImpl extrKillService;
    @Autowired
    private PracticeServiceImpl practiceService;
    @Autowired
    private ProjectServiceImpl projectService;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @CrossOrigin
    @RequestMapping("/login")
    public String login(){return "login";}
    @CrossOrigin
    @RequestMapping("/toMain")
    public String toMain(){return "main";}
    @CrossOrigin
    @RequestMapping("/toError")
    public String toError(){return "error";}
    /**
     * 登录
     *
     * @param user 参数封装
     * @return Result
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping("/user/login")
    public userLogin login(@RequestBody User user) {
        Integer i = userService.loginById(user);
        userLogin userlogin = new userLogin();
        System.out.println(i);
        if(i==-1){
            userlogin.setStatus(201);
            userlogin.setMessage("账号或密码错误");
        }else {
            userlogin.setStatus(200);
            userlogin.setMessage("恭喜您，登录成功");
        }
        userlogin.setUseId(i);
        return userlogin;
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("getComIdByUserId")
    public Integer getComIdByUserId(@RequestParam("userid") Integer userid){
        return userService.getUserById(userid).getComid();
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("searchJobList")
    public List<Job> searchJobList(@RequestParam("userid") Integer userid){
        List<Job> jobList = new ArrayList<>();
        String posname = userService.getUserById(userid).getPosname();
        List<SubmitJob> submitJobList = new ArrayList<>();
        submitJobList = userService.getSubmitJobListByPosName(posname);
        for(SubmitJob submitJob : submitJobList){
            String scores = redisTemplate.opsForValue().get(submitJob.getId().toString());
            System.out.println(scores);
            ArrayList<Integer> scoreList01 = new ArrayList<>();
            ArrayList<Integer> scoreList02 = new ArrayList<>();
            for(int i=0;i<scores.length();i++){
                if(scores.charAt(i)!=','){
                    scoreList01.add(scores.charAt(i)-'0');
                }
            }
            for(int j=0;j<scoreList01.size();j+=2){
                scoreList02.add(scoreList01.get(j)*10+scoreList01.get(j+1));
            }

            jobList.add(new Job(Decimal.getDecimals(),submitJob, companyService.getCompanyById(submitJob.getComid()),scoreList02));
        }
        return jobList;
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("getJobDetail")
    public JobDetail getJobDetail(@RequestParam("JobId") Integer JobId){
        String scores = redisTemplate.opsForValue().get(JobId.toString());
        System.out.println(scores);
        ArrayList<Integer> scoreList1 = new ArrayList<>();
        ArrayList<Integer> scoreList2 = new ArrayList<>();
        for(int i=0;i<scores.length();i++){
            if(scores.charAt(i)!=','){
                scoreList1.add(scores.charAt(i)-'0');
            }
        }
        for(int j=0;j<scoreList1.size();j+=2){
            scoreList2.add(scoreList1.get(j)*10+scoreList1.get(j+1));
        }
        //scoreList2是职位的数据，
        return new JobDetail(
                new Job(Decimal.getDecimals(),companyService.getSubmitJob(JobId),companyService.getCompanyById(companyService.getSubmitJob(JobId).getComid()),scoreList2),
                new JobScoreList(JobId,scoreList2)
        );

    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/user/info")
    public void info(@RequestBody userInfo userInfo) {
        System.out.println(userInfo);
        //个人基本信息
        User user = new User();
        user = userInfo.getUser();
        userService.updateUserById(user);

        //技能
        for(extrkill extrkill : userInfo.getDomainSkills()){
            extrkill.setUserid(userInfo.getUser().getId());
            extrKillService.InsetExtrkill(extrkill);
        }

        //荣誉
        for(honor ho : userInfo.getDomains()){
            ho.setUserid(userInfo.getUser().getId());
            honorService.insertHonor(ho);
        }
        //实习
        for(practice practice : userInfo.getDomainPractices()){
            practice.setUserid(userInfo.getUser().getId());
            practiceService.InsertPractice(practice);
        }

        //项目
        for(project project : userInfo.getDomainProjects()){
            project.setUserid(userInfo.getUser().getId());
            projectService.InsertProject(project);
        }
    }
}
