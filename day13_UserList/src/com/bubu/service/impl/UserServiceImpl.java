package com.bubu.service.impl;

import com.bubu.dao.UserDao;
import com.bubu.dao.impl.UserDaoImpl;
import com.bubu.domain.PageBean;
import com.bubu.domain.User;
import com.bubu.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());

    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.deleteUser(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                dao.deleteUser(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        // 1.创建空的PageBean对象
        PageBean<User> pageBean = new PageBean<>();

        // 2.设置当前页面属性和rows属性
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        // 3.调用dao查询totalCount总记录数
        int totalCount = dao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);

        // 4.计算页面显示的第一个索引
        int startIndex = (currentPage - 1) * rows;

        // 5.调用dao查询list集合
        List<User> list = dao.findByPage(startIndex, rows, condition);
        pageBean.setList(list);

        // 6.计算总页数
        int totalPage = totalCount % rows == 0 ? (totalCount / rows) : (totalCount / rows + 1);
        pageBean.setTotalPage(totalPage);

        // 7.返回PageBean对象
        return pageBean;
    }
}
