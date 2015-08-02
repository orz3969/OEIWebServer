package com.oeinetwork.Models;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;

/**
 * Project OEIWebServer
 * Created by Zhen on 2015/7/31.
 */
public class MixMsg {
    @XStreamImplicit(itemFieldName = "item")
    private ArrayList<MixSingleMessage> list;

    public ArrayList<MixSingleMessage> getList() {
        return list;
    }

    public void setList(ArrayList<MixSingleMessage> list) {
        this.list = list;
    }
}
