package com.bubu.dao.impl;

import com.bubu.dao.UserDao;
import com.bubu.domain.User;
import com.bubu.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name = ?, gender = ?, age = ?, address = ?, qqNum = ?, email = ? where id = ?";
        template.update(
                sql,
                user.getName(),
                user.getGender(),
                user.getAge(),
                user.getAddress(),
                user.getQqNum(),
                user.getEmail(),
                user.getId()
        );
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        // 定义初始化sql
        String sql = "select count(*) from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);

        List<Object> params = new ArrayList<Object>();
        // 遍历map
        for (String key : condition.keySet()) {

            // 排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            String value = condition.get(key)[0];
            if (value != null && !("".equals(value))) {
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");
            }
        }
        sql = sb.toString();

        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int startIndex, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<Object>();
        // 遍历map
        for (String key : condition.keySet()) {

            // 排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            String value = condition.get(key)[0];
            if (value != null && !("".equals(value))) {
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");
            }
        }
        sb.append(" limit ? , ? ");
        sql = sb.toString();
        params.add(startIndex);
        params.add(rows);

        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }
}
