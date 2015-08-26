package com.oeinetwork.Controller;

import com.oeinetwork.Database.ActivityEntity;
import com.oeinetwork.Database.ApplyBean;
import com.oeinetwork.Database.DatabaseHelper;
import com.oeinetwork.Models.VerifyModel;
import com.oeinetwork.Utils.JSONUtil;
import com.oeinetwork.Utils.ZipHelper;
import com.oeinetwork.Verify.ManagementVerify;
import com.oeinetwork.Views.DownloadViewBase;
import com.oeinetwork.Views.ErrorView;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created by scotg_000 on 2015/7/20
 */
public class SaveFormsController extends BaseController {
    public SaveFormsController() {
        this.assignWork(new SaveWork());
    }

    class SaveWork implements DoWork {
        @Override
        public ModelAndView executeJob(HttpServletRequest request) {
            DatabaseHelper helper = new DatabaseHelper();
            List<ActivityEntity> list = helper.getAllApplication();
            String dataDir = request.getServletContext().getRealPath("/WEB-INF");
            preWork();
            dataDir += "/template2.doc";
            try {
                for (ActivityEntity aList : list) {
                    InputStream inputStream = new FileInputStream(dataDir);
                    HWPFDocument document = new HWPFDocument(inputStream);
                    Range range = document.getRange();
                    IOOperation(JSONUtil.translateJSONintoApplyBean(aList.getActivityData()), document, range, request);
                    inputStream.close();
                }
                //ZipHelper mHelp = new ZipHelper("/home/Output/apply.tar.gz", "/home/Docs/Word");
                ZipHelper mHelp = new ZipHelper("C:\\Docs\\Output\\apply.tar.gz", "C:\\Docs\\Word");
                mHelp.Start();
                //return new ModelAndView(new DownloadViewBase("/home/Output/apply.tar.gz", "apply.tar.gz", "application/octet-stream"));
                return new ModelAndView(new DownloadViewBase("C:\\Docs\\Output\\apply.tar.gz", "apply.tar.gz", "application/octet-stream"));
            } catch (Exception e) {
                e.printStackTrace();
                HashMap<String, String> map = new HashMap<>();
                map.put("error_msg", "Failed to operate " + e.getMessage());
                return new ModelAndView(new ErrorView(), map);
            }
        }

        @Override
        public VerifyModel getVerifyInfo(HttpServletRequest request) {
            return new ManagementVerify(request);
        }

        public void IOOperation(ApplyBean entity, HWPFDocument document, Range range, HttpServletRequest request) throws Exception {
            range.replaceText("NameArea", entity.getName());
            range.replaceText("Sex", entity.getSex());
            range.replaceText("DateOfBirth", entity.getDayOfBirth());
            range.replaceText("PoliticalStatus", entity.getPolitic());
            range.replaceText("Major", entity.getMajor());
            range.replaceText("Contact", entity.getContact());
            range.replaceText("First", entity.getFirstApply());
            range.replaceText("Second", entity.getSecondApply());
            range.replaceText("Third", entity.getThirdApply());
            range.replaceText("SelfIntroduction", entity.getSelfIntroduction());
            range.replaceText("WorkExperience", entity.getWorkExp());
            range.replaceText("FutureVision", entity.getFutureVision());
            String path = "C:\\Docs\\Word" + entity.getName() + System.currentTimeMillis() + ".doc";
            //String path = "/home/Docs/Word/" + entity.getName() + System.currentTimeMillis() + ".doc";
            OutputStream outputStream = new FileOutputStream(path);
            document.write(outputStream);
            outputStream.close();
        }

        public void preWork() {
            //String docFolder = "/home/Docs/Word";
            String docFolder = "C:\\Docs\\Word";
            //String outputFile = "/home/Docs/Output/apply.tar.gz";
            String outputFile = "C:\\Docs\\Output\\apply.tar.gz";
            File docs = new File(docFolder);
            File out = new File(outputFile);
            if (out.exists()) {
                out.delete();
            }
            if (docs.isDirectory()) {
                File[] list = docs.listFiles();
                if (list != null) {
                    for (File single : list) {
                        single.delete();
                    }
                }
            }
        }
    }
}