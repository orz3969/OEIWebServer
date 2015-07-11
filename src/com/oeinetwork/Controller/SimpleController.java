package com.oeinetwork.Controller;

import com.oeinetwork.Models.VerifyModel;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by scotg_000 on 2015/7/9
 */
public class SimpleController extends BaseController {

    public SimpleController() {
        this.assignWork(new SimpleWork());
    }

    class SimpleWork implements DoWork {

        @Override
        public ModelAndView executeJob(HttpServletRequest request) {
            System.out.println("SimpleController");
            return new ModelAndView("PageOne.jsp");
        }

        @Override
        public VerifyModel getVerifyInfo(HttpServletRequest request) {
            return null;
        }
    }
}
