
import business.Shoes;
import data.ShoesDB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThemSanPham extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
        String id = (String) request.getParameter("id");
        System.out.println("ID la: "+id);
        String action = (String) request.getParameter("action");
        String url = "/TrangChu";
        //try {
        if (action.equals("edit")) {
            String code = (String) request.getParameter("code");
            String name = (String) request.getParameter("name");
            String brand = (String) request.getParameter("brand");
            String type = (String) request.getParameter("type");
            String object = (String) request.getParameter("object");
            String image = (String) request.getParameter("image");
            String price = (String) request.getParameter("price");
            double p = 0;
            if (code.length() == 0) {
                code = "";
            }
            if (name.length() == 0) {
                name = "";
            }
            if (brand.length() == 0) {
                brand = "";
            }
            if (type.length() == 0) {
                type = "";
            }
            if (image.length() == 0) {
                image = "";
            }
            if (price.length() == 0) {
                price = "";
                p = 0;
            }
            if (object.length() == 0) {
                object = "";
            }
            if (code.equals("") || brand.equals("") || type.equals("") || price.equals("")
                    || object.equals("") || name.equals("") || image.equals("")) {
                if (!price.equals("")) {
                    p = Double.parseDouble(price);
                }
                Shoes shoes = new Shoes(code, name, brand, p, type, object, image);
                request.setAttribute("shoes", shoes);
                request.setAttribute("id", id);
                url = "/Admin/Update_Confirm.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            } else {
                p = Double.parseDouble(price);
                Shoes shoes = new Shoes(code, name, brand, p, type, object, image);
                System.out.println(shoes.toString());
                ShoesDB shoesDB = new ShoesDB();
                shoesDB.editList(shoes, id);
//                System.out.println("Day la ID :"+id);   //id="" neu nhu add san pham / chuw ko phai = null       
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
        /* } catch (Exception e) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
