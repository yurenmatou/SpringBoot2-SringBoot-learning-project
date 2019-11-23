package com.vincent.springbootmongomultidatasource.model;

import java.io.Serializable;

public class User implements Serializable {

//    serialVersionUID

    private String userName;
    private long id;
    private String nickName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                ", nickName='" + nickName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
