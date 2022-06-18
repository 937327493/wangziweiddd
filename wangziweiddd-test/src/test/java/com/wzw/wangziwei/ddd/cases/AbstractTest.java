package com.wzw.wangziwei.ddd.cases;

import com.wzw.wangziwei.ddd.application.people.command.PeopleApplication;
import com.wzw.wangziwei.ddd.config.MybatisConfig;
import com.wzw.wangziwei.ddd.config.MysqlDBConfig;
import com.wzw.wangziwei.ddd.domain.people.PeopleFactory;
import com.wzw.wangziwei.ddd.infrastructure.gateway.QueryPeopleGatewayServiceImpl;
import com.wzw.wangziwei.ddd.infrastructure.query.PeopleQueryServiceImpl;
import com.wzw.wangziwei.ddd.infrastructure.repository.impl.PeopleRepositoryImpl;
import com.wzw.wangziwei.ddd.interfaces.people.PeopleFacadeImpl;
import com.wzw.wangziwei.ddd.mock.mockExternalInterfaceMockImpl;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        PeopleFacadeImpl.class,
        PeopleApplication.class,
        PeopleQueryServiceImpl.class,
        PeopleFactory.class,
        PeopleRepositoryImpl.class,
        MybatisConfig.class,
        MysqlDBConfig.class,
        mockExternalInterfaceMockImpl.class,
        QueryPeopleGatewayServiceImpl.class
})
@TestPropertySource("classpath:application-test.yaml")
@ActiveProfiles("test")
public abstract class AbstractTest {
}
