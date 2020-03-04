import com.xiong.pojo.Books;
import com.xiong.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService)context.getBean("BookServiceImpl");
        for(Books books:bookServiceImpl.queryAllBooks()){
            System.out.println((books));
        }
    }
}
