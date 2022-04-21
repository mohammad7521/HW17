package servletDemo;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import servletDemo.utils.HibernateSingleton;
import java.io.IOException;
import java.nio.charset.StandardCharsets;




@WebServlet(name = "addProduct", value = "/add-product")
public class CreateProduct extends HttpServlet {


    private SessionFactory sessionFactory= HibernateSingleton.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var jsonString=new String(req.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        var objectMapper=new ObjectMapper();
        Product product=objectMapper.readValue(jsonString,Product.class);

        try(var session=sessionFactory.openSession()){
            var trx=session.beginTransaction();
            try{
                session.save(product);
                trx.commit();
                session.close();
            }catch (Exception e){
                trx.rollback();
                throw e;
            }
        }
    }


}
