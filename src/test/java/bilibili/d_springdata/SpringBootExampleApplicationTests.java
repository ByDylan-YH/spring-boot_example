package bilibili.d_springdata;

import bilibili.d_spingdata.SpringDataExampleApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@ContextConfiguration(classes = SpringDataExampleApplication.class)
class SpringBootExampleApplicationTests {
    private Logger logger = LoggerFactory.getLogger(SpringBootExampleApplicationTests.class);

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        logger.info("getClass: {}", dataSource.getClass());
        try {
            Connection connection = dataSource.getConnection();
            logger.info("connection: {}", connection);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
