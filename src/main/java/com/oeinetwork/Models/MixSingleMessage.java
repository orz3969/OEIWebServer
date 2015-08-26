package com.oeinetwork.Models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Project OEIWebServer
 * Created by Zhen on 2015/7/31.
 */
public class MixSingleMessage {
    @XStreamAlias("Title")
    private String Title;
    @XStreamAlias("Description")
    private String Description;
    @XStreamAlias("PicUrl")
    private String PicUrl;
    @XStreamAlias("Url")
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
