package com.oeinetwork.Views;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Project OEIWebServer
 * Created by orz on 7/11/15.
 */
public class ErrorView implements View {

    @Override
    public String getContentType() {
        return "text/html;charset=utf8";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        PrintWriter writer = httpServletResponse.getWriter();
        writer.println("Looks like you have got several errors:");
        if (map != null) {
            writer.println("ERROR:" + map.get("error_msg"));
        } else {
            writer.println("Well,nothing to show.How sad is it,isn't it?");
        }
    }
}
