package com.hy.springmvc.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.springmvc.Layui;
import com.hy.springmvc.pojo.Dept;
import com.hy.springmvc.pojo.Emp;
import com.hy.springmvc.pojo.EmpDept;
import com.hy.springmvc.service.EmpService;
import com.hy.springmvc.util.Utils;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Api
@Controller
public class EmpController{
    @Resource
    private EmpService empService;

    @ResponseBody
    @GetMapping("/querylist")
    public Layui queryList(Emp emp, Integer page, Integer limit){
        IPage<EmpDept> page1 = empService.querylist(page,limit,emp);
        Layui layui= new Layui();
        layui.setCode(0);
        layui.setMsg("");
        layui.setCount(Integer.parseInt(Long.toString(page1.getTotal())));
        layui.setData(page1.getRecords());
        return layui;
    }

    @ResponseBody
    @PostMapping("/queryBy")
    public EmpDept queryBy(Emp emp){
        return empService.queryBy(emp);
    }

    @ResponseBody
    @PostMapping("/queryname.do")
    public List<Dept> queryname(){
        return empService.queryDname();
    }


    @PostMapping("/queryById.do")
    @ResponseBody
    @ApiOperation(value = "根据员工编号查询一个员工信息")
    @ApiResponses(value = {//对响应的结果以及响应的值类型进行说明
            @ApiResponse(code = 200, message = "查询成功", response = String.class),
    })
    public Emp queryById(@ApiParam(required = true,name = "eid",value = "员工ID") @RequestParam("eid") Integer eid){
        return empService.getById(eid);
    }

    @GetMapping("/query.do")
    public String query(Emp emp,Model model){
        model.addAttribute("list",empService.querylist(0,20,emp).getRecords());
        return "/test";
    }

    @GetMapping("/del.do")
    @ResponseBody
    public String del(@Param("eid") Integer eid){
        try {
            empService.removeById(eid);
        } catch (Exception e) {
            return Utils.delIsError;
        }
        return Utils.delIsSeccuss;
    }

    @GetMapping("/delete.do")
    @ResponseBody
    public String delete(String ids[]){
        try {
            empService.removeByIds(Arrays.asList(ids));
        } catch (Exception e) {
            return Utils.delIsError;
        }
        return Utils.delIsSeccuss;
    }

    @PostMapping("/save.do")
    @ResponseBody
    public String save(@RequestBody Emp emp){
        try {
            empService.save(emp);
        } catch (Exception e) {
            return Utils.delIsError;
        }
        return Utils.delIsSeccuss;
    }

    @PostMapping("/update.do")
    @ResponseBody
    public String update(@RequestBody Emp emp){
        try {
            empService.updateById(emp);
        } catch (Exception e) {
            return Utils.delIsError;
        }
        return Utils.delIsSeccuss;
    }
}
