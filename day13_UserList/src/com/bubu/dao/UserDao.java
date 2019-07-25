package com.bubu.dao;

import com.bubu.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {


    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);

    public void addUser(User user);

    public void deleteUser(int id);

    public User findUserById(int id);

    public void updateUser(User user);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    public int findTotalCount(Map<String, String[]> condition);

    /**
     * 根据页面查询所显示的用户
     * @param startIndex
     * @param rows
     * @param condition
     * @return 当前页面的用户信息列表
     */
    public List<User> findByPage(int startIndex, int rows, Map<String, String[]> condition);
}
