package com.travisperkins.jobmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ppop on 22/02/2017.
 */
@SpringBootApplication
public class JobManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobManagerApplication.class);
    }

    /*@Bean
    public CommandLineRunner runner(final PersonRepository repository) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                System.err.println(repository.findAll());
            }

        };
    }*/


}
