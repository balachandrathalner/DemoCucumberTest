package com.qa.data;

public class Login {


    private String userName;
    private String password;

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }


    public Login(String un, String pd){
        super();
        this.userName=un;
   
        this.password=pd;
    }
}
