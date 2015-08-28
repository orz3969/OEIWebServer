package com.oeinetwork.Verify;

import com.oeinetwork.Models.VerifyModel;

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
    private boolean isConfirm = false;

    public CodeVerify(HttpServletRequest req) {
        super(req);
    }

    @Override
    public boolean verify() {
        HttpServletRequest request = this.getRequest();
        HttpSession session = request.getSession();
        String userInput = request.getParameter("validation_code");
        String code = (String) session.getAttribute("randomCode");
        System.out.println(code);

        System.out.println(userInput);
        if (userInput != null) {
            userInput = userInput.toUpperCase();
            System.out.println(userInput);
            if (userInput.equals(code)) {
                isConfirm = true;
            }

        }

        if (isConfirm) {
            return true;
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error_msg", "验证码错误");
            setErrors(error);
            return false;
        }
    }
}
