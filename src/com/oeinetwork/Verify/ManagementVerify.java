package com.oeinetwork.Verify;

import com.oeinetwork.GlobalService;
import com.oeinetwork.Models.VerifyModel;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

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
        HttpServletRequest request = this.getRequest();
        String encryptCode = request.getParameter("encryptInput");
        if (encryptCode == null || encryptCode.equals("") || !encryptCode.equals(GlobalService.key_ring)) {
            HashMap<String, String> map = new HashMap<>();
            map.put("error_msg", "Auth failed");
            setErrors(map);
            return false;
        } else {
            return true;
        }
    }

}
