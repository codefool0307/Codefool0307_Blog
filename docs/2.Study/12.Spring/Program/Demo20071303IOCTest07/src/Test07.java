import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {
	private ClassPathXmlApplicationContext ioc
		= new ClassPathXmlApplicationContext("spring-config.xml");

	@Test
	public void test07(){
		person person03 = (person) ioc.getBean("person07");
		System.out.println(person03);
	}

}
