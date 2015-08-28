package com.oeinetwork.Controller;

import com.oeinetwork.Database.ActivityEntity;
import com.oeinetwork.Database.ApplyBean;
import com.oeinetwork.Database.CompeteBean;
import com.oeinetwork.Database.DatabaseHelper;
import com.oeinetwork.Models.VerifyModel;
import com.oeinetwork.Utils.JSONUtil;
import com.oeinetwork.Verify.ManagementVerify;
import com.oeinetwork.Views.DownloadViewBase;
import com.oeinetwork.Views.ErrorView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Project OEIWebServer
 * Created by Zhen on 2015/8/13.
 */
public class GenerateXLSController extends BaseController {
    public GenerateXLSController() {
        this.assignWork(new XLSWork());
    }

    class XLSWork implements DoWork {

        @Override
        public ModelAndView executeJob(HttpServletRequest request) {
            DatabaseHelper helper = new DatabaseHelper();
            List<ActivityEntity> list = helper.getAllCompete();
            Workbook datasheet = new HSSFWorkbook();
            CompeteBean bean;
            Row row;
            Sheet data = datasheet.createSheet("data");
            for (int i = 0; i < list.size(); i++) {
                row = data.createRow(i);
                bean = (CompeteBean) JSONUtil.translateJsonIntoBean(list.get(i).getActivityData(), CompeteBean.class);
                Method[] methods = bean.getClass().getMethods();
                String methodName;
                String regPattern = "^get+[a-zA-z]*";
                int innerCount = 0;
                for (Method method : methods) {
                    methodName = method.getName();
                    if (Pattern.matches(regPattern, methodName) && (!methodName.equals("getClass"))) {
                        try {
                            row.createCell(innerCount).setCellValue((String) (method.invoke(bean)));
                            innerCount++;
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            preWork();
            try {
                FileOutputStream fileOut = new FileOutputStream("/home/Docs/workbook.xls");
                //FileOutputStream fileOut = new FileOutputStream("C:\\Docs\\workbook.xls");
                datasheet.write(fileOut);
                fileOut.close();
                //return new ModelAndView(new DownloadViewBase("C:\\Docs\\workbook.xls", "workbook.xls", "application/vnd.ms-excel"));
                return new ModelAndView(new DownloadViewBase("/home/Docs/workbook.xls", "workbook.xls", "application/vnd.ms-excel"));
            } catch (IOException e) {
                e.printStackTrace();
                HashMap<String, String> map = new HashMap<>();
                map.put("error_msg", "Failed to operate " + e.getMessage());
                return new ModelAndView(new ErrorView(), map);
            }
        }

        public void preWork() {
            //String outputFile = "C:\\Docs\\workbook.xls";
            String outputFile = "/home/Docs/workbook.xls";
            File out = new File(outputFile);
            if (out.exists()) {
                out.delete();
            }
        }

        @Override
        public VerifyModel getVerifyInfo(HttpServletRequest request) {
            return new ManagementVerify(request);
        }
    }
}
