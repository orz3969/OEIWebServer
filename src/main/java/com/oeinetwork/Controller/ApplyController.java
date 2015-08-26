package com.oeinetwork.Controller;

import com.oeinetwork.Database.ApplyBean;
import com.oeinetwork.Database.DatabaseHelper;
import com.oeinetwork.Models.CodeVerify;
import com.oeinetwork.Models.VerifyModel;
import com.oeinetwork.Views.ConfirmView;
import com.oeinetwork.Views.ErrorView;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
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
            try {
                request.setCharacterEncoding("UTF-8");
                apply.setContact(new String((request.getParameter("phoneNum")).getBytes("ISO-8859-1"), "UTF-8"));
                apply.setDayOfBirth(new String((request.getParameter("date_of_birth")).getBytes("ISO-8859-1"), "UTF-8"));
                apply.setFirstApply(new String((request.getParameter("firstWish")).getBytes("ISO-8859-1"), "UTF-8"));
                apply.setFutureVision(new String((request.getParameter("future_vision")).getBytes("ISO-8859-1"), "UTF-8"));
                apply.setMajor(new String((request.getParameter("major")).getBytes("ISO-8859-1"), "UTF-8"));
                apply.setPolitic(new String((request.getParameter("politic")).getBytes("ISO-8859-1"), "UTF-8"));
                apply.setName(new String((request.getParameter("name")).getBytes("ISO-8859-1"), "UTF-8"));
                apply.setSecondApply(new String((request.getParameter("secondWish")).getBytes("ISO-8859-1"), "UTF-8"));
                apply.setSelfIntroduction(new String((request.getParameter("self_introduction")).getBytes("ISO-8859-1"), "UTF-8"));
                apply.setSex(new String((request.getParameter("sex")).getBytes("ISO-8859-1"), "UTF-8"));
                apply.setThirdApply(new String((request.getParameter("thirdWish")).getBytes("ISO-8859-1"), "UTF-8"));
                apply.setWorkExp(new String((request.getParameter("work_exp")).getBytes("ISO-8859-1"), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
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
