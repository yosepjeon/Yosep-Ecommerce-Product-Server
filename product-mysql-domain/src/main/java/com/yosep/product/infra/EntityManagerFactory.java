package com.yosep.product.infra;

import java.util.HashMap;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntityManagerFactory {

    private final Environment env;

    public LocalContainerEntityManagerFactoryBean getEntityManger(
            DataSource dataSource,
            String[] packageName
    ) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(packageName);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
        em.setJpaPropertyMap(properties);
        return em;
    }
}
