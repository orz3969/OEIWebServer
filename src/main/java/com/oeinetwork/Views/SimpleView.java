package com.oeinetwork.Views;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by scotg_000 on 2015/7/9
 */
public class SimpleView implements View {
    @Override
    public String getContentType() {
        return "text/html;charset=utf8";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        out.println("Yo(MainPort)");
        System.out.println("TestTest");
        out.close();
    }
}
