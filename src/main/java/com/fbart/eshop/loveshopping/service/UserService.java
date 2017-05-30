package com.fbart.eshop.loveshopping.service;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbart.eshop.loveshopping.dao.TbUserInfDAO;
import com.fbart.eshop.loveshopping.model.TbUserInf;
@Service
@Transactional
public class UserService {
	@Autowired
	private TbUserInfDAO userInfDAO;
	public void showUserInf(){
		TbUserInf userInf = userInfDAO.getUserInf();
		System.out.println("user name :"+userInf.getUsername());
		System.out.println("email     :"+userInf.getEmail());
//		System.out.println("test");
//		userInfDAO.testPrint();
	}
	public Serializable userRegister(TbUserInf userInf){
		Serializable n = userInfDAO.addUserInf(userInf);
		return n;
	}
}
