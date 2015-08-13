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
            compete.setName(request.getParameter("applicant"));
            compete.setClassName(request.getParameter("classroom"));
            compete.setGroup(request.getParameter("group"));
            compete.setPhoneNumber(request.getParameter("phone_num"));
            compete.setQQNumber(request.getParameter("qq"));
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
