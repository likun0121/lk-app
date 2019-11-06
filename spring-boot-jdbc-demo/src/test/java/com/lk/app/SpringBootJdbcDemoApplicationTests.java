package com.lk.app;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
@Slf4j
class SpringBootJdbcDemoApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
        log.info("数据源类型：{}", dataSource.getClass());
    }

}
