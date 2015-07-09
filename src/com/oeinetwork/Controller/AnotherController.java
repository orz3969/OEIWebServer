package com.oeinetwork.Controller;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by scotg_000 on 2015/7/9
 */
public class AnotherController extends BaseController {


    public AnotherController() {
        this.assignWork(new AnotherWork());
    }

    private class AnotherWork implements DoWork {

        @Override
        public ModelAndView executeJob(HttpServletRequest request) {
            return new ModelAndView("PageTwo.jsp");
            /**
             * I'm boring
             */
        }
    }
}
