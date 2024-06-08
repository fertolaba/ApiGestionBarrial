package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    //@PostConstruct

    public void createProcedureGetUserInfo() {
        String sql = "IF OBJECT_ID('GetUserInfo', 'P') IS NOT NULL " +
            "DROP PROCEDURE GetUserInfo; " +
            "CREATE PROCEDURE GetUserInfo " +
            "    @identificacion VARCHAR(20),\n" +
            "    @password VARCHAR(40)" +
            "AS " +
            "BEGIN " +
            "   SELECT " +
            "       documento AS identificacion, "+
            "       password "+
            "       'vecino' AS tipoUsuario" +
            "   FROM "+
            "       usuarios"+
            "   UNION"+
            "   SELECT"+
            "        CAST(legajo AS VARCHAR(40)) AS identificacion, "+
            "        password "+
            "        'inspector' AS tipoUsuario" +
            "   FROM "+
            "       personal "+
            "WHERE " +
            "        CAST(legajo AS VARCHAR(40)) = @identificacion AND password = @password; " +
            "END";

        jdbcTemplate.execute(sql);
    }

    public User getUserInfo(String identificador, String password) {
        return userRepository.getUserInfo(identificador, password);
    }
}
