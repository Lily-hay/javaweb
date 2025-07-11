package com.lily.Dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
//@Component
@Repository
public class DeptDaolmpl implements DeptDao {
    public List<String> daolmpl() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\java codes\\javaweb\\java147\\tlias-web-manager\\src\\main\\resources\\dept.txt"));

        String line;
        //2.解析文本中的数据，并转为集合

        ArrayList<String> strings = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        return strings;
    }
}
