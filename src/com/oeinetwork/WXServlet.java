package com.oeinetwork;

import com.oeinetwork.Utils.CheckSigUtil;
import com.oeinetwork.Utils.MessageUtils;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Zhen on 2015/7/30
 */
public class WXServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");

        PrintWriter out = resp.getWriter();
        if (CheckSigUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            Map<String, String> map = MessageUtils.xmlToMap(req);
            String fromUserName = "<![CDATA[" + map.get("FromUserName") + "]]>";
            String toUserName = "<![CDATA[" + map.get("ToUserName") + "]]>";
            String msgType = "<![CDATA[" + map.get("MsgType") + "]]>";
            String content = "<![CDATA[" + map.get("Content") + "]]>";
            String message = null;
            if (msgType.equals("<![CDATA[text]]>")) {
                if (content.equals("<![CDATA[哈哈]]>")) {
                    message = MessageUtils.initString(toUserName, fromUserName, MessageUtils.maimeng());
                }
            } else if (MessageUtils.MESSAGE_EVENT.equals(msgType)) {
                String eventType = map.get("<![CDATA[Event]]>");
                if (MessageUtils.MESSAGE_SUBSCRIBE.equals(eventType)) {
                    message = MessageUtils.initString(toUserName, fromUserName, MessageUtils.subscribe());
                }
            }
            System.out.println(message);
            out.print(message);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
