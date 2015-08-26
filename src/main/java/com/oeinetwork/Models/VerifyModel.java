package com.oeinetwork.Models;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by orz on 7/11/15
 */
public class VerifyModel {
    private HttpServletRequest request;

    private Map<String, ?> errors;

    /**
     * empty,code is not needed here
     */
    public VerifyModel(HttpServletRequest req) {
        this.request = req;
    }

    public boolean verify() {
        return true;
    }

    public Map<String, ?> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, ?> errors) {
        this.errors = errors;
    }

    public HttpServletRequest getRequest() {
        return request;
    }
}
