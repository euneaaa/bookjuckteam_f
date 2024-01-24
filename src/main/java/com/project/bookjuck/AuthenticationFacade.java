package com.project.bookjuck;

import com.project.bookjuck.user.UserMapper;
import com.project.bookjuck.user.model.UserEntity;
import com.project.bookjuck.user.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;

@Component("utils")
public class AuthenticationFacade {

    @Autowired private UserMapper mapper;

    public UserEntity getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uid = auth.getName();
        UserEntity entity = new UserEntity();
        entity.setUid(uid);
        return mapper.selUser(entity);
    }
    public int getLoginUserPk() {
        return getLoginUser() == null ? 0 : getLoginUser().getIuser();
    }

    public UserVO getLoginUser2() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uid = auth.getName();
        UserEntity entity = new UserEntity();

        entity.setUid(uid);
        UserVO vo = mapper.selUser2(entity);
        vo.cutAddr(vo.getAddr());
        return vo;
    }

    public String textOverCut(String title, int len){
        if (len ==0 ) { // 기본값
            len = 10;
        }
        String lastTxt = "...";
        if (title.length() > len) {
            title = title.substring(0, len) + lastTxt;
        }
        return title;
    }


}