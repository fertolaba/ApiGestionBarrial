package com.example.demo.Repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Procedure(procedureName = "GetUserInfo")
    User getUserInfo(String documento, String password);
    Optional<User> findByMail(String mail);

    Optional<User> findByMailAndDocumento(String mail, String documento);

}
