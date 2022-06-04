package com.testsql.pojo;

import lombok.Data;

@Data
public class User {
    public User() {}
    public User (String id, String username, String password, String name, String signature, Integer campuscode, Integer authlv){
        this.setUserID(id);
        this.setUserName(username);
        this.setPassword(password);
        this.setName(name);
        this.setSignature(signature);
        this.setCampusCode(campuscode);
        this.setAuthLv(authlv);
    }

    public String UserName;

    public String Signature;

    public String CampusName;

    public Integer CampusCode;

    public String Password;

    public String UserID;

    public String Name;

    public Integer AuthLv;

    public void setPassword(String pswin) { //Encoding
        Cipher cipher = new Cipher();
        String pswout = null;
        try {
            pswout = cipher.getPswoutput(pswin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.Password = pswout;
    }
}
