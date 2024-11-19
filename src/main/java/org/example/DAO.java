package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("dao")

public class DAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DAO(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
        System.out.println("DAO created");
    }

    public void addUser(String name) {
        String sql = "INSERT INTO users (name) VALUE (?)";
        jdbcTemplate.update(sql, name);
        System.out.println("User added");
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new User(
                rs.getInt("id"),
                rs.getString("name")
        ));
    }

    public void deleteAllUsers() {
        String sql = "TRUNCATE TABLE users";

        System.out.println("Deleting all users");
        jdbcTemplate.update(sql);
    }

}
