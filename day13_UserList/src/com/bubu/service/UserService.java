package com.bubu.service;

import com.bubu.domain.PageBean;
import com.bubu.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 登录方法
     *
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 保存新用户数据
     *
     * @param user
     */
    public void addUser(User user);

    /**
     * 删除用户数据
     *
     * @param id
     */
    public void deleteUser(String id);

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    public User findUserById(String id);

    /**
     * 修改用户信息
     *
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除选中用户
     *
     * @param ids
     */
    public void deleteSelectedUser(String[] ids);

    /**
     * 根据页面和查询条件查询所要显示的用户
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
