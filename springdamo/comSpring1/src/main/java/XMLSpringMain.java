import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.EmployeeService;

public class XMLSpringMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        System.out.println("Spring context init");

        EmployeeService service = context.getBean(EmployeeService.class);

        System.out.println("Bean retried from spring");
        System.out.println("Employee Name=" + service.getEmployee().getName());

        context.close();
        System.out.println("Spring context closed");
    }
}
