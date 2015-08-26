package com.oeinetwork.Models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scotg_000 on 2015/7/19
 */
public class CodeVerify extends VerifyModel {
    /**
     * empty,code is not needed here
     *
     * @param req
     */
    public CodeVerify(HttpServletRequest req) {
        super(req);
    }

    @Override
    public boolean verify() {
        HttpServletRequest request = this.getRequest();
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("randomCode");

        if (request.getParameter("validation_code") != null && request.getParameter("validation_code").equals(code)) {
            return true;
        } else {
            System.out.println(request.getParameter("validation_code") == null);
            Map<String, String> error = new HashMap<>();
            error.put("error_msg", "Validation Wrong code");
            setErrors(error);
            return false;
        }
    }
}
