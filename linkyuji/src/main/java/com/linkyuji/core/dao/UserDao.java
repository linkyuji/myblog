package com.linkyuji.core.dao;

import java.util.List;

import com.linkyuji.core.pojo.UserBean;


public interface UserDao {
	List<UserBean> loadAllUser();
	UserBean getLogin(String username);
}
