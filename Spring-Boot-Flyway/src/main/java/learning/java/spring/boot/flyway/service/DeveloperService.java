package learning.java.spring.boot.flyway.service;

import learning.java.spring.boot.flyway.dto.DeveloperDTO;
import learning.java.spring.boot.flyway.entity.DeveloperEntity;
import learning.java.spring.boot.flyway.repository.DeveloperRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class DeveloperService {

    // With the flyway.migrate() function, you can migrate the sql scripts manually.
    // For this have to be FlywayMigrationStrategy uncommented in the FlywayConfig class.
    // private final Flyway flyway;

    private final DeveloperRepository developerRepository;

    public List<DeveloperEntity> getDevelopersByPosition(final String firstName) {
        try {
            var result = developerRepository
                    .findDeveloperEntityByFirstName(firstName);

            if (result != null && !result.isEmpty()) {
                return result;
            }
        } catch (JpaSystemException jpaSystemException) {
            log.error("SQL Exception occurred", jpaSystemException);
        }
        return Collections.emptyList();
    }


    public List<DeveloperEntity> getAllDevelopers() {
        try {
            var result = developerRepository.findAll();

            if (!result.isEmpty()) {
                return result;
            }
        } catch (JpaSystemException jpaSystemException) {
            log.error("SQL Exception occurred", jpaSystemException);
        }
        return Collections.emptyList();
    }

    public void createNewDeveloper(final DeveloperDTO developerDTO) {

        // All necessary field checks are made in DeveloperDTO
        DeveloperEntity entity = new DeveloperEntity();
        entity.setFirstName(developerDTO.getFirstName());
        entity.setLastName(developerDTO.getLastName());
        entity.setAge(developerDTO.getAge());
        entity.setPosition(developerDTO.getPosition());
        entity.setSalary(developerDTO.getSalary());
        entity.setIsInHomeOffice(developerDTO.getIsInHomeOffice());

        developerRepository.save(entity);
    }

}
