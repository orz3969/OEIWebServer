package com.oeinetwork.Controller;

import com.oeinetwork.Database.ApplyBean;
import com.oeinetwork.Database.DatabaseHelper;
import com.oeinetwork.Models.CodeVerify;
import com.oeinetwork.Models.VerifyModel;
import com.oeinetwork.Views.ConfirmView;
import com.oeinetwork.Views.ErrorView;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Project OEIWebServer
 * Created by scotg_000 on 2015/7/20.
 */
public class ApplyController extends BaseController {
    public ApplyController() {
        this.assignWork(new ApplyWork());
    }

    class ApplyWork implements DoWork {

        @Override
        public ModelAndView executeJob(HttpServletRequest request) {
            DatabaseHelper helper = new DatabaseHelper();
            ApplyBean apply = new ApplyBean();
            apply.setContact(request.getParameter("phoneNum"));
            apply.setDayOfBirth(request.getParameter("date_of_birth"));
            apply.setFirstApply(request.getParameter("firstWish"));
            apply.setFutureVision(request.getParameter("future_vision"));
            apply.setMajor(request.getParameter("major"));
            apply.setPolitic(request.getParameter("politic"));
            apply.setName(request.getParameter("name"));
            apply.setSecondApply(request.getParameter("secondWish"));
            apply.setSelfIntroduction(request.getParameter("self_introduction"));
            apply.setSex(request.getParameter("sex"));
            apply.setThirdApply(request.getParameter("thirdWish"));
            apply.setWorkExp(request.getParameter("work_exp"));
            if (helper.saveApplication(apply)) {
                return new ModelAndView(new ConfirmView(), null);
            } else {
                HashMap<String, String> error = new HashMap<>();
                error.put("error_msg", "Hibernate  " + helper.getErrorMsg());
                return new ModelAndView(new ErrorView(), error);
            }
        }

        @Override
        public VerifyModel getVerifyInfo(HttpServletRequest request) {
            return new CodeVerify(request);
        }
    }
}
