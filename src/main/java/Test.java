import com.eknv.dao.JavaTestDao;
import com.eknv.model.JavaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) throws Exception {

    	ApplicationContext context =
    		new ClassPathXmlApplicationContext("spring-context.xml");

        JavaTestDao javaTestDao = (JavaTestDao) context.getBean("JavaTestDao");
        JavaTest javaTest = new JavaTest(3, "hello3",33);
        javaTestDao.insert(javaTest);
 
        JavaTest javaTest1 = javaTestDao.findById(1);
        System.out.println(javaTest1);

    }
}

