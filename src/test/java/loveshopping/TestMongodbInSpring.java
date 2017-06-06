package loveshopping;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fbart.eshop.loveshopping.dao.nosql.PersonNDAO;
import com.fbart.eshop.loveshopping.model.nosql.PersonN;

public class TestMongodbInSpring {
	PersonNDAO pr=null;
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		pr = (PersonNDAO) ctx.getBean("personNDAO");

	}

	/**
	 * 
	 * <b>function:</b>添加
	 * 
	 * @author cuiran
	 * @createDate 2012-12-12 16:11:01
	 */
	public void insert() {

		PersonN p = new PersonN("cuiran", 27);
		pr.insert(p);
	}

	/**
	 * 
	 * <b>function:</b>根据输入的ID查找对象
	 * 
	 * @author cuiran
	 * @createDate 2012-12-12 16:24:10
	 */
	public void findOne() {
		String id = "5932d0ae1c3d811f9cdb37cd";
		PersonN p = pr.findOne(id);
		System.out.println(p.toString());
	}

	/**
	 * 
	 * <b>function:</b>查询所有
	 * 
	 * @author cuiran
	 * @createDate 2012-12-12 16:08:54
	 */
	public void listAll() {

		List<PersonN> list = pr.findAll();
		for (PersonN p : list) {
			System.out.println(p.toString());
		}

	}

	/**
	 * 
	 * <b>function:</b>测试方法
	 * 
	 * @author cuiran
	 * @createDate 2012-12-12 16:11:37
	 */
	public void start() {
		init();

//		 insert();
//		 listAll();

		findOne();
	}

	/**
	 * <b>function:</b>main函数
	 * 
	 * @author cuiran
	 * @createDate 2012-12-12 11:54:30
	 */
	public static void main(String[] args) {
		TestMongodbInSpring t = new TestMongodbInSpring();
		t.start();
	}
}
