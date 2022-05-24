package com.example.serve.service;

import com.example.serve.bean.company.SubmitJob;
import com.example.serve.bean.user.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    Integer loginByTelCode(String tel);
    Integer loginById(User user);
    void updateUserById(User user);
    User getUserById(Integer userid);
    String getACKByTel(User user);
    List<User> getUserListByName(String name);
    List<User> getUserListByPosName(String posName);
    //根据用户的职位，筛选出岗位，模糊查询
    List<SubmitJob> getSubmitJobListByPosName(String posName);
    void setUserComIdByFace(Integer userid,Integer comid);
}
