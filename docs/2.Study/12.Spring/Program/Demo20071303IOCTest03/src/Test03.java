import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
	private ClassPathXmlApplicationContext ioc
		= new ClassPathXmlApplicationContext("spring-config.xml");

	@Test
	public void test03(){
		person person03 = (person) ioc.getBean("person03");
		System.out.println(person03);
	}

	@Test
	public void test04(){
		person person03 = (person) ioc.getBean("person04");
		System.out.println(person03);
	}

	@Test
	public void test05(){
		person person03 = (person) ioc.getBean("person05");
		System.out.println(person03);
	}

}
