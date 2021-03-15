package learning.java.spring.boot.flyway.repository;

import learning.java.spring.boot.flyway.entity.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<DeveloperEntity, Long> {

    List<DeveloperEntity> findDeveloperEntityByFirstName(String firstName);
}
