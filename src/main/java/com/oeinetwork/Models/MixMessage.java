package com.oeinetwork.Models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;

/**
 * Project OEIWebServer
 * Created by Zhen on 2015/7/31.
 */
@XStreamAlias("xml")
public class MixMessage {

    @XStreamAlias("ToUserName")
    private String ToUserName;
    @XStreamAlias("FromUserName")
    private String FromUserName;
    @XStreamAlias("CreateTime")
    private long CreateTime;
    @XStreamAlias("MsgType")
    private String MsgType;
    @XStreamAlias("Articles")
    private MixMsg msgList;
    @XStreamAlias("Count")
    private int Count;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public MixMsg getMsgList() {
        return msgList;
    }

    public void setMsgList(MixMsg msgList) {
        this.msgList = msgList;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }
}
