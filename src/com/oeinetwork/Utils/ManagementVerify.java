package com.oeinetwork.Utils;

import com.oeinetwork.Models.VerifyModel;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Project OEIWebServer
 * Created by orz on 7/11/15.
 */
public class ManagementVerify extends VerifyModel {

    public ManagementVerify(HttpServletRequest req) {
        super(req);
    }

    @Override
    public boolean verify() {
        return super.verify();
    }

}
