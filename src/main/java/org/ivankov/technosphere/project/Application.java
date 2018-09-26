package org.ivankov.technosphere.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.ivankov.technosphere.project.controller", "org.ivankov.technosphere.project.repository", "org.ivankov.technosphere.project.config"})
@EnableJpaRepositories(basePackages = "org.ivankov.technosphere.project.repository")
//        entityManagerFactoryRef = "factoryBean")
@EntityScan(basePackages = "org/ivankov/technosphere/project/model")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
