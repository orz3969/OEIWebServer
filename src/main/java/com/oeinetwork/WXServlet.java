package com.oeinetwork;

import com.oeinetwork.Database.DatabaseHelper;
import com.oeinetwork.Database.ResponseEntity;
import com.oeinetwork.Models.MixMessage;
import com.oeinetwork.Models.TextMessage;
import com.oeinetwork.Utils.CheckSigUtil;
import com.oeinetwork.Utils.JSONUtil;
import com.oeinetwork.Utils.MessageUtils;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
            switch (msgType) {
                case "<![CDATA[text]]>":
                    DatabaseHelper helper = new DatabaseHelper();
                    List<ResponseEntity> responseList = helper.getAllResponse();
                    String keyword;
                    for (ResponseEntity entity : responseList) {
                        keyword = "<![CDATA[" + entity.getKeyWord() + "]]>";
                        if (keyword.equals(content)) {
                            switch (entity.getResponseType()) {
                                case "text":
                                    TextMessage text_msg = JSONUtil.translateTextMessage(entity.getResponseObject());
                                    message = MessageUtils.initString(toUserName, fromUserName, text_msg.getContent());
                                    break;
                                case "article":
                                    MixMessage mix_msg = JSONUtil.translateMixMessage(entity.getResponseObject());
                                    message = MessageUtils.initArticle(toUserName, fromUserName, mix_msg);
                                    break;
                                default:
                                    message = MessageUtils.initString(toUserName, fromUserName, MessageUtils.unSupportedMessageType());
                                    break;
                            }
                            break;
                        }

                    }
                    if (content.equals("<![CDATA[哈哈]]>")) {
                        message = MessageUtils.initString(toUserName, fromUserName, MessageUtils.maimeng());
                    }
                    break;
                case MessageUtils.MESSAGE_EVENT:
                    String eventType = map.get("<![CDATA[Event]]>");
                    if (MessageUtils.MESSAGE_SUBSCRIBE.equals(eventType)) {
                        message = MessageUtils.initString(toUserName, fromUserName, MessageUtils.subscribe());
                    }
                    break;
                default:
                    message = MessageUtils.initString(toUserName, fromUserName, MessageUtils.defaultReply());
                    break;
            }
            System.out.println(message);
            out.print(message);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
