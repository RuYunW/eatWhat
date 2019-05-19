package servlet;

import com.wry.jdbc.dao.UsersDao;
import com.wry.jdbc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InsertRegister",urlPatterns = "/InsertRegister")
public class InsertRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        //搞id
//        if(request.getParameter("bigLoc").equals("二餐")){
//            System.out.println("a !!!!!!!!!!!!!!!!!!");
//            request.getRequestDispatcher("top_manager_page/test.jsp");
//        }
        if(request.getParameter("bigLoc")!=null && request.getParameter("smallLoc")!=null) {
            User user = new User();
            user.setUsername((String)session.getAttribute("register_username"));
            user.setPassword((String)session.getAttribute("register_password"));
            user.setEmail((String) session.getAttribute("manager_email"));
            String store_id = "";
            String bigLoc=(String)request.getParameter("bigLoc");
            String smallLoc = (String)request.getParameter("smallLoc");
            if (bigLoc.equals("一餐")) {
                store_id += "01";
                if (smallLoc.equals("一楼")){
                    store_id+="0101";
                }
                else if(smallLoc.equals("二楼北")){
                    store_id+="0201";
                }
                else if(smallLoc.equals("二楼南")){
                    store_id+="0202";
                }
                else if(smallLoc.equals("三楼北")){
                    store_id+="0301";
                }
                else if(smallLoc.equals("三楼南")){
                    store_id+="0302";
                }
                else {
                    store_id+="0000";
                }
            } else if (bigLoc.equals("二餐")) {
                store_id += "02";
                if(smallLoc.equals("一楼")){
                    store_id+="0101";
                }
                else if(smallLoc.equals("二楼")){
                    store_id+="0201";
                }
                else if(smallLoc.equals("三楼")){
                    store_id+="0301";
                }
                else {
                    store_id+="0000";
                }
            } else if (bigLoc.equals("A区")) {
                store_id += "03";
                if(smallLoc.equals("一楼")) {
                    store_id+="0101";
                }
                else {
                    store_id+="0000";
                }
            } else {
                store_id += "04";
                if(smallLoc.equals("银座商业街")){
                    store_id+="0001";
                }
                else if(smallLoc.equals("数娱广场")){
                    store_id+="0002";
                }
                else if(smallLoc.equals("蜜桃百货")){
                    store_id+="0003";
                }
                else if(smallLoc.equals("其他")){
                    store_id+="0004";
                }
                else {
                    store_id+="0000";
                }
            }
            UsersDao usersDao = new UsersDao();
            String add_id = ""+(usersDao.findAllID(store_id+"___").size()+1);//不允许为0
            //补位
            for(int i=0;i<3-add_id.length();i++){
                add_id="0"+add_id;
            }
            //完整id
            store_id+=add_id;
            session.setAttribute("storeID",store_id);
            user.setManager_store_id(store_id);

            //插入数据到数据库
            usersDao.insert(user);
            request.getRequestDispatcher("store_manager_page/store_manager_page.jsp").forward(request,response);

        }else {
            session.setAttribute("infoResult","请填写完整信息");
            request.getRequestDispatcher("verification/fillDetailInfo.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
