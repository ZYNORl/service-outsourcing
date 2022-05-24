package com.example.serve.service;

import com.example.serve.Dao.UserDao;
import com.example.serve.bean.company.SubmitJob;
import com.example.serve.bean.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public Integer loginById(User user) {
        if(userDao.loginById(user)!=null){
            return userDao.loginById(user);
        }else
        {
            return -1;
        }

    }

    @Override
    public Integer loginByTelCode(String tel) {
        if(userDao.loginByTelCode(tel)!=null){
            return userDao.loginByTelCode(tel);
        }else
        {
            return -1;
        }
    }

    @Override
    public void updateUserById(User user) {
        userDao.updateUserById(user);
    }

    @Override
    public User getUserById(Integer userid) {
        return userDao.getUserById(userid);
    }

    @Override
    public String getACKByTel(User user) {
        return userDao.getACKByTel(user);
    }

    @Override
    public List<User> getUserListByName(String name) {
        return userDao.getUserListByName(name);
    }

    @Override
    public List<User> getUserListByPosName(String posName) {
        return userDao.getUserListByPosName(posName);
    }

    @Override
    public List<SubmitJob> getSubmitJobListByPosName(String posName) {
        return userDao.getSubmitJobListByPosName(posName);
    }

    @Override
    public void setUserComIdByFace(Integer userid, Integer comid) {
        userDao.setUserComIdByFace(userid, comid);
    }
}
