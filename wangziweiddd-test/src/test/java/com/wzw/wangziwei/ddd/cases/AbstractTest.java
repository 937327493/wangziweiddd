package com.wzw.wangziwei.ddd.cases;

import com.wzw.wangziwei.ddd.application.log.command.LogApplication;
import com.wzw.wangziwei.ddd.application.people.command.PeopleApplication;
import com.wzw.wangziwei.ddd.config.MybatisConfig;
import com.wzw.wangziwei.ddd.config.MysqlDBConfig;
import com.wzw.wangziwei.ddd.domain.Log.LogFactory;
import com.wzw.wangziwei.ddd.domain.people.PeopleFactory;
import com.wzw.wangziwei.ddd.infrastructure.gateway.QueryPeopleGatewayServiceImpl;
import com.wzw.wangziwei.ddd.infrastructure.query.PeopleQueryServiceImpl;
import com.wzw.wangziwei.ddd.infrastructure.repository.impl.LogRepositoryImpl;
import com.wzw.wangziwei.ddd.infrastructure.repository.impl.PeopleRepositoryImpl;
import com.wzw.wangziwei.ddd.interfaces.people.PeopleFacadeImpl;
import com.wzw.wangziwei.ddd.mock.RedisServiceMockImpl;
import com.wzw.wangziwei.ddd.mock.RocketMqServiceMockImpl;
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
        mockExternalInterfaceMockImpl.class,//外部微服务 mock接口
        QueryPeopleGatewayServiceImpl.class,
//        RocketMqServiceImpl.class,//rocketmq真实环境放开
        RocketMqServiceMockImpl.class,//rocketmq mock假数据
        RedisServiceMockImpl.class,
        LogApplication.class,
        LogRepositoryImpl.class,
        LogFactory.class

})
@ActiveProfiles("test")
@TestPropertySource(value = {"classpath:application.properties"})
public abstract class AbstractTest {
}
