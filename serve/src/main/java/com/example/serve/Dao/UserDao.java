package com.example.serve.Dao;

import com.example.serve.bean.company.SubmitJob;
import com.example.serve.bean.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> getUserList();
    Integer loginById(User user);
    Integer loginByTelCode(String tel);
    //根据id插入数据
    void updateUserById(User user);
    //根据id查询user数据
    User getUserById(Integer userid);
    //根据tel查询用户是否存在
    String getACKByTel(User user);
    //根据姓名查UserList
    List<User> getUserListByName(String name);
    //更据职位查UserList
    List<User> getUserListByPosName(String posName);
    //根据用户的职位，筛选出岗位，模糊查询
    List<SubmitJob> getSubmitJobListByPosName(String posName);
    //修改comId
    void setUserComIdByFace(Integer userid,Integer comid);
}
