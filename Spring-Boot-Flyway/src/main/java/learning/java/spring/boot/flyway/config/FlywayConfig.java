package learning.java.spring.boot.flyway.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    /**
     * This Bean deactivates the automatic Import of the sql files
     * located in the ./resources/db.migration/ folder. By uncommenting
     * this bean, the sql scrips can be migrate via FlyWay DI over
     * flyway.migrate.
     */

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return (flyway) -> {

            // Make some useful operations on the migrationService from flyqay
        };
    }

}
