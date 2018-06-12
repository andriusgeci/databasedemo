package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository personJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //logger.info("All users -> {}   ", personJdbcDao.findAll());
        logger.info("User id 1001 -> {}   ", personJpaRepository.findById(1001));
        //logger.info("deleting id 1002 -> No of Rows Deleted - {}   ", personJdbcDao.deleteById(1002));
        logger.info("inserting id 1004 -> No of Rows Deleted - {}   ", personJpaRepository.insert(new Person("lopas", "berlin", new Date())));
        logger.info("update 1001 -> {}  ", personJpaRepository.update(new Person(1001,"tralialia","omg",new Date())));
    }
}
