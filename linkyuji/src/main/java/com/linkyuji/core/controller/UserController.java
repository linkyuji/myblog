package com.linkyuji.core.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.linkyuji.core.pojo.UserBean;
import com.linkyuji.core.service.UserService;

@Controller
@RequestMapping("/view")
public class UserController {
	@Resource(name = "userServiceImpl")
	private UserService userService;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String toIndex(HttpServletRequest request, Model model) {		
				UserBean userLogin = new UserBean();
		userLogin.setUsername(request.getParameter("username"));
		userLogin.setUserpwd(request.getParameter("password"));
		System.out.println(userLogin.getUsername() + "    " + userLogin.getUserpwd());
		boolean islogin = false;
		UserBean user;
		boolean getlog = this.userService.getLoginUser(userLogin);
		if (getlog) {
			islogin = this.userService.getLoginUser(userLogin);
			System.out.println(userLogin.getUsername() + "get user success");
			user = userService.getUserById(userLogin.getUsername());
			model.addAttribute("user", user);
			request.getSession().setAttribute("user", user);

		} else {

			model.addAttribute("user can not in use");
			System.out.println("can not get user");
			return "redirect:/index.jsp";
		}
		System.out.println("登录成功");
		return "redirect:/index.jsp";
	}
}
