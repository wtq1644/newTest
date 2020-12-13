import com.kuang.dao.UserDaoMysqlImpl;
import com.kuang.dao.UserDaoSQLserverImpl;
import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	public static void main(String[] args) {

//		//用户实际调用的是业务层，dao层他们不需要接触！
//		UserService userService = new UserServiceImpl();
//
//		//这种思想，从本质上解决了问题，我们程序猿不用再去管理对象的创建了。系统的耦合性大大降低
//		//程序猿可以更加专注的在业务的实现上  这是IOC的原型
//		((UserServiceImpl) userService).setUserDao(new UserDaoSQLserverImpl());
//
//		userService.getUser();

		//获取ApplicationContext;
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//容器在手，天下我有，需要什么，就直接get什么！
		UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");

		userServiceImpl.getUser();


	}
}
