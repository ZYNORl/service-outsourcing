package com.example.serve.controller;

import com.example.serve.bean.*;
import com.example.serve.bean.company.*;
import com.example.serve.bean.user.User;
import com.example.serve.service.CompanyServiceImpl;
import com.example.serve.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class companyController {

    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @CrossOrigin
    @RequestMapping(value = "/getEmployees")
    @ResponseBody
    public ComEmployeeBody getUsers(@RequestParam("comid") Integer comid, @RequestParam("pagenum") Integer pagenum, @RequestParam("pagesize") Integer pagesize){
        ArrayList<Employee> list = new ArrayList<Employee>();
        Calendar cale = Calendar.getInstance();
        cale.setTime(new Date());
        int yearNow = cale.get(Calendar.YEAR);
            for(User user : companyService.getUsersByComId(comid)){
                int year = -1;
                Calendar calendar = Calendar.getInstance();
                if(user.getBirth()!=null){
                    calendar.setTime(user.getBirth());
                    year = calendar.get(Calendar.YEAR);
                    year = yearNow-year;
                }else{
                    year = -1;
                }
                Employee employee=new Employee(user.getId(),user.getName(),user.getPosname(),year,user.getMaxEduBack(),user.getEmail(),user.getTel(),user.getStatus());
                list.add(employee);
            }
        int index = pagenum-1;
        int total = list.size();
        int totalPages = 0;
        if(total%pagesize == 0){
            totalPages = total/pagesize;
        }else{
            totalPages = total/pagesize+1;
        }
        List<Employee> new_list = new ArrayList<Employee>();
        new_list = list.subList(index*pagesize,(index+1)*pagesize>total?total:(index+1)*pagesize);
        ComEmployeeBody comEmployeeBody = new ComEmployeeBody();
        comEmployeeBody.setCode(200);
        comEmployeeBody.setPagenum(pagenum);
        comEmployeeBody.setTotal(total);
        comEmployeeBody.setTotalpage(totalPages);
        comEmployeeBody.setUsers(new_list);
        return comEmployeeBody;
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/company/login")
    public CompanyLogin login(@RequestBody Company company) {
        Integer i = companyService.loginById(company);
        CompanyLogin companyLogin = new CompanyLogin();
        System.out.println(i);
        if(i==-1){
            companyLogin.setStatus(201);
        }else {
            companyLogin.setStatus(200);
        }
        companyLogin.setComId(i);
        return companyLogin;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("company/getDetail")
    public Company getDetail(@RequestParam("comid") Integer comid) {
        return  companyService.getCompanyById(comid);
    }
    @CrossOrigin
    @ResponseBody
    @GetMapping("company/setIntroduce")
    public String DesetIntroducetail(@RequestParam("comid") Integer comid,@RequestParam("introduce") String introduce,@RequestParam("personnum") String personnum) {
        companyService.setIntroduce(introduce, comid,personnum);
        return  companyService.getCompanyById(comid).getIntroduce();
    }
    @CrossOrigin
    @ResponseBody
    @PostMapping("company/addSubmitJob")
    public Integer addSubmitJob(@RequestBody SubmitJob submitJob) {
        return companyService.addSubmitJob(submitJob);
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("company/submitJob")
    public void submitJob(@RequestBody JobScoreList jobScoreList) {
        String code = jobScoreList.getId().toString();
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for(Integer integer : jobScoreList.getScorelist()){
            if(flag){
                result.append(",");
            }else {
                flag = true;
            }
            result.append(integer);
        }
        redisTemplate.opsForValue().set(code,result.toString(),5, TimeUnit.DAYS);
        System.out.println("xxx"+redisTemplate.opsForValue().get(code));
    }

    /**
     * 企业端添加员工，验证员工是否存在（注册过系统）或是否已经在企业员工列表中
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping("/company/addUser")
    public CodeStatus CompanyAddUser(@RequestBody User user){
        Integer comid = user.getComid();
        user.setComid(null);
        CodeStatus codeStatus = new CodeStatus(200,"校验成功");
        Integer userid = companyService.getUseridByUserInfo(user);
        if(userid==-1){
            codeStatus.setCode(201);
            codeStatus.setMessage("员工不存在，或未完善基本个人信息");
            return codeStatus;
        }
        List<User> userList = companyService.getUsersByComId(comid);
        int ans = -1;
        for(User user1 : userList){
            if(user1.getComid()==userService.getUserById(userid).getComid()){
                ans++;
            }
        }
        if(ans!=-1){
            codeStatus.setCode(201);
            codeStatus.setMessage("添加用户，已经在员工列表中，无需再进行操作");
            return codeStatus;
        }
        codeStatus.setCode(userid);
        return  codeStatus;
    }
//    @CrossOrigin
//    @ResponseBody
//    @RequestMapping("/company/AttendanceUser")
//    public AttendanceBody getAttendanceByUserIdAndComId(@RequestParam Integer userid,Integer comid){
//        Attendance attendanceByUserIdAndComId = companyService.getAttendanceByUserIdAndComId(userid, comid);
//        User user = userService.getUserById(attendanceByUserIdAndComId.getUserid());
//        return new AttendanceBody(user.getPosname(),user.getName(),
//                attendanceByUserIdAndComId.getLeavenum(),
//                attendanceByUserIdAndComId.getLatenum(),
//                attendanceByUserIdAndComId.getCardnum(),
//                attendanceByUserIdAndComId.getOverworknum(),
//                attendanceByUserIdAndComId.getDotime());
//    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/company/AttendanceUserListByDate")
    public List<AttendanceBody> getAttendanceListByComIdByDate(@RequestParam(required = false,value = "firstDate") String fistDate,@RequestParam(required = false,value = "lastDate") String lastDate,@RequestParam("comid") Integer comid){
        List<Attendance> attendanceArrayList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(fistDate.equals(simpleDateFormat.format(new Date()))&&lastDate.equals(simpleDateFormat.format(new Date()))){
            attendanceArrayList = companyService.getAttendanceListByComId(comid);
        }else{
            attendanceArrayList = companyService.getAttendanceListByDate(fistDate, lastDate, comid);
        }
        List<AttendanceBody> attendanceBodyList  = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(Attendance attendance : attendanceArrayList){
            treeSet.add(attendance.getUserid());
        }
        Iterator<Integer> iter = treeSet.iterator();
        while (iter.hasNext()){
            User user = userService.getUserById(iter.next());
            List<Attendance> attendanceByUserIdAndComId = companyService.getAttendanceByUserIdAndComId(user.getId(), comid);
            int leaveNum = 0, lateNum = 0, cardNum = 0, overworkNum = 0;
            for(Attendance attendance : attendanceByUserIdAndComId){
                leaveNum += attendance.getLeavenum()!=null?attendance.getLeavenum():0;
                lateNum += attendance.getLatenum()!=null?attendance.getLatenum():0;
                cardNum += attendance.getCardnum()!=null?attendance.getCardnum():0;
                overworkNum += attendance.getOverworknum()!=null?attendance.getOverworknum():0;
            }
            attendanceBodyList.add(new AttendanceBody(
                    user.getId(),
                    user.getPosname(),user.getName(),
                    leaveNum,lateNum,cardNum,overworkNum,
                    attendanceArrayList.get(0).getDotime()));
        }
        return attendanceBodyList;
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/company/editAttendance")
    public CodeStatus editAttendance(@RequestBody Attendance attendance){
        CodeStatus codeStatus = new CodeStatus();
        codeStatus.setCode(201);
        codeStatus.setMessage("编辑信息提交失败");
        companyService.editAttendance(attendance);
        codeStatus.setCode(200);
        codeStatus.setMessage("编辑信息提交成功");
        return codeStatus;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/company/editEmployeeRecord")
    public CodeStatus editEmployeeRecord(@RequestParam("userid")Integer userid,@RequestParam("comid")Integer comid,@RequestParam(required = false,value = "performance") String performance,@RequestParam(required = false,value = "comment") String comment,@RequestParam(required = false,value = "event") String event){
        CodeStatus codeStatus = new CodeStatus(201,"修该员工档案失败");
        companyService.updatePerformance(new Performance(userid,comid,performance));
        companyService.updateComment(new Comment(userid,comid,comment));
        companyService.updateEvent(new Event(userid,comid,event));
        codeStatus.setCode(200);
        codeStatus.setMessage("修改员工档案成功");
        return codeStatus;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/company/getEmployeeRecord")
    public List<String> getEmployeeRecord(@RequestParam("userid")Integer userid,@RequestParam("comid")Integer comid){
        List<String> strings = new ArrayList<>();
        strings.add(companyService.getPerformance(userid, comid));
        strings.add(companyService.getComment(userid, comid));
        strings.add(companyService.getEvent(userid, comid));
        return strings;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("company/face/addUser")
    public CodeStatus addUserByFace(@RequestParam("userid")Integer userid,@RequestParam("comid")Integer comid){
        CodeStatus codeStatus = new CodeStatus(201, "添加识别");
        userService.setUserComIdByFace(userid, comid);
        codeStatus.setCode(200);
        codeStatus.setMessage("操作成功");
        return codeStatus;
    }
}
