package com.oeinetwork.Controller;

import com.oeinetwork.Database.ApplyBean;
import com.oeinetwork.Database.CompeteBean;
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
 * Created by Orz on 2015/8/13
 */
public class OnlineCompetitionController extends BaseController {
    public OnlineCompetitionController() {
        this.assignWork(new OnlineWork());
    }

    class OnlineWork implements DoWork {

        @Override
        public ModelAndView executeJob(HttpServletRequest request) {
            DatabaseHelper helper = new DatabaseHelper();
            CompeteBean compete = new CompeteBean();
            try {
                request.setCharacterEncoding("UTF-8");
                compete.setName(new String((request.getParameter("applicant")).getBytes("ISO-8859-1"), "UTF-8"));
                compete.setClassName(new String((request.getParameter("classroom")).getBytes("ISO-8859-1"), "UTF-8"));
                compete.setGroup(new String((request.getParameter("group")).getBytes("ISO-8859-1"), "UTF-8"));
                compete.setPhoneNumber(new String((request.getParameter("phone_num")).getBytes("ISO-8859-1"), "UTF-8"));
                compete.setQQNumber(new String((request.getParameter("qq")).getBytes("ISO-8859-1"), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if (helper.saveCompetition(compete)) {
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
