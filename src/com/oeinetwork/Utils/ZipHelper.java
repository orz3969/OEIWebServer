package com.oeinetwork.Utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by scotg_000 on 2015/7/16
 */
public class ZipHelper {
    private String outputLocation;
    private String inputFolder;
    private String errorMessage="";

    public ZipHelper(String outputLocation,String inputFolder){
        this.outputLocation = outputLocation;
        this.inputFolder = inputFolder;
    }

    public boolean Start(){
        File folder = new File(inputFolder);
        try {
            ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(outputLocation));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            zip(outputStream,folder,folder.getName(),bufferedOutputStream);
            bufferedOutputStream.close();
            outputStream.close();
            return true;
        } catch (Exception e) {
            errorMessage = e.getMessage();
            return false;
        }
    }

    public String getErrorMsg(){
        return errorMessage;
    }

    private void zip(ZipOutputStream out,File f,String base,BufferedOutputStream bo) throws Exception{
        if (f.isDirectory()) {
            File[] fl = f.listFiles();
            if (fl.length == 0) {
                out.putNextEntry(new ZipEntry(base + "/"));
            }
            for (int i = 0; i < fl.length; i++) {
                zip(out, fl[i], base + "/" + fl[i].getName(), bo);
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            BufferedInputStream bi = new BufferedInputStream(in);
            int b;
            while ((b = bi.read()) != -1) {
                bo.write(b);
            }
            bi.close();
            in.close();
        }
    }
}
