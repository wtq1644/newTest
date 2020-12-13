import com.kuang.pojo.Address;
import com.kuang.pojo.Student;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

	public static void main(String[] args) {
		ApplicationContext context =	new ClassPathXmlApplicationContext("beans.xml");
		Student student =(Student) context.getBean("student");
//		System.out.println(student.getName());
		System.out.println(student.toString());


	}

	@Test
	public void test2(){
		ApplicationContext context1 = new ClassPathXmlApplicationContext("userbeans.xml");
//		User user = context1.getBean("user",User.class);
		User user = context1.getBean("user2",User.class);
		System.out.println(user);

		User user2 = context1.getBean("user2",User.class);
		System.out.println(user==user2);
	}


}
