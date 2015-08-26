package com.oeinetwork.Utils;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;

/**
 * Created by scotg_000 on 2015/7/16
 */
public class ZipHelper {
    FileOutputStream fOut;
    BufferedOutputStream bOut;
    GzipCompressorOutputStream gzOut;
    TarArchiveOutputStream tOut;
    private String outputLocation;
    private String inputFolder;
    private String errorMessage = "";

    public ZipHelper(String outputLocation, String inputFolder) {
        this.outputLocation = outputLocation;
        this.inputFolder = inputFolder;
    }

    public boolean Start() throws IOException {
        try {
            CreateTarGZ();
            return true;
        } catch (Exception e) {
            errorMessage = e.getMessage();
            return false;
        }

    }

    public String getErrorMsg() {
        return errorMessage;
    }

    public void CreateTarGZ() throws IOException {
        try {
            String dirPath = inputFolder;
            String tarGzPath = outputLocation;
            fOut = new FileOutputStream(new File(tarGzPath));
            bOut = new BufferedOutputStream(fOut);
            gzOut = new GzipCompressorOutputStream(bOut);
            tOut = new TarArchiveOutputStream(gzOut);
            addFileToTarGz(tOut, dirPath, "");
        } finally {
            tOut.finish();
            tOut.close();
            gzOut.close();
            bOut.close();
            fOut.close();
        }

    }


    private void addFileToTarGz(TarArchiveOutputStream tOut, String path, String base) throws IOException {
        File f = new File(path);
        String entryName = base + f.getName();


        if (f.isFile()) {
            TarArchiveEntry tarEntry = new TarArchiveEntry(f, entryName);
            tOut.putArchiveEntry(tarEntry);
            IOUtils.copy(new FileInputStream(f), tOut);
            tOut.closeArchiveEntry();
        } else {
            TarArchiveEntry tarEntry = new TarArchiveEntry(f, entryName);
            tOut.putArchiveEntry(tarEntry);
            tOut.closeArchiveEntry();
            File[] children = f.listFiles();
            if (children != null) {
                for (File child : children) {
                    System.out.println(child.getName());
                    addFileToTarGz(tOut, child.getAbsolutePath(), entryName + "/");
                }
            }
        }
    }


}
