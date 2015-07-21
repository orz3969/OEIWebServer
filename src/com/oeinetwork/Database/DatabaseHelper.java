package com.oeinetwork.Database;

import com.oeinetwork.HibernateService;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by scotg_000 on 2015/7/18
 */
public class DatabaseHelper {

    public static HibernateService service;
    private Session session;
    private String errorMsg;

    public DatabaseHelper(){
    }

    public boolean saveAdvise(AdviceEntity entity){
        session = service.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            session.close();
            errorMsg = e.getMessage();
            return false;
        }
    }

    public boolean saveApplication(ApplyEntity entity) {
        session = service.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.close();
            errorMsg = e.getMessage();
            return false;
        }
    }

    public List getAllApplication() {
        session = service.getSession();
        Query query = session.createQuery("from ApplyEntity ");

        query.setCacheMode(CacheMode.GET);
        List list = query.list();
        session.close();
        return list;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
