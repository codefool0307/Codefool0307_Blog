import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06 {
	private ClassPathXmlApplicationContext ioc
		= new ClassPathXmlApplicationContext("spring-config.xml");

	@Test
	public void test06(){
		person person03 = (person) ioc.getBean("person06");
		System.out.println(person03);
	}

}
