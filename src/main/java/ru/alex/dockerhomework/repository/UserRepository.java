package ru.alex.dockerhomework.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.alex.dockerhomework.entity.User;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(String name, String age) {
        jdbcTemplate.update("INSERT INTO users (name, age) VALUES (?,?)", name, age);
    }

    public void deleteUser(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id  = ?", id);
    }

    public User getUser(Long id) {
        return jdbcTemplate.queryForObject("SELECT id, name, age FROM users WHERE id = ?",
                new BeanPropertyRowMapper<>(User.class), id);
    }
}