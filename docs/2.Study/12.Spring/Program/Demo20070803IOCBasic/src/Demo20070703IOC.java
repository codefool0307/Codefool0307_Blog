import com.sun.crypto.provider.PBEWithMD5AndDESCipher;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo20070703IOC {
	@Test
	public void test01(){
		ClassPathXmlApplicationContext ioc =
			new ClassPathXmlApplicationContext("spring-config.xml");
		 person bean = (person) ioc.getBean("person01");
		 
		System.out.println(bean);
	}

}
