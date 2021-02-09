package com.exaucet.joblessito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class JoblessitoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleApplication.class);

    public static void main(final String[] args) {
        SpringApplication.run(JoblessitoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> {

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Let's inspect the beans provided by Spring Boot:");
                final String[] beanNames = ctx.getBeanDefinitionNames();
                Arrays.sort(beanNames);
                for (final String beanName : beanNames) {
                    LOGGER.debug(beanName);
                }
            }
        };
    }

}
