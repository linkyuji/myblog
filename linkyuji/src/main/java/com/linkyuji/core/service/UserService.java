package com.linkyuji.core.service;

import com.linkyuji.core.pojo.UserBean;;


public interface UserService {
	public boolean getLoginUser(UserBean user);

	public UserBean getUserById(String userid);

}