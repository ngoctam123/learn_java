package com.example.demo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
 
@SpringBootApplication
@Controller
public class HomeController implements CommandLineRunner {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
     
    public static void main(String[] args) {
        SpringApplication.run(HomeController.class, args);
    }
 
    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM SV";
        List<SV> customers = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(SV .class));
         
        customers.forEach(System.out :: println);
    }
 
}
