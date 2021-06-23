package com.bilibili.f_jdbc.Dao;

import com.bilibili.f_jdbc.entity.Student;

import java.util.List;

/**
 * Author:BYDylan
 * Date:2021/6/23
 * Description:
 */
public interface StudentDao {
    /**
     * 保存数据
     *
     * @param student 单条student记录
     */
    void save(Student student);

    /**
     * 删除数据
     *
     * @param id 学生id
     */
    void delete(long id);

    /**
     * 更新数据
     *
     * @param student 单条student记录
     */
    void update(Student student);

    /**
     * 查询数据
     *
     * @param name 姓名
     * @return 返回单条记录
     */
    Student findByName(String name);

    /**
     * 查询全部数据
     *
     * @return 返回全部记录
     */
    List<Student> findAll();
}
