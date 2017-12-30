package booksystem.service;

import booksystem.bean.UserInfo;
import booksystem.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public Boolean login(UserInfo logininfo){
        UserInfo userInfo = this.userInfoMapper.getUserInfo(logininfo.getStudentId());
        if (userInfo == null)
        {
            return false;
        }
        return true;
    }
}
