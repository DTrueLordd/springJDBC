package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
@ComponentScan("org.example")
public class AppConfig {

   @Bean("jdbcT")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
       System.out.println("jdbcTemplate created");
       return new JdbcTemplate(dataSource);
   }

}
