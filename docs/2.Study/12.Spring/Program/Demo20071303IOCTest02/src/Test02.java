import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
	private ClassPathXmlApplicationContext ioc
			= new ClassPathXmlApplicationContext("spring-config.xml");
	@Test
	public void test02(){
		person bean = ioc.getBean("person02",person.class);
		System.out.println(bean);
	}
}
