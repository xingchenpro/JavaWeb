package com.hly.jsp.file;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/22
 */
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String fileName = request.getParameter("fileName");
        System.out.println("下载路径为:"+fileName);
        //设置mime类型,getMimeType获得文档类型，这里是text/plain
        response.setContentType(getServletContext().getMimeType(fileName));
        System.out.println("mime类型:"+getServletContext().getMimeType(fileName));
        //设置Context-Disposition
        //Content-disposition：HTTP相应头的属性，允许用户下载软件到磁盘
        //attachment表示以附件方式下载。如果要在页面中打开，则改为inline。
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        //输入流
        String filePath = getServletContext().getRealPath("/")+ File.separator +"uploadFile"+File.separator +fileName;
        InputStream in = new FileInputStream(filePath);
        ServletOutputStream os = response.getOutputStream();
        //缓冲区
        int len =1;
        byte[] b = new byte[1024];
        while ((len = in.read(b))!=-1){
            os.write(b,0,len);
        }
        in.close();
        os.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }


}
