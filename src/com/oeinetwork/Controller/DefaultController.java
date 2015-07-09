package com.oeinetwork.Controller;

import com.oeinetwork.Views.SimpleView;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by scotg_000 on 2015/7/9
 */
public class DefaultController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("DefaultController");
        return new ModelAndView(new SimpleView());
    }
}
