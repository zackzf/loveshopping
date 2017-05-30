package loveshopping;

import java.text.ParseException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import com.fbart.eshop.loveshopping.web.UserController;

public class TestController {
	@Test
	public void testUserService() throws ParseException{
		// 读取一个文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserController userController = (UserController) context.getBean("userController");
		// 读取多个文件
//		ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext(new String[] {
//				"applicationContext-ibatis-oracle.xml", "applicationContext.xml", "applicationContext-data-oracle.xml" });
//		BeanFactory factory = resource;
//		UserDao userDao = (UserDao) factory.getBean("userDao");
		Model model=null;
		userController.register(model);
	}
}
