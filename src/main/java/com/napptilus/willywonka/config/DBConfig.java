package com.napptilus.willywonka.config;

import com.napptilus.willywonka.config.flyway.DataCleanMigration;
import com.napptilus.willywonka.config.flyway.DataMigration;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * DB Configuration
 */
@Configuration
public class DBConfig {

    @Bean
    @Profile("dev")
    public FlywayMigrationStrategy cleanMigrationStrategy() {
        return new DataCleanMigration();
    }

    @Bean
    @Profile("prod")
    public FlywayMigrationStrategy migrationStrategy() {
        return new DataMigration();
    }
}
