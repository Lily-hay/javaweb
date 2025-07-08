package com.lily.controller;

import com.lily.Service.DeptServicelmpl;
import com.lily.entity.Dept;
import com.lily.entity.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    //private DeptServicelmpl deptService = new DeptServicelmpl();
    @Resource(name="deptServicelmpl")
    //@Qualifier(value = "service2")
   // @Autowired
    private DeptServicelmpl deptService;
    @GetMapping("/depts")
    public Result getAll() throws Exception {
        /*//1.加载dept.txt数据并读取
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\java codes\\javaweb\\java147\\tlias-web-manager\\src\\main\\resources\\dept.txt"));

        ArrayList<Dept> depts = new ArrayList<>();
        String line;
        //2.解析文本中的数据，并转为集合
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            Integer id = Integer.valueOf(parts[0]);
            String name = parts[1];
            LocalDateTime time = LocalDateTime.parse(parts[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            depts.add(new Dept(id, name, time));

        }*/
        //3.响应数据
        List<Dept> depts=deptService.list();

        return Result.success(depts);
    }
}