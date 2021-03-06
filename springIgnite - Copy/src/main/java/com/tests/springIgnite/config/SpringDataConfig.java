package com.tests.springIgnite.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tests.springIgnite.entity.EmployeeDTO;
import com.tests.springIgnite.repository.EmployeeRepository;

@Configuration
@EnableIgniteRepositories(basePackageClasses = EmployeeRepository.class)
@ComponentScan(basePackages = "com.tests.springIgnite.repository")
public class SpringDataConfig {

    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration config = new IgniteConfiguration();
        
        CacheConfiguration cache = new CacheConfiguration("baeldungCache");
        
        cache.setIndexedTypes(Integer.class, EmployeeDTO.class);
        config.setCacheConfiguration(cache);
        return Ignition.start(config);
    }
}
