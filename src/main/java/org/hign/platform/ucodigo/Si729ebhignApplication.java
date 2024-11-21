package org.hign.platform.ucodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Si729ebhignApplication
 *
 * @summary
 * The main class of the HIGN Platform application.
 * It is responsible for starting the Spring Boot application.
 * It also enables JPA auditing.
 *
 * @since 1.0
 */
@EnableJpaAuditing
@SpringBootApplication
public class Si729ebhignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Si729ebhignApplication.class, args);
    }

}
