package com.yosep.product.domain.global.infra.config;

import com.yosep.product.domain.global.infra.EntityManagerFactory;
import java.util.Objects;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.SpringBeanContainer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "lmsWriteEntityManager",
    transactionManagerRef = "lmsWriteTransactionManager",
    basePackages = {
        "com.yosep.product.domain.category.repository.write",
        "com.yosep.product.domain.common.repository.write",
        "com.yosep.product.domain.product.repository.write"
    }
)
public class YosepWriteDataSourceConfig {
    private final EntityManagerFactory entityManagerFactory;

    private static final String[] LMS_WRITE_PACKAGE_NAME =
        {"com.finda.credit.db.lmsdb.kcb.entity",
            "com.finda.credit.db.lmsdb.credit.entity",
            "com.finda.credit.db.lmsdb.common.entity",
            "com.finda.credit.db.lmsdb.quiz.entity"};

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean yosepWriteEntityManager(
        @Qualifier("yosepWriteDataSource") DataSource dataSource, ConfigurableListableBeanFactory beanFactory
    ) {
        LocalContainerEntityManagerFactoryBean build = entityManagerFactory.getEntityManger(dataSource, LMS_WRITE_PACKAGE_NAME);
        build.getJpaPropertyMap().put(AvailableSettings.BEAN_CONTAINER, new SpringBeanContainer(beanFactory));
        return build;
    }

    @Bean
    @Primary
    public PlatformTransactionManager yosepWriteTransactionManager(
        @Qualifier("yosepWriteEntityManager") LocalContainerEntityManagerFactoryBean entityManager
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(Objects.requireNonNull(entityManager.getObject()));
        return transactionManager;
    }
}
