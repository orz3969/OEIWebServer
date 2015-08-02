package com.oeinetwork.Models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Zhen on 2015/7/30.
 */
@XStreamAlias("xml")
public class TextMessage {

    @XStreamAlias("ToUserName")
    private String ToUserName;

    @XStreamAlias("FromUserName")
    private String FromUserName;

    @XStreamAlias("CreateTime")
    private long CreateTime;

    @XStreamAlias("MsgType")
    private String MsgType;

    @XStreamAlias("Content")
    private String Content;

    public String getContent() {
        return Content;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getToUserName() {
        return ToUserName;
    }

    @Override
    public String toString() {
        return "content:"+getContent()+"\n"+"createTime:"+getCreateTime()+"\n";
    }
}
