package learning.java.spring.boot.flyway.controller;

import learning.java.spring.boot.flyway.dto.DeveloperDTO;
import learning.java.spring.boot.flyway.service.DeveloperService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping(path = "/developers")
    public ResponseEntity<?> showAllDevelopers() {

        var result = developerService.getAllDevelopers();

        if (result != null && !result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Developers exists!");
    }

    @GetMapping(path = "/developer/{firstName}")
    public ResponseEntity<?> getDeveloperByPosition(@PathVariable final String firstName) {

        var result = developerService.getDevelopersByPosition(firstName);

        if (result != null && !result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("No Developers for the position " + firstName + " exists!");
    }

    @PostMapping(path = "/add/developer",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewDeveloperToDb(@RequestBody final DeveloperDTO developerDTO) {

        developerService.createNewDeveloper(developerDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
