package com.oeinetwork.Utils;

import com.oeinetwork.Models.MixMessage;
import com.oeinetwork.Models.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Zhen on 2015/7/30
 */
public class MessageUtils {

    public static final String MESSAGE_TEXT = "<![CDATA[text]]>";
    public static final String MESSAGE_IMAGE = "<![CDATA[image]]>";
    public static final String MESSAGE_NEWS = "<![CDATA[news]]>";
    public static final String MESSAGE_VOICE = "<![CDATA[voice]]>";
    public static final String MESSAGE_VIDEO = "<![CDATA[video]]>";
    public static final String MESSAGE_LINK = "<![CDATA[link]]>";
    public static final String MESSAGE_LOCATION = "<![CDATA[location]]>";
    public static final String MESSAGE_EVENT = "<![CDATA[event]]>";
    public static final String MESSAGE_SUBSCRIBE = "<![CDATA[subscribe]]>";
    public static final String MESSAGE_UNSUBSCRIBE = "<![CDATA[unsubscribe]]>";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";

    /*xml转为map集合*/
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);

        Element root = doc.getRootElement();

        List<Element> list = root.elements();

        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        ins.close();
        return map;
    }

    /*将文本消息转换为xml*/
    public static String textMessageToXml(Object textMessage) {
        XStream xstream = new XStream();
        xstream.processAnnotations(textMessage.getClass());
        String temp = xstream.toXML(textMessage);
        temp = temp.replaceAll("&lt;", "<");
        temp = temp.replaceAll("&gt;", ">");
        return temp;
    }

    /*拼接文本消息*/
    public static String initString(String toUserName, String fromUserName, String content) {
        TextMessage text = new TextMessage();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(MessageUtils.MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());
        text.setContent(content);
        return textMessageToXml(text);
    }

    public static String initArticle(String toUserName, String fromUserName, MixMessage prototype) {
        prototype.setFromUserName(toUserName);
        prototype.setToUserName(fromUserName);
        prototype.setMsgType(MESSAGE_NEWS);
        prototype.setCreateTime(new Date().getTime());
        return textMessageToXml(prototype);
    }

    /*关注回复 */
    public static String subscribe() {
        return "<![CDATA[" + "欢迎关注由光电信息学院新媒体部独家为你打造的萌世界，在这里，光小电将随时为你提供学院最新最火爆的消息，还将定期推出光电人物志，线上活动多多，卖萌多多，来跟我互动吧！" + "]]>";
    }

    /*卖萌回复*/
    public static String maimeng() {
        return "<![CDATA[" + "古姐姐也和你么么哒~~~" + "]]>";
    }

    public static String defaultReply() {
        return "THIS IS DEFAULT REPLY";
    }

    public static String unSupportedMessageType() {
        return "臣妾，不会回复这句话啊........";
    }
}
