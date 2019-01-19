import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");

        double bmi = calculateBMI(Double.parseDouble(height),Double.parseDouble(weight));

        String result = getResult(bmi);

        request.setAttribute("bmi",bmi);
        request.setAttribute("result",result);
        response.setHeader("BMI",String.valueOf(bmi));
        RequestDispatcher dispatcher = request.getRequestDispatcher("bmi.jsp");
        dispatcher.forward(request,response);
    }

    private String getResult(double bmi){

        String result = "";
        if(bmi<18.5){
            result = "体重过低！";
        }else if(bmi<24){
            result = "体重正常！";
        }else if(bmi<28){
            result = "肥胖前期！";
        }else if(bmi<30){
            result = "I度肥胖！";
        }else if(bmi<40){
            result = "II度肥胖！";
        }else{
            result = "III度肥胖！";
        }
        return result;
    }

    private double calculateBMI(double height, double weight) {
        return weight/(height*height);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
