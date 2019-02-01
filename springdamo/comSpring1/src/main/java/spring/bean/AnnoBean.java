package spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

/**
 * 实现依赖注入
 */

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class AnnoBean implements InitializingBean, DisposableBean {

    private int studentId;

    public int getStudentId() {
        System.out.println("get annotate bean");
        return studentId;
    }

    public void setStudentId(int studentId) {
        System.out.println("set annotate bean");
        this.studentId = studentId;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("bean destroy called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean afterPropertiesSet called");
    }
}
