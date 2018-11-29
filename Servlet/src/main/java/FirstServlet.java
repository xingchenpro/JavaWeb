import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/25
 */

@WebServlet(name = "FirstServlet", urlPatterns = { "/firstServlet" }, loadOnStartup = 1)
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String employeeName = request.getParameter("employeeName");
        request.setAttribute("employeeName", employeeName);
        request.getRequestDispatcher("/secondServlet").forward(request, response);
//		System.out.println("in firstServlet,empoyeeName=" + employeeName);
    }

    protected  void  doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        doGet(request,response);
    }

}
