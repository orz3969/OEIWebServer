package com.oeinetwork;

import com.oeinetwork.Database.DatabaseHelper;
import com.oeinetwork.Database.ResponseEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project OEIWebServer
 * Created by Zhen on 2015/8/9.
 */

public class PhoneServlet extends HttpServlet {
    DatabaseHelper helper;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String content = request.getParameter("content");
        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        if (checkAuth(key)) {
            helper = new DatabaseHelper();
            ResponseEntity entity = new ResponseEntity();
            entity.setKeyWord(keyword);
            entity.setResponseObject(content);
            entity.setResponseType(type);
            helper.saveResponse(entity);
            response("complete", response);
        } else {
            response("sorry", response);
        }


    }

    private boolean checkAuth(String input) {
        return (input != null) && input.equals(GlobalService.key_ring);
    }

    private void response(String responseText, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            writer.println(responseText);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
