package com.oeinetwork.Views;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by scotg_000 on 2015/7/18
 */
public class ConfirmView implements View {

    @Override
    public String getContentType() {
        //return "text/html;charset=utf8";
        return "text/html;charset=utf-8";
    }

    /**
     * 你他妈传递的response是虚参能不能说一声
     */
    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter writer = response.getWriter();
        String message = "报名成功";
        writer.println("<!DOCTYPE html>\n<html>\n" +
                "<head>\n<meta charset=\"UTF-8\"><title>OEIMedia</title>\n" + "<style type=\"text/css\">\n" +
                "\t\tbody{text-align:center;}\n" +
                "\t</style>" +
                "</head><body><h1>" + message + "</h1></body>\n" +
                "</html>");
    }
}
