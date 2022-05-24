package com.example.serve.controller;
import com.example.serve.bean.company.*;
import com.example.serve.bean.user.User;
import com.example.serve.bean.user.UserRecord;
import com.example.serve.bean.user.UserRecordSearch;
import com.example.serve.bean.user.userInfo;
import com.example.serve.service.*;
import com.example.serve.service.comRecord.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.serve.Utils.Decimal;

import java.util.*;

@Controller
public class RecordController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private EmployRecordServiceImpl employRecordService;
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private EventServiceImpl eventService;
    @Autowired
    private PerformanceServiceImpl performanceService;
    @Autowired
    private SumAttendanceServiceImpl sumAttendanceService;
    @Autowired
    private ExtrKillServiceImpl extrKillService;
    @Autowired
    private HonorServiceImpl honorService;
    @Autowired
    private PracticeServiceImpl practiceService;
    @Autowired
    private ProjectServiceImpl projectService;
    @CrossOrigin
    @RequestMapping(value = "/getUserRecord")
    @ResponseBody
    public UserRecord getUserRecord(@RequestParam(value = "comid",required = false) Integer comid,@RequestParam("userid") Integer userid){
        UserRecord userRecord = new UserRecord();
        userInfo userInfo = new userInfo();
        List<CompanyRecord> companyRecordList = new ArrayList<>();
        userInfo.setUser(userService.getUserById(userid));
        userInfo.setDomainSkills(extrKillService.getKillsById(userid));
        userInfo.setDomains(honorService.getHonorById(userid));
        userInfo.setDomainPractices(practiceService.getPracticeById(userid));
        userInfo.setDomainProjects(projectService.getProjectById(userid));
        userRecord.setId(userid);
        userRecord.setUserInfo(userInfo);
        if(comid!=null){
            //在员工入职的时候，或者在添加员工的时候，系统会自动为为一位员工添加一个空的attendance、performance、event、comment记录，预防了出现index不对称的情况
            List<SumAttendance> sumAttendanceArrayList = new ArrayList<>();
            sumAttendanceArrayList = sumAttendanceService.getSumAttendanceByUserIdNoComId(userid,comid);
            List<Performance> performanceArrayList = new ArrayList<>();
            performanceArrayList = performanceService.getPerformanceByUserIdNoComId(userid,comid);
            List<Event> eventArrayList = new ArrayList<>();
            eventArrayList = eventService.getEventByUserIdNoComId(userid,comid);
            List<Comment> commentArrayList = new ArrayList<>();
            commentArrayList = commentService.getCommentByUserIdNoComId(userid,comid);
            List<Integer> integerList = employRecordService.getEmployRecordNoComId(userid,comid);
            int index=0;
            for(Integer comId : integerList){
                System.out.println(index);
                System.out.println(sumAttendanceArrayList.get(index));
                CompanyRecord companyRecord = new CompanyRecord(comId,companyService.getCompanyById(comId).getName(),userid,
                        sumAttendanceArrayList.get(index),
                        performanceArrayList.get(index), eventArrayList.get(index), commentArrayList.get(index));
                companyRecordList.add(companyRecord);
                index++;
            }
            index=0;
            userRecord.setCompanyRecord(new CompanyRecord(comid,
                    companyService.getCompanyById(comid).getName(), userid,
                    sumAttendanceService.getSumAttendanceByUserIdAndComId(userid,comid),
                    performanceService.getPerformanceByUserIdAndComId(userid,comid),
                    eventService.getEventByUserIdAndComId(userid,comid),
                    commentService.getCommentByUserIdAndComId(userid,comid)
            ));
        }else {
            //在员工入职的时候，或者在添加员工的时候，系统会自动为为一位员工添加一个空的attendance、performance、event、comment记录，预防了出现index不对称的情况
            List<SumAttendance> sumAttendanceArrayList = new ArrayList<>();
            sumAttendanceArrayList = sumAttendanceService.getSumAttendanceByUserId(userid);
            List<Performance> performanceArrayList = new ArrayList<>();
            performanceArrayList = performanceService.getPerformanceByUserId(userid);
            List<Event> eventArrayList = new ArrayList<>();
            eventArrayList = eventService.getEventByUserId(userid);
            List<Comment> commentArrayList = new ArrayList<>();
            commentArrayList = commentService.getCommentByUserId(userid);
            List<Integer> integerList = employRecordService.getEmployRecordAll(userid);
            int index=0;
            for(Integer comId : integerList){
                System.out.println(index);
                System.out.println(sumAttendanceArrayList.get(index));
                CompanyRecord companyRecord = new CompanyRecord(comId,companyService.getCompanyById(comId).getName(),userid,
                        sumAttendanceArrayList.get(index),
                        performanceArrayList.get(index), eventArrayList.get(index), commentArrayList.get(index));
                companyRecordList.add(companyRecord);
                index++;
            }
            index=0;
            userRecord.setCompanyRecord(null);
        }
        userRecord.setCompanyRecordList(companyRecordList);
        userRecord.setCode(200);
        if(comid!=null){
            userRecord.setCompanyName(companyService.getCompanyById(comid).getName());
        }else{
            userRecord.setCompanyName(null);
        }

        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(userInfo.getUser().getBirth());
        calendar.setTime(new Date());
        Integer age = calendar.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);
        userRecord.setAge(age);

        if(userInfo.getUser().getSex()==0){
            userRecord.setSex("男");
        }else{
            userRecord.setSex("女");
        }
        return userRecord;
    }

    @CrossOrigin
    @RequestMapping(value = "/searchRecordList")
    @ResponseBody
    public List<UserRecordSearch> searchRecordList(@RequestParam(required = false,value = "maxLevelOrder") boolean maxLevelOrder,@RequestParam(required = false,value = "posName") String posName,@RequestParam("name") String name){
        List<User> userList = new ArrayList<>();
        if("".equals(posName)&&"".equals(name)){
            userList = userService.getUserList();
        }
        if("".equals(posName)&&!"".equals(name)){
            userList = userService.getUserListByName(name);
        }
        if(!"".equals(posName)&&"".equals(name)){
            userList = userService.getUserListByPosName(posName);
        }
        if(!"".equals(posName)&&!"".equals(name)){
            userList = new ArrayList<>();
            List<User> userList1 = userService.getUserListByName(name);
            List<User> userList2 = userService.getUserListByPosName(posName);
            TreeSet<Integer> userIdTreeSet = new TreeSet<>();
            for(User user : userList1){
                userIdTreeSet.add(user.getId());
            }
            for(User user : userList2){
                userIdTreeSet.add(user.getId());
            }
            Iterator<Integer> iterator = userIdTreeSet.iterator();
            while(iterator.hasNext()){
                userList.add(userService.getUserById(iterator.next()));
            }
        }
        List<UserRecordSearch> userRecordSearchList = new ArrayList<>();
        for(User user : userList){
            userRecordSearchList.add(new UserRecordSearch(user.getId(),user.getPhoto(),user.getName(),user.getMaxEduBack(),user.getPosname(),Decimal.getDecimals()));
        }
        if(maxLevelOrder==true){
            Collections.sort(userRecordSearchList, new Comparator<UserRecordSearch>() {
                @Override
                public int compare(UserRecordSearch o1, UserRecordSearch o2) {
                    if((o2.getLevel()-o1.getLevel())>0){
                        return 1;
                    }else if((o2.getLevel()-o1.getLevel())<0){
                        return -1;
                    }else {
                        return 0;
                    }
                }
            });
        }
        return userRecordSearchList;
    }
}

