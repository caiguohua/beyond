package com.test.controller;

import com.dao.StudentDao;
import com.pojo.StudentEntity;
import com.service.CategoryService;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;

@Controller
//@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/cgh")
    @ResponseBody
    public List<StudentEntity> getStudent(){
        StudentDao dao = new StudentDao();
        return dao.query();
    }

//@Controller
//@RequestMapping("")
//public class StudentController {
//    @Autowired
//    CategoryService categoryService;
//
//
//    @RequestMapping("cgh")
//    public ModelAndView listCategory(Page page){
//        ModelAndView mav = new ModelAndView();
//        PageHelper.offsetPage(page.getStart(),5);
//        List<StudentEntity> cs= categoryService.list();
//        int total = (int) new PageInfo<>(cs).getTotal();
//
//        page.caculateLast(total);
//
//        // 放入转发参数
//        mav.addObject("cs", cs);
//        // 放入jsp路径
//        mav.setViewName("cgh");
//        return mav;
//    }

}
