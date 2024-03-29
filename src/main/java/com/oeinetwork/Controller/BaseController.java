package com.oeinetwork.Controller;

import com.oeinetwork.Models.VerifyModel;
import com.oeinetwork.Views.ErrorView;
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
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        VerifyModel model = work.getVerifyInfo(request);
        if (model != null) {
            if (!model.verify()) {
                return new ModelAndView(new ErrorView(), model.getErrors());
            } else {
                return work.executeJob(request);
            }
        } else {
            if (work != null) {
                return work.executeJob(request);
            } else {
                return new ModelAndView(new ErrorView(), null);
            }
        }
    }


    public void assignWork(DoWork input) {
        this.work = input;
    }

    public interface DoWork {
        ModelAndView executeJob(HttpServletRequest request);

        VerifyModel getVerifyInfo(HttpServletRequest request);
    }

}


