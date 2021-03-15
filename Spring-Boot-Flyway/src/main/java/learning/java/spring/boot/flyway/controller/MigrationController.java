package learning.java.spring.boot.flyway.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class MigrationController {

    private final Flyway flyway;

    @PostMapping(path = "/sql/migration")
    public ResponseEntity<?> migrateSqlScripts() {

        var migrationResult = flyway.migrate();

        migrationResult.migrations
                .forEach(migs -> {
                    log.info("Version: " + migs.version);
                    log.info("Description: " + migs.description);
                });

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
