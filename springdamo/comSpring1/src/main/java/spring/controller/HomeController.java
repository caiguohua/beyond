package spring.controller;

import spring.bean.AnnoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("request")
public class HomeController {

    private AnnoBean annoBean;

    @Autowired
    public void setAnnoBean(AnnoBean annoBean) {
        System.out.println("anno bean setter");
        this.annoBean = annoBean;
    }

    @RequestMapping("/")
    public String home(Model model){
        System.out.println("anno bean" + annoBean.hashCode());
        annoBean.setStudentId(9527);
        model.addAttribute("student",annoBean.getStudentId());
        return "home";
    }
}
