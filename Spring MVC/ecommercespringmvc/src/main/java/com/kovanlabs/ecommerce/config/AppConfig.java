
package com.kovanlabs.ecommerce.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration // tells this class has a source of bean
@ComponentScan("com.kovanlabs.ecommerce") // scans dao, service,repository components in ecommerce
// Services/DAO belong to application layer, so they live in Root Context
@Import(JDBCConfig.class)
public class AppConfig{
}