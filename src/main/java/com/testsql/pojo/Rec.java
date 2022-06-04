package com.testsql.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Rec {
    
    public Rec() {}

    public Rec(LFObject lfobject, String posuser, Integer lftype, Timestamp postime, Integer poscampus) {
        this.lfObject = lfobject;
        this.PosUser = posuser;
        this.LFType = lftype;
        this.PosTime = postime;
        this.PosCampus = poscampus;
    }

    public Rec(LFObject lfObject) {
        this.lfObject = lfObject;
    }

    public LFObject lfObject;

    public String PosUser;

    public String PosUserName;

    public Integer LFType;

    public Timestamp PosTime;

    public Integer PosCampus;

    public String PosCampusName;

}
