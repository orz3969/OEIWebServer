package com.oeinetwork.Verify;

import com.oeinetwork.GlobalService;
import com.oeinetwork.Models.VerifyModel;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Project OEIWebServer
 * Created by scotg_000 on 2015/7/20.
 */
public class LoginVerify extends VerifyModel {

    /**
     * empty,code is not needed here
     *
     * @param req
     */
    public LoginVerify(HttpServletRequest req) {
        super(req);
    }

    public static String generateMD5(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(input.getBytes());
        byte[] d = digest.digest();
        StringBuilder buffer = new StringBuilder();
        for (byte b : d) {
            buffer.append(String.format("%02x", b & 0xff));
        }
        return buffer.toString();
    }

    @Override
    public boolean verify() {
        HttpServletRequest request = this.getRequest();
        String passwd = request.getParameter("entryCode");
        try {
            String encryptCode = generateMD5(generateMD5(passwd));
            request.getSession().setAttribute("inputPassword", passwd);
            if (!encryptCode.equals(GlobalService.key_ring)) {
                HashMap<String, String> map = new HashMap<>();
                map.put("error_msg", "Wrong Password");
                setErrors(map);
            }
            return encryptCode.equals(GlobalService.key_ring);
        } catch (NoSuchAlgorithmException e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("error_msg", e.getMessage());
            setErrors(map);
            return false;
        }
    }
}
