package baronvice.springstuff;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        // That's how we can take bean (first arg - bean id, second arg - class name)
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean.getName());

        // After you've finished with application context it should be closed
        context.close();
    }
}
