package com.fbart.eshop.loveshopping.web;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public String register(Model model) throws ParseException{
		TbUserInf userInf=new TbUserInf();
		userInf.setUsername("suibeibei");
		userInf.setPassword("123456");
		userInf.setSex(0);
		userInf.setMobile("13621817504");
		userInf.setEmail("1205399775@qq.com");
		userInf.setAddr("昌城镇");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date birth = sdf.parse("1992-01-27");
		userInf.setBirth(birth);
		Serializable serializable = userService.userRegister(userInf);
		String s = serializable.toString();
		log.info("主键："+s);
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
