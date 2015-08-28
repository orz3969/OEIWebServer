package com.oeinetwork.Views;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * Project OEIWebServer
 * Created by scotg_000 on 2015/7/21.
 */
public class DownloadViewBase implements View {
    String fileName;
    String displayName;
    String contentType;

    public DownloadViewBase(String file, String output, String type) {
        fileName = file;
        displayName = output;
        contentType = type;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //String dataDir = request.getServletContext().getRealPath("/WEB-INF");
        File file = new File(fileName);
        response.setContentType(contentType);
        response.addHeader("Content-Disposition", "attachment; filename=" + displayName);
        byte[] buffer = new byte[2048];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
    }
}
