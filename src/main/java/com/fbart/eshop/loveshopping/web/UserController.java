package com.fbart.eshop.loveshopping.web;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fbart.eshop.loveshopping.model.TbUserInf;
import com.fbart.eshop.loveshopping.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Log log = LogFactory.getLog(UserController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register.htm")
	public String register(HttpServletRequest request,Model model) throws ParseException, UnsupportedEncodingException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String username = request.getParameter("username");
		String password=request.getParameter("password");
		String addr=request.getParameter("addr");
		String mobile=request.getParameter("mobile");
		String birth=request.getParameter("birth")==""?sdf.format(new Date()):request.getParameter("birth");
		String sex=request.getParameter("sex");
		String email=request.getParameter("email");
		TbUserInf userInf=new TbUserInf();
		userInf.setUsername(username);
		userInf.setPassword(password);
		userInf.setSex(Integer.parseInt(sex));
		userInf.setMobile(mobile);
		userInf.setEmail(email);
		userInf.setAddr(addr);
		Date birthDay = sdf.parse(birth);
		userInf.setBirth(birthDay);
		Serializable serializable = userService.userRegister(userInf);
		String s = serializable.toString();
		System.out.println("ok----------------------主键："+s);
//		System.out.println("ok----------------------用户名："+username);
		return "index";
	}

	// 跳转到首页
	@RequestMapping("/toIndex.do")
	public String toIndex(Model model) {
//		List<EbBrand> brandList = brandService.selectBrand();
//		List<EbFeature> featureList = featureService.selectIsSelFeature();
//		model.addAttribute("brandList", brandList);
//		model.addAttribute("featureList", featureList);
		userService.showUserInf();
		System.out.println("thanks.");
		return "index";
	}
}
