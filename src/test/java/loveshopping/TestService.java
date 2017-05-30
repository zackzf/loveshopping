package loveshopping;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fbart.eshop.loveshopping.service.UserService;

public class TestService {
	@Test
	public void testUserService(){
		// 读取一个文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		// 读取多个文件
//		ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(new String[] {
//				"applicationContext-ibatis-oracle.xml", "applicationContext.xml", "applicationContext-data-oracle.xml" });
//		BeanFactory factory = resource;
//		UserDao userDao = (UserDao) factory.getBean("userDao");
		userService.showUserInf();
	}
}
