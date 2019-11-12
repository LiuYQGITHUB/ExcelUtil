package com.liuyq.cn.ExcelUtil.utils;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadUtils {

    public static OutputStream getOutputStream(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException {
        response.reset();
        response.setContentType("application/octet-stream");
        String agent = request.getHeader("User-Agent");
        if (agent != null && (agent.toLowerCase().indexOf("firefox") > 0 || agent.toLowerCase().indexOf("360se") > 0)) {
            //fileName = "=?UTF-8?B?" + (new String(Base64.encodeBase64String(fileName.getBytes("UTF-8")))) + "?=";
            fileName = new String(fileName.getBytes("GB2312"), "ISO_8859_1");
        }
        else {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        }
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        return response.getOutputStream();
    }

}
