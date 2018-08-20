package com.hly.jsp.file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/20
 */

@WebServlet("/fileUpload")
public class FileUpload extends HttpServlet {

    private static final int MEMORY_SIDE = 1024 * 1024 * 5;
    private static final int MAX_MEMORY_SIDE = 1024 * 1024 * 10;
    private static final int MAX_REQUEST_MEMORY_SIDE = 1024 * 1024 * 20;


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter out = response.getWriter();
            out.println("不是多媒体上传");
            out.flush();
            return;
        }

        //配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置临界值超过部分存在临时目录
        factory.setSizeThreshold(MEMORY_SIDE);
        //设置临时存储目录,https://www.cnblogs.com/nbjin/p/7392541.html
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        //设置文件最大上传值
        upload.setFileSizeMax(MEMORY_SIDE);
        //设置文件最大请求值
        upload.setSizeMax(MAX_REQUEST_MEMORY_SIDE);
        //编码
        upload.setHeaderEncoding("UTF-8");
        //设置相对路径
        String path = getServletContext().getRealPath("/") + File.separator + "uploadFile";

        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }


        try {
            //解析请求内容获取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> fileItems = upload.parseRequest(request);

            if (fileItems != null && fileItems.size() > 0) {
                for (FileItem item : fileItems) {
                    //不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        System.out.println("fileName:"+fileName);
                        String filePath = path + File.separator + fileName;
                        File storeFile = new File(filePath);
                        System.out.println("上传路径为:" + filePath);
                        //保存文件到硬盘
                        item.write(storeFile);
                        request.setAttribute("message", "上传成功");

                    }
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/file/message.jsp").forward(request, response);

    }

}
