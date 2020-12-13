import com.kuang.pojo.Cat;
import com.kuang.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		People people = context.getBean("people",People.class);
		people.getDog().shout();
		people.getCat().shout();

		People people2 = new People();
		people2.setName("yyy");
		System.out.println(people2.getName());

	}
}





















