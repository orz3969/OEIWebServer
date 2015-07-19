package com.oeinetwork.Controller;

import com.oeinetwork.Database.AdviceEntity;
import com.oeinetwork.Database.DatabaseHelper;
import com.oeinetwork.Models.CodeVerify;
import com.oeinetwork.Models.VerifyModel;
import com.oeinetwork.Views.ConfirmView;
import com.oeinetwork.Views.ErrorView;
import com.oeinetwork.Views.SimpleView;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            AdviceEntity advice = new AdviceEntity();
            advice.setContactM(request.getParameter("email"));
            advice.setRecordTime(System.currentTimeMillis());
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
