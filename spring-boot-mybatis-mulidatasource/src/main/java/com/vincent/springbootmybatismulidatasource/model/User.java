package com.vincent.springbootmybatismulidatasource.model;

public class User {

    private static final long serialVersionUID = 1L;

    public long id;
    public String userName;
    public String nickName;
    public String passWord;
    public UserSexEnum userSex;

    public User() {
        super();
    }

    public User(String userName, String passWord, UserSexEnum userSex) {
        super();
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
    }

    public User(String userName, String passWord, UserSexEnum userSex, long id) {
        super();
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }


    //    public String getNickName() {
//        return nickName;
//    }
//
//    public void setNickName(String nickName) {
//        this.nickName = nickName;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "nickName='" + nickName + '\'' +
//                '}';
//    }
}
