package com.linkyuji.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkyuji.core.dao.UserDao;
import com.linkyuji.core.pojo.UserBean;
import com.linkyuji.core.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public boolean getLoginUser(UserBean userLogin) {
		// TODO Auto-generated method stub
		if (userLogin.getUsername().equals("") || (userLogin.getUserpwd().equals(""))) {
			return false;
		} else {
			UserBean user = new UserBean();
			if (this.userDao.getLogin(userLogin.getUsername()) != null) {

				user = userDao.getLogin(userLogin.getUsername());

				if (user.toString().isEmpty()) {

					return false;
				} else {

					if (user.getUserpwd().equals(userLogin.getUserpwd())) {
						return true;
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		}
	}

	public UserBean getUserById(String userid) {
		// TODO Auto-generated method stub
		return userDao.getLogin(userid);
	}

}