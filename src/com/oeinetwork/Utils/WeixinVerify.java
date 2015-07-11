package com.oeinetwork.Utils;

import com.oeinetwork.Models.VerifyModel;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by orz on 7/11/15
 */
public class WeixinVerify extends VerifyModel {
    public WeixinVerify(HttpServletRequest req) {
        super(req);
    }

    @Override
    public boolean verify() {
        return true;
    }
}
