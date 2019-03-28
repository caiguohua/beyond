import config.DIConfig;
import consumer.AnnoApp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AnnoMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
        AnnoApp app = context.getBean(AnnoApp.class);
        app.process(" Hi Everyone"," cgh@dharma.com ");
        context.close();
    }
}
