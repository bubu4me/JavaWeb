package com.bubu.service;

import com.bubu.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 登录方法
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 保存新用户数据
     * @param user
     */
    public void addUser(User user);

    /**
     * 删除用户数据
     * @param id
     */
    public void deleteUser(String id);
}
