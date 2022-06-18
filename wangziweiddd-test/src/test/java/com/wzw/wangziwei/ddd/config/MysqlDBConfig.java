package com.wzw.wangziwei.ddd.config;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.ScriptResolver;
import com.wix.mysql.config.DownloadConfig;
import com.wix.mysql.config.MysqldConfig;
import org.apache.commons.lang3.ArrayUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.config.Charset.UTF8;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v5_6_23;

/**
 * 配置内存数据库
 */
@Configuration
@EnableTransactionManagement
public class MysqlDBConfig {
    //启动webServer用
    public static DataSource dataSourceForWebServer;

    public static final int port = 2215;
    public static final String userName = "wzw";
    public static final String password = "wzw";
    public static final String databaseName = "wangziwei";

    @Bean(name = "defaultDataSource")
    public DataSource getDataSource() throws SQLException {
        if (dataSourceForWebServer == null) {

            MysqldConfig config = aMysqldConfig(v5_6_23)
                    .withCharset(UTF8)
                    .withPort(port)
                    .withUser(userName, password)
                    .withTimeZone("Asia/Shanghai")
                    .withTimeout(2, TimeUnit.MINUTES)
                    .withServerVariable("max_connect_errors", 999)
                    .build();

            List scriptList = new ArrayList();
            scriptList.add(ScriptResolver.classPathScript("ddlScript/People.sql"));


            DownloadConfig downloadConfig = DownloadConfig.aDownloadConfig()
                    .build();
            EmbeddedMysql mysqld = anEmbeddedMysql(config)
                    .addSchema(databaseName, scriptList)
                    .withDownloadConfig(downloadConfig)
                    .start();

            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setDatabaseName(databaseName);
            dataSource.setServerName("localhost");
            dataSource.setPort(2215);
            dataSource.setUser(userName);
            dataSource.setPassword(password);
            dataSource.setUseSSL(false);
            dataSource.setServerTimezone(TimeZone.getTimeZone("GMT+:08:00").getID());

            dataSourceForWebServer = dataSource;
        }

        return dataSourceForWebServer;
    }

    /**
     * 测试类mapper.xml的路径配置
     *
     * @return
     * @throws IOException
     */
    private Resource[] getMapperResources() throws IOException {
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = patternResolver.getResources("classpath*:/mybatis/*mapper.xml");
        return ArrayUtils.addAll(resources);
    }


    /**
     * 会话工厂
     * @param dataSource
     * @return
     * @throws IOException
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(getMapperResources());
        return sessionFactoryBean;
    }
}