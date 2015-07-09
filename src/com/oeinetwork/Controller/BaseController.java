package com.oeinetwork.Controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by scotg_000 on 2015/7/10
 */
public class BaseController implements Controller {
    private DoWork work;


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (verifyWork(request)) {
            return null;
        } else {
            if (work != null) {
                return work.executeJob(request);
            } else {
                throw new Exception("WorkNotAssignedException");
            }
        }

    }

    public interface DoWork {
        ModelAndView executeJob(HttpServletRequest request);
    }

    public void assignWork(DoWork input) {
        this.work = input;
    }

    private boolean verifyWork(HttpServletRequest request) {
        /**
         * verify works here
         */
        return false;
    }
}


