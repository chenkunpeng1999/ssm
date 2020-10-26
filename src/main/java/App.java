import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.hy.springmvc.mapper.empMapper;
import com.hy.springmvc.pojo.Emp;
import com.hy.springmvc.pojo.EmpDept;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World !");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        empMapper empMapper = applicationContext.getBean(empMapper.class);
        Emp emp = new Emp();
        emp.setEname(null);
        Page page = new Page<>(1,3);
        IPage<EmpDept> list = empMapper.querylist(page,emp);

        System.out.println(list.getPages());
        System.out.println(list.getTotal());
    }
}
