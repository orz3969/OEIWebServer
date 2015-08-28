package com.oeinetwork.Controller;

import com.oeinetwork.Models.VerifyModel;
import com.oeinetwork.Views.ConfirmView;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Project OEIWebServer
 * Created by Zhen on 2015/8/27.
 */
public class TestController extends BaseController {

    public TestController() {
        this.assignWork(new TestWork());
    }

    class TestWork implements DoWork {

        @Override
        public ModelAndView executeJob(HttpServletRequest request) {
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return new ModelAndView(new ConfirmView());
        }

        @Override
        public VerifyModel getVerifyInfo(HttpServletRequest request) {
            return null;
        }
    }
}
