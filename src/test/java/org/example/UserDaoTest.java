package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {

    @BeforeEach
    void setUp() { // 테스트코드를 작성하기 전 설정해야 코드를 작성
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql")); // resource 에 있는 db_schema.sql 을 읽음(테이블 생성)
        DatabasePopulatorUtils.execute(populator, ConnectionManger.getDataSource()); // 실행
    }

    @Test
    void createTest() throws SQLException {
        UserDao userDao = new UserDao();

        userDao.create(new User("wizard", "password", "name", "email")); // userDao 에게 유저 정보를 저장해달라고 요청

        User user = userDao.findByUserId("wizard");  // userDao 에게 해당 정보를 조회
        assertThat(user).isEqualTo(new User("wizard", "password", "name", "email")); // 조회된 정보가 같은지 검증
    }
}
