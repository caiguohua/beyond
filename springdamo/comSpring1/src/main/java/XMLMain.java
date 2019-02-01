import consumer.XMLApp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        XMLApp app = context.getBean(XMLApp.class);
        app.process(" hi everyone"," cgh");
        context.close();
    }
}
