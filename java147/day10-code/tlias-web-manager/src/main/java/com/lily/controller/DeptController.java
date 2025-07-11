package com.lily.controller;

import com.lily.Service.DeptServicelmpl;
import com.lily.entity.Dept;
import com.lily.entity.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    //private DeptServicelmpl deptService = new DeptServicelmpl();
    @Resource(name="deptServicelmpl")
    //@Qualifier(value = "service2")
   // @Autowired
    private DeptServicelmpl deptService;
    @GetMapping
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

    //方式一：原始的HttpServletRequest对象获取请求参数
    /*@DeleteMapping("/depts")
    public Result delete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        int idInt=Integer.parseInt(id);
        System.out.println(idInt);
        return Result.success();
    }*/

    //方式二：通过@RequestParam注解进行参数绑定，一旦加了RequestParam，默认required=true
    //则前端必须传入id参数，不传就会报错误400，bad request;将默认值改为false，则不需要
    /*@DeleteMapping("/depts")
    public Result delete(@RequestParam(value = "id",required = false) Integer deptId) throws Exception {
        System.out.println(deptId);
        return Result.success();
    }*/

    //方式三：保证请求参数名与形参变量名相同，直接接收（推荐）
    @DeleteMapping
    public Result delete(Integer id) {
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Dept dept)  {
        deptService.save(dept);
        return Result.success();
    }

    /*根据id查询部门
    * @param id
    * */
    //@Pathvariable 获取请求参数路径
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id) {
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success(dept);
    }
}