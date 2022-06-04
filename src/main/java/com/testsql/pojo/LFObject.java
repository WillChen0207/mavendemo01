package com.testsql.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class LFObject {
    public LFObject(){}

    public LFObject(String objid, String objname, String description) {
        this.ObjID = objid;
        this.ObjName = objname;
        if (description == null  || description.equals("")) {
            this.Description = "No description.";
        } else {
            this.Description = description;
        }
    }

    public String ObjID;

    public String ObjName;

    public String Description;

    public Integer Matched;

    public Timestamp MatchTime;

    public Integer ClassID;

    public String ClassName;

    public void setObjID(String objID) {
        String tmp = "";
        if (this.ClassID != null) {
            switch (this.ClassID) {
                case 1: {
                    tmp = "A";
                    break;
                }
                case 2: {
                    tmp = "B";
                    break;
                }
                case 3: {
                    tmp = "C";
                    break;
                }
                case 4: {
                    tmp = "D";
                    break;
                }
                default:{}
            }
        }
        this.ObjID = tmp + objID;
    }
}
