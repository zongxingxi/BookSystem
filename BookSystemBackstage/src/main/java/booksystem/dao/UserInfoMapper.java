package booksystem.dao;

import booksystem.bean.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {
    @Select("select * from userinfo")
    List<UserInfo> getAllUsersInfo();

    @Select("select * from userinfo where studyid=#{StudyId}")
    UserInfo getUserInfo(String StudyId);
}
