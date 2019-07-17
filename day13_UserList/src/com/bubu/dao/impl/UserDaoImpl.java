package com.bubu.dao.impl;

import com.bubu.dao.UserDao;
import com.bubu.domain.User;
import com.bubu.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null);";
        template.update(
                sql,
                user.getName(),
                user.getGender(),
                user.getAge(),
                user.getAddress(),
                user.getQqNum(),
                user.getEmail()
        );
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql, id);
    }
}