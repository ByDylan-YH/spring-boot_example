package com.bilibili.d_spingdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Author:BYDylan
 * Date:2020/7/2
 * Description:
 */
@RestController
public class JDBCController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/selectDemo")
    public List<Map<String, Object>> selectDemo() {
        String sql = "select * from daas_user_key;";
        return jdbcTemplate.queryForList(sql);
    }

    //    仅供参考
    @GetMapping("/insertDemo")
    public String insertDemo() {
        String sql = "insert into daas.daas_user_key values ('value1','value2','value3','value4');";
        jdbcTemplate.update(sql);
        return "Insert success";
    }

    //    仅供参考
    @GetMapping("/updateDemo/{id}")
    public String updateDemo(@PathVariable("id") int id) {
        String sql = "update daas.daas_user_key set  tenantid=?,tenantname = ? where accesskey = '" + id + "';";
        Object[] objects = new Object[2];
        objects[0] = "a";
        objects[1] = "b";
        jdbcTemplate.update(sql, objects);
        return "Update success";
    }

    //    仅供参考
    @GetMapping("/deleteDemo/{id}")
    public String deleteDemo(@PathVariable("id") int id) {
        String sql = "delete from daas.daas_user_key where accesskey =?;";
        jdbcTemplate.update(sql, id);
        return "Delete success";
    }

}
