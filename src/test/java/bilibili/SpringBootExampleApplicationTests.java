package bilibili;

import bilibili.a_startdemo.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Person.class)
public class SpringBootExampleApplicationTests {
    private Logger logger = LoggerFactory.getLogger(SpringBootExampleApplicationTests.class);

    @Autowired
    Person person;

    @Test
    public void contextLoads() {
        logger.info("测试 {}"," by");
        System.out.println(person);
    }
}
