import com.kuang.pojo.User;
import com.kuang.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

	public static void main(String[] args) {

		//Spring容器，就类似于婚介网站
		ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");

		User user = (User) context.getBean("user");
		User user2 = (User) context.getBean("user");
		user.show();
		System.out.println(user== user2);

		UserT user1 = (UserT)context.getBean("u4");
		user1.show();

		//总结：在配置文件加载的时候，容器中管理的对象就已经被初始化了！


	}
}
