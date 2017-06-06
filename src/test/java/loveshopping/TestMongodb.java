package loveshopping;

import java.util.Set;

import org.junit.Test;

import com.mongodb.DB;
import com.mongodb.Mongo;

public class TestMongodb {
	@Test
	public void connectMongodb(){
		Mongo mongo = new Mongo("192.168.80.14",27017);
		DB db=mongo.getDB("mydb");
		Set<String> collectionNames = db.getCollectionNames();
		for (String name : collectionNames) {
			System.out.println("¼¯ºÏÃû£º"+name);
			
		}
	}
}
