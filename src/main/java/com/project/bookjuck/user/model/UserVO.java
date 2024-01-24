package com.project.bookjuck.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.tomcat.jni.User;

@Getter
@Setter
@ToString
public class UserVO extends UserEntity {
    private String email1;
    private String email2;

    private String addr1;
    private String addr2;

    public String totalEmail(String email1, String email2){
        this.email1 = email1;
        this.email2 = email2;
        return email1 + "@" + email2;
    }

    public String totalAddr(){

        return addr1 +", " + addr2;
    }

    public void cutAddr(String addr){

        String[] Addrs = addr.split(", ");
        this.addr1 = Addrs[0];
        this.addr2 = Addrs[1];
    }


}
