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
        writer.println("<!DOCTYPE html><html>\n" + "<head><title>OEIMedia</title>\n" + " <style type=\"text/css\">" +
                "\t\tbody{text-align:center;}\n" +
                "\t</style>" + "</head><body><h1>似乎遇到了一点麻烦:");
        if (map != null) {
            writer.println("ERROR:" + map.get("error_msg") + "</h1></body>" +
                    "</html>");
        } else {
            writer.println("怎么回事（" + "</h1></body>" +
                    "</html>");
        }
    }
}
