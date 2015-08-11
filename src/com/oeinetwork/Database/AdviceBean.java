package com.oeinetwork.Database;


/**
 * Created by scotg_000 on 2015/7/17
 */
public class AdviceBean {
    private String contactM;
    private String voice;


    public String getContactM() {
        return contactM;
    }

    public void setContactM(String contactM) {
        this.contactM = contactM;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdviceBean that = (AdviceBean) o;

        if (contactM != null ? !contactM.equals(that.contactM) : that.contactM != null) return false;
        if (voice != null ? !voice.equals(that.voice) : that.voice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (contactM != null ? contactM.hashCode() : 0);
        result = 31 * result + (voice != null ? voice.hashCode() : 0);
        return result;
    }
}
