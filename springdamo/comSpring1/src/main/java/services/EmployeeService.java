package services;

import bean.Employee;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 生命周期
 * 注解 、接口 、配置文件
 */

public class EmployeeService implements InitializingBean, DisposableBean {

    private Employee employee;

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public EmployeeService() {
        System.out.println("EmployeeService no-args constructor called");
    }

    @Override
    public void destroy() {
        System.out.println("EmployeeService destroy called");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("EmployeeService afterPropertiesSet called");
        if(employee.getName() == null){
            employee.setName("cgh");
        }
    }


    @PostConstruct
    public void init(){
        System.out.println("Post construct called");
        if(employee.getName() == null){
            employee.setName("cgh");
        }
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Pre destroy called");
    }


    public void xmlInit(){
        System.out.println("xml construct called");
        if(employee.getName() == null){
            employee.setName("cgh");
        }
    }

    public void xmlDestroy(){
        System.out.println("xml destroy called");
    }
}
