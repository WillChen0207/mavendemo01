package com.testsql.Service;

import com.testsql.Dao.RecordDao;
import com.testsql.pojo.LFObject;
import com.testsql.pojo.Rec;

import java.util.ArrayList;

public class RecService {
    public RecordDao recordDao;

    public RecService(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public void submit() throws Exception {
        recordDao.save();
    }

    public void match() throws Exception {
        recordDao.match();
    }

    public void delete() throws Exception {
        recordDao.delete();
    }

    public void edit() throws Exception {
        recordDao.edit();
    }

    public boolean existCheck() throws Exception{
        return recordDao.recExistCheck();
    }

    public ArrayList<Rec> fetchAll() throws Exception{
        return recordDao.fetchAll();
    }

    public LFObject getObjectInfo() throws Exception {
        return recordDao.getObjectInfo();
    }

    public RecordDao fetchFullRec() throws Exception {
        return new RecordDao(recordDao.fetchFullRec());
    }
}
