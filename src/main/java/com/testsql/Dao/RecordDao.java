package com.testsql.Dao;

import com.testsql.pojo.LFObject;
import com.testsql.pojo.Rec;

import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class RecordDao extends SqlDaoSupport{
    public Rec record;

    public RecordDao(Rec record) {
        super();
        this.record = record;
    }

    public Rec getRecord(){
        return record;
    }

    public boolean recExistCheck() throws Exception{
        boolean flag = false;
        String sql = "SELECT\n" +
                "	objinfo.ObjID,\n" +
                "	postedinfo.LFType \n" +
                "FROM\n" +
                "	testsql.objinfo\n" +
                "	INNER JOIN testsql.postedinfo ON objinfo.ObjID = postedinfo.ObjID\n" +
                "WHERE\n" +
                "   objinfo.ObjID = ? AND postedinfo.LFType <> ? AND objinfo.Matched = 0";
        PreparedStatement pstmt = null;
        ResultSet res;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, record.getLfObject().getObjID());
            pstmt.setInt(2, record.getLFType());
            res = pstmt.executeQuery();
            if (res.next()) {
                flag = true;
            }
        } finally {
            pstmt.close();

        }
        return flag;
    }

    public void save() throws Exception {
        String sql1 = "INSERT INTO testsql.objinfo (ObjID, ObjName, Description, Matched, MatchTime, ClassID) VALUE (?,?,?,?,?,?)";
        String sql2 = "INSERT INTO testsql.postedinfo (ObjID, PosUser, LFType, PosTime, PosCampus) VALUE (?,?,?,?,?)";
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            conn.setAutoCommit(false);

            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setString(1, record.getLfObject().getObjID());
            pstmt1.setString(2, record.getLfObject().getObjName());
            pstmt1.setString(3, record.getLfObject().getDescription());
            pstmt1.setInt(4, record.getLfObject().getMatched());
            pstmt1.setTimestamp(5, record.getLfObject().getMatchTime());
            pstmt1.setInt(6, record.getLfObject().getClassID());
            pstmt1.executeUpdate();

            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, record.getLfObject().getObjID());
            pstmt2.setString(2, record.getPosUser());
            pstmt2.setInt(3, record.getLFType());
            pstmt2.setTimestamp(4, record.getPosTime());
            pstmt2.setInt(5, record.getPosCampus());
            pstmt2.executeUpdate();

            conn.commit();
        } finally {
            if (pstmt1!=null) {
                pstmt1.close();
            }
            if (pstmt2!=null) {
                pstmt2.close();
            }
            conn.setAutoCommit(true);

        }
    }

    public void match() throws Exception {
        String sql = "UPDATE testsql.objinfo SET Matched = 1 WHERE ObjID = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, record.getLfObject().getObjID());
            pstmt.executeUpdate();
        } finally {
            pstmt.close();

        }
    }

    public void delete() throws Exception {
        String sql1 = "DELETE FROM testsql.postedinfo WHERE ObjID = ?";
        String sql2 = "DELETE FROM testsql.objinfo WHERE ObjID = ?";
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            conn.setAutoCommit(false);

            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setString(1, record.getLfObject().getObjID());
            pstmt1.executeUpdate();

            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, record.getLfObject().getObjID());
            pstmt2.executeUpdate();

            conn.commit();
        } finally {
            if (pstmt1!=null) {
                pstmt1.close();
            }
            if (pstmt2!=null) {
                pstmt2.close();
            }
            conn.setAutoCommit(true);

        }
    }

    public void edit() throws Exception {
        String sql1 = "UPDATE testsql.objinfo SET ObjName = ?, Description = ?, Matched = ?, ClassID = ? WHERE ObjID = ?";
        String sql2 = "UPDATE testsql.postedinfo SET PosUser = ?, LFType = ?, PosTime = ?, PosCampus = ? WHERE ObjID = ?";
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            conn.setAutoCommit(false);

            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setString(1, record.getLfObject().getObjName());
            pstmt1.setString(2, record.getLfObject().getDescription());
            pstmt1.setInt(3, record.getLfObject().getMatched());
            pstmt1.setInt(4, record.getLfObject().getClassID());
            pstmt1.setString(5, record.getLfObject().getObjID());
            pstmt1.executeUpdate();

            pstmt2 = conn.prepareStatement(sql2);

            pstmt2.setString(1, record.getPosUser());
            pstmt2.setInt(2, record.getLFType());
            pstmt2.setTimestamp(3, record.getPosTime());
            pstmt2.setInt(4, record.getPosCampus());
            pstmt2.setString(5, record.getLfObject().getObjID());
            pstmt2.executeUpdate();

            conn.commit();
        } finally {
            if (pstmt1!=null) {
                pstmt1.close();
            }
            if (pstmt2!=null) {
                pstmt2.close();
            }
            conn.setAutoCommit(true);

        }
    }

    public ArrayList<Rec> fetchAll() throws Exception {
        ArrayList<Rec> recordList;
        recordList = new ArrayList<>();

        String sql = "SELECT\n" +
                "	objinfo.ObjName,\n" +
                "   objinfo.ObjID,\n" +
                "	objinfo.Description,\n" +
                "	postedinfo.LFType,\n" +
                "	userinfo.UserName,\n" +
                "	campusinfo.CampusName,\n" +
                "	postedinfo.PosTime,\n" +
                "	class.ClassName \n" +
                "FROM\n" +
                "	testsql.postedinfo\n" +
                "	INNER JOIN testsql.objinfo ON postedinfo.ObjID = objinfo.ObjID\n" +
                "	INNER JOIN testsql.userinfo ON postedinfo.PosUser = userinfo.ID\n" +
                "	INNER JOIN testsql.campusinfo ON userinfo.CampusCode = campusinfo.CampusCode \n" +
                "	INNER JOIN testsql.class ON objinfo.ClassID = class.ClassID";
        PreparedStatement pstmt = null;
        ResultSet res;
        try {
            pstmt = conn.prepareStatement(sql);
            res = pstmt.executeQuery();

            while (res.next()) {
                LFObject lfObject = new LFObject(res.getString("ObjID"), res.getString("ObjName"), res.getString("Description"));
                lfObject.setClassName(res.getString("ClassName"));
                Rec record = new Rec();
                record.setLfObject(lfObject);
                record.setLFType(res.getInt("LFType"));
                record.setPosUserName(res.getString("UserName"));
                record.setPosCampusName(res.getString("CampusName"));
                record.setPosTime(res.getTimestamp("PosTime"));

                recordList.add(record);
            }
        } finally {
            pstmt.close();
        }
        return recordList;
    }

    public LFObject getObjectInfo() throws Exception {
        LFObject objres = record.getLfObject();
        String objid = record.getLfObject().getObjID();
        String sql = "SELECT\n" +
                "	objinfo.ObjName,\n" +
                "	objinfo.Description,\n" +
                "	objinfo.Matched,\n" +
                "	objinfo.MatchTime,\n" +
                "	class.ClassName \n" +
                "FROM\n" +
                "	testsql.objinfo\n" +
                "	INNER JOIN testsql.class ON objinfo.ClassID = class.ClassID\n" +
                "WHERE\n" +
                "   objinfo.ObjID = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, objid);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                objres.setObjName(res.getString("ObjName"));
                objres.setDescription(res.getString("Description"));
                objres.setClassName(res.getString("ClassName"));
                objres.setMatchTime(res.getTimestamp("MatchTime"));
            }
        } finally {

        }
        return objres;
    }

    public Rec fetchFullRec() throws Exception {
        Rec resRecord = record;
        String sql = "SELECT\n" +
                "	objinfo.ObjID,\n" +
                "	objinfo.ObjName,\n" +
                "	objinfo.Description,\n" +
                "	objinfo.Matched,\n" +
                "	objinfo.ClassID,\n" +
                "	postedinfo.LFType,\n" +
                "   postedinfo.PosUser, \n" +//ID
                "   userinfo.UserName,\n" +
                "	postedinfo.PosTime,\n" +
                "	postedinfo.PosCampus \n" +
                "FROM\n" +
                "	testsql.objinfo\n" +
                "	INNER JOIN testsql.postedinfo ON objinfo.ObjID = postedinfo.ObjID\n" +
                "	INNER JOIN testsql.userinfo ON postedinfo.PosUser = userinfo.ID \n" +
                "WHERE\n" +
                "   objinfo.ObjID = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, record.getLfObject().getObjID());
            ResultSet res = pstmt.executeQuery();
            res.next();
            LFObject lfObject = new LFObject();
            lfObject.setObjID(res.getString("ObjID"));
            lfObject.setObjName(res.getString("ObjName"));
            lfObject.setDescription(res.getString("Description"));
            lfObject.setMatched(res.getInt("Matched"));
            lfObject.setClassID(res.getInt("ClassID"));
            resRecord.setLfObject(lfObject);
            resRecord.setPosUser(res.getString("PosUser"));
            resRecord.setPosUserName(res.getString("UserName"));
            resRecord.setLFType(res.getInt("LFType"));
            resRecord.setPosTime(res.getTimestamp("PosTime"));
            resRecord.setPosCampus(res.getInt("PosCampus"));
        }finally {

        }

        return  resRecord;
    }
}
