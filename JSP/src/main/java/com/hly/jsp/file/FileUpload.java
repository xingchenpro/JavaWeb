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

    //临界值，超过临界值，上传过程中会存到临时目录
    private static final int BOUNDARY_MEMORY_SIDE = 1024 * 1024 * 10;
    //文件最大值
    private static final int MAX_MEMORY_SIDE = 1024 * 1024 * 300;
    //请求值
    private static final int MAX_REQUEST_MEMORY_SIDE = 1024 * 1024 * 1000;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //判断普通表单还是文件上传表单，enctype属性是否是"multipart/form-data"。
        if (!ServletFileUpload.isMultipartContent(request)) {
            System.out.println("不是多媒体上传");
            PrintWriter out = response.getWriter();
            out.println("不是多媒体上传");
            out.flush();
            return;
        }

        //配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置临界值,超过部分存在临时目录
        factory.setSizeThreshold(BOUNDARY_MEMORY_SIDE);
        //设置临时存储目录,上传过程中超过大小存到临时目录中，也可以设置成系统临时存储目录，https://www.cnblogs.com/nbjin/p/7392541.html
        File tempFile = new File("d:/FileUploadTemp");
        if(!tempFile.exists())
            tempFile.mkdirs();
        factory.setRepository(tempFile);

        ServletFileUpload upload = new ServletFileUpload(factory);
        //编码
        upload.setHeaderEncoding("UTF-8");
        //设置文件最大上传值
        upload.setFileSizeMax(MAX_MEMORY_SIDE);
        //设置文件最大请求值,包括所有form
        upload.setSizeMax(MAX_REQUEST_MEMORY_SIDE);

        //设置相对路径
        String path = getServletContext().getRealPath("/") + File.separator + "uploadFile";
        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try {
            //解析请求内容获取文件数据
            List<FileItem> fileItems = upload.parseRequest(request);

            if (fileItems != null && fileItems.size() > 0) {
                for (FileItem item : fileItems) {
                    //判断是否为普通类型，否则为file类型
                    if (!item.isFormField()) {
                        //得到前端的name
                        String fileName = item.getName();
                        String filePath = path + File.separator + fileName;
                        File storeFile = new File(filePath);
                        System.out.println("上传路径为:" + filePath);
                        //保存文件到硬盘
                        item.write(storeFile);
                        request.setAttribute("message", "上传成功");
                        request.setAttribute("fileName", fileName);
                       // request.setAttribute();

                    }
                }
            }else{
                request.setAttribute("message", "上传失败");
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/file/fileUpload.jsp").forward(request, response);
        System.out.println("上传成功");
    }

}
