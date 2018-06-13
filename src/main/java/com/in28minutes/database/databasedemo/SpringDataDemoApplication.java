package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import com.in28minutes.database.databasedemo.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonSpringDataRepository personJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}   ", personJpaRepository.findAll());
        logger.info("User id 1001 -> {}   ", personJpaRepository.findById(1001));
        logger.info("inserting id 1004 -> No of Rows Deleted - {}   ", personJpaRepository.save(new Person("lopas", "berlin", new Date())));
        logger.info("update 1001 -> {}  ", personJpaRepository.save(new Person(1001, "tralialia", "omg", new Date())));
        personJpaRepository.deleteById(1002);
    }
}
