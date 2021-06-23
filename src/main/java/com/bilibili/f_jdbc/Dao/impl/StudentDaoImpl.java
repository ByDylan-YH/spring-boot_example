package com.bilibili.f_jdbc.Dao.impl;

import com.bilibili.f_jdbc.Dao.StudentDao;
import com.bilibili.f_jdbc.entity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:BYDylan
 * Date:2021/6/23
 * Description:
 */
@Repository
public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate mJdbcTemplate;

    /**
     * 构造方法自动装配
     * @param jdbcTemplate JdbcTemplate
     */
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.mJdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Student student) {
        mJdbcTemplate.update("INSERT INTO student(name,password,age) values(?,?,?) ",
                student.getName(), student.getPassword(), student.getAge());
    }

    @Override
    public void delete(long id) {
        mJdbcTemplate.update("DELETE FROM student where id=?", id);
    }

    @Override
    public void update(Student student) {
        mJdbcTemplate.update("UPDATE student SET name=?,password=?,age=? WHERE id=?",
                student.getName(), student.getPassword(), student.getAge(), student.getId());
    }

    @Override
    public Student findByName(String name) {
        Object[] args = {name};
        return mJdbcTemplate.queryForObject("SELECT * FROM student WHERE name=?", args,
                new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public List<Student> findAll() {
        return mJdbcTemplate.query("SELECT * FROM student",new BeanPropertyRowMapper<>(Student.class));
    }
}
