package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
//import javax.annotation.PostConstruct;


@Service
public class AuthService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUserInfo(String documento, String password) {
        return jdbcTemplate.queryForObject(
                "EXEC GetUserInfo ?, ?", new Object[] { documento, password },
                new BeanPropertyRowMapper<>(User.class));
    }
}
