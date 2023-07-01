package org.example;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// 참고: https://popawaw.tistory.com/313, https://lovon.tistory.com/96
public class ConnectionManger {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
    public static final int MAX_POOL_SIZE = 40;
    private static final DataSource ds;

    static { // Connection Pool 적용
        HikariDataSource hikariDataSource = new HikariDataSource(); // HikariCP의 DataSource 사용(DataSource: 커넥션 획득하기 위한 표준 인터페이스)
        hikariDataSource.setDriverClassName(DB_DRIVER); // h2DB
        hikariDataSource.setJdbcUrl(DB_URL); // JDBC URL
        hikariDataSource.setUsername("sa");
        hikariDataSource.setPassword("");
        hikariDataSource.setMaximumPoolSize(MAX_POOL_SIZE);  // 커넥션 수를 설정(크면 사용자 대기 시간 줄어들지만 메모리 소모 ↑, 작으면 사용자 대기 시간이 길어질 수 있지만 메모리 소모 ↓)
        hikariDataSource.setMinimumIdle(MAX_POOL_SIZE);  // HikariCP 에서는 maximumPoolSize 와 동일하게 하는 것을 권장

        //        hikariDataSource.setIdleTimeout(600000);      // pool 에서 일을 안하는 커넥션을 유지하는 시간, default 600000, minimum-idle 이 maximum-pool-size 보다 작을때만 설정
        //        hikariDataSource.setMaxLifetime();            // 커넥션 최대 수명 시간 default 1800000
        // HikariCP 에서는 30초 이상 응답이 지연시 강제로 Connection 을 끊어 버림.

        ds = hikariDataSource;
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
