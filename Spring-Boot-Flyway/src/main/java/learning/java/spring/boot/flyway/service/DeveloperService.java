package learning.java.spring.boot.flyway.service;

import learning.java.spring.boot.flyway.dto.DeveloperDTO;
import learning.java.spring.boot.flyway.entity.DeveloperEntity;
import learning.java.spring.boot.flyway.repository.DeveloperRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
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

    public DeveloperEntity createNewDeveloper(final DeveloperDTO developerDTO) {

        // All necessary field checks are made in DeveloperDTO
        DeveloperEntity entity = new DeveloperEntity();
        entity.setFirstName(developerDTO.getFirstName());
        entity.setLastName(developerDTO.getLastName());
        entity.setAge(developerDTO.getAge());
        entity.setPosition(developerDTO.getPosition());
        entity.setSalary(developerDTO.getSalary());
        entity.setIsInHomeOffice(developerDTO.getIsInHomeOffice());

        return developerRepository.save(entity);
    }

    public DeveloperEntity updateExistingDeveloper(final DeveloperDTO developerDTO) {

        var developerToUpdate = developerRepository.findById(developerDTO.getDeveloperId());

        developerToUpdate.ifPresentOrElse(
                developerEntity -> {

                    developerEntity.setFirstName(developerDTO.getFirstName());
                    developerEntity.setLastName(developerDTO.getLastName());
                    developerEntity.setAge(developerDTO.getAge());
                    developerEntity.setPosition(developerDTO.getPosition());
                    developerEntity.setSalary(developerDTO.getSalary());
                    developerEntity.setIsInHomeOffice(developerDTO.getIsInHomeOffice());

                    developerRepository.save(developerEntity);
                },
                () -> {
                    log.info("Can't update developer, because is not existing!");
                }
        );
        return developerToUpdate.get();
    }

    public Optional<DeveloperEntity> findDeveloperById(final Long developerId) {
        try {

            return developerRepository.findById(developerId);

        } catch (JpaSystemException jpaSystemException) {
            log.error("Can't find Developer with ID: " + developerId, jpaSystemException);
        }
        return Optional.empty();
    }


    public Optional<DeveloperEntity> deleteDeveloperById(final Long developerId) {
        try {

            var developerToDelete = developerRepository.findById(developerId);

            developerToDelete.ifPresentOrElse(
                    developerRepository::delete,
                    () -> log.error("Something went wrong during the delete operation!")
            );

            return developerToDelete;

        } catch (JpaSystemException jpaSystemException) {
            log.error("Can't delete developer with Id: " + developerId, jpaSystemException);
        }
        return Optional.empty();
    }
}
