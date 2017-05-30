package com.fbart.eshop.loveshopping.dao;
// Generated 2017-5-30 11:13:09 by Hibernate Tools 4.3.1.Final

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.fbart.eshop.loveshopping.model.TbUserInf;

/**
 * Home object for domain model class TbUserInf.
 * @see com.newone.TbUserInf
 * @author Hibernate Tools
 */
@Repository
public class TbUserInfDAO extends HibernateDaoSupport{

	private static final Log log = LogFactory.getLog(TbUserInfDAO.class);
	@Autowired
    public void setMySessionFactory(SessionFactory sessionFactory){  
        super.setSessionFactory(sessionFactory);  
    }
	public Serializable addUserInf(TbUserInf userInf){
		Serializable identifier = getHibernateTemplate().save(userInf);
		return identifier;
	}
	public TbUserInf getUserInf(){
		TbUserInf userInf = getHibernateTemplate().get(TbUserInf.class, 1);
		return userInf;
	}
}
