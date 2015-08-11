package com.oeinetwork.Controller;

import com.oeinetwork.Database.AdviceBean;
import com.oeinetwork.Database.DatabaseHelper;
import com.oeinetwork.Models.CodeVerify;
import com.oeinetwork.Models.VerifyModel;
import com.oeinetwork.Views.ConfirmView;
import com.oeinetwork.Views.ErrorView;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by scotg_000 on 2015/7/9
 */
public class AdviceController extends BaseController {

    public AdviceController(){
        this.assignWork(new AnotherWork());
    }

    class AnotherWork implements DoWork{

        @Override
        public ModelAndView executeJob(HttpServletRequest request) {
            DatabaseHelper helper = new DatabaseHelper();
            AdviceBean advice = new AdviceBean();
            advice.setContactM(request.getParameter("email"));
            advice.setVoice(request.getParameter("advice"));
            if(helper.saveAdvise(advice)){
                return new ModelAndView(new ConfirmView(),null);
            }else{
                HashMap<String,String> error = new HashMap<>();
                error.put("error_msg", "Hibernate  "+helper.getErrorMsg());
                return new ModelAndView(new ErrorView(),error);
            }

        }

        @Override
        public VerifyModel getVerifyInfo(HttpServletRequest request) {
            return new CodeVerify(request);
        }
    }
}
