package com.rocksplit.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DatabaseConfig {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void checkDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            log.info("✅ Successfully connected to PostgreSQL database!");
            log.info("Database product: {}", connection.getMetaData().getDatabaseProductName());
            log.info("Database version: {}", connection.getMetaData().getDatabaseProductVersion());

            // Check if tables exist (will throw exception if tables don't exist)
            Integer userCount = jdbcTemplate.queryForObject("SELECT count(*) FROM users", Integer.class);
            log.info("Users table exists with {} records", userCount);

        } catch (SQLException e) {
            log.error("❌ Failed to connect to PostgreSQL database!", e);
            log.error("Connection error: {}", e.getMessage());
        } catch (Exception e) {
            log.warn("Database connected but tables may not exist yet: {}", e.getMessage());
            log.info("This is expected if you're running the application for the first time.");
            log.info("Flyway migrations will create the tables automatically.");
        }
    }
}