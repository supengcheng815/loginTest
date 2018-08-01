package com.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Users;
import com.service.UsersService;

@Controller
@Scope("prototype")
public class LoginController extends GenericController {

	@Resource(name = "usersService")
	private UsersService usersService;

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping(value = "/goLogin.do")
	public ModelAndView goLogin() {
		return new ModelAndView("login");
		
	}
	
	
	@RequestMapping(value = "/LoginController_login.do")
	public ModelAndView login(Users users) {
		Users currentUser = this.usersService.loginValidate(users.getUsername());
		if (currentUser == null) {
			// this.request.setAttribute("error", "该账户不存在");
			// return "login";
			return new ModelAndView("login", "error", "该账户不存在");
		} else {
			if (currentUser.getPassword().equals(users.getPassword())) {
				this.session.setAttribute("currentUser", currentUser);
				// return "index";
				// return "redirect:/index.jsp";// 重定向方式
				return new ModelAndView("index");
			} else {
				// this.request.setAttribute("error", "密码错误");
				// return "login";
				return new ModelAndView("login", "error", "密码错误");
			}
		}
	}

	@RequestMapping(value = "/LoginController_logout.do")
	public String logout() {
		return "success";
	}

}
