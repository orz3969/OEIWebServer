package com.oeinetwork.Database;

import com.oeinetwork.HibernateService;
import com.oeinetwork.Utils.JSONUtil;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by scotg_000 on 2015/7/18
 */
public class DatabaseHelper {
    private Session session;
    private String errorMsg;

    public DatabaseHelper(){
    }

    public boolean saveAdvise(AdviceBean entity) {
        session = HibernateService.getSession();
        ActivityEntity activity = new ActivityEntity();
        activity.setActivityName("advice");
        activity.setRecordTime(System.currentTimeMillis());
        activity.setActivityData(JSONUtil.translateBeanIntoJSON(entity, "advice"));
        Transaction transaction = session.beginTransaction();
        try {
            session.save(activity);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            session.close();
            e.printStackTrace();
            errorMsg = e.getMessage();
            return false;
        }
    }

    public boolean saveApplication(ApplyBean entity) {
        session = HibernateService.getSession();
        ActivityEntity activity = new ActivityEntity();
        activity.setActivityName("apply");
        activity.setRecordTime(System.currentTimeMillis());
        activity.setActivityData(JSONUtil.translateBeanIntoJSON(entity, "apply"));
        Transaction transaction = session.beginTransaction();
        try {
            session.save(activity);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            errorMsg = e.getMessage();
            return false;
        }
    }

    public boolean saveCompetition(CompeteBean bean) {
        session = HibernateService.getSession();
        ActivityEntity activity = new ActivityEntity();
        activity.setActivityName("compete");
        activity.setRecordTime(System.currentTimeMillis());
        activity.setActivityData(JSONUtil.translateBeanIntoJSON(bean, "compete"));
        Transaction transaction = session.beginTransaction();
        try {
            session.save(activity);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            errorMsg = e.getMessage();
            return false;
        }
    }

    public List getAllApplication() {
        session = HibernateService.getSession();
        Query query = session.createQuery("from ActivityEntity where activityName = 'apply'");
        List list = query.list();
        session.close();
        return list;
    }

    public List getAllCompete() {
        session = HibernateService.getSession();
        Query query = session.createQuery("from ActivityEntity where activityName = 'compete'");
        List list = query.list();
        session.close();
        return list;
    }

    public List getAllResponse() {
        session = HibernateService.getSession();
        Query query = session.createQuery("from ResponseEntity ");
        query.setCacheable(true);
        List list = query.list();
        session.close();
        return list;
    }

    public boolean saveResponse(ResponseEntity entity) {
        session = HibernateService.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            errorMsg = e.getMessage();
            return false;
        }
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
