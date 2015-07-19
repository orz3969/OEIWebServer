package com.oeinetwork.Database;

import com.oeinetwork.HibernateService;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by scotg_000 on 2015/7/18
 */
public class DatabaseHelper {

    public static HibernateService service;
    private Session session;
    private String errorMsg;

    public DatabaseHelper(){
        service = new HibernateService();
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

    public String getErrorMsg() {
        return errorMsg;
    }
}
