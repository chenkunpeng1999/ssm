package com.hy.springmvc.controller;

import com.hy.springmvc.exception.MyException;
import com.hy.springmvc.pojo.Emp;
import com.hy.springmvc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/query1.do")
    public void query(){
        Emp e = new Emp();
        /*e.setEid(7);
        e.setEname("bbb");
        empService.update(e);
        System.out.println(empService.queryById(7).getEname());*/

        /*e.setEid(7);*/
        /*empService.delete(e);*/
       /* List<Emp> list = empService.query();
        for (Emp emp:list){
            System.out.println(emp.getEname());
        }*/
    }

    @RequestMapping("/errortest.do")
    public void errortest() throws MyException {
        throw new MyException("123");
    }
}
