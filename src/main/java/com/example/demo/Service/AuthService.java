package com.example.demo.Service;

import com.example.demo.entity.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
//import javax.annotation.PostConstruct;


@Service
public class AuthService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AuthService() {
    }

    public UserViewModel getUserInfo(String documento, String password) { // login
        return jdbcTemplate.queryForObject(
                "EXEC GetUserInfo ?, ?", new Object[] { documento, password },
                new BeanPropertyRowMapper<>(UserViewModel.class));
    }
}
