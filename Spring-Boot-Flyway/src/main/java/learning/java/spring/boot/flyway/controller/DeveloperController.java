package learning.java.spring.boot.flyway.controller;

import learning.java.spring.boot.flyway.dto.DeveloperDTO;
import learning.java.spring.boot.flyway.service.DeveloperService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @GetMapping(path = "/developers/{firstName}")
    public ResponseEntity<?> getDeveloperByPosition(@PathVariable final String firstName) {

        var result = developerService.getDevelopersByPosition(firstName);

        if (result != null && !result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("No Developers find with Firstname " + firstName);
    }

    @GetMapping(path = "/developer/{id}")
    public ResponseEntity<?> getDeveloperByDeveloperId(@PathVariable final Long id) {

        var result = developerService.findDeveloperById(id);

        if(result.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(result.get());
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("No Developer with the developer-id " + id + " exists!");

    }

    @PostMapping(path = "/add/developer",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewDeveloperToDb(@RequestBody final DeveloperDTO developerDTO) {

        var result = developerService.createNewDeveloper(developerDTO);

        if (result != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }


    @PutMapping(path = "/update/developer",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateDeveloperByDto(@RequestBody final DeveloperDTO developerDTO) {

        var result = developerService.updateExistingDeveloper(developerDTO);

        if (result != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }


    @DeleteMapping(path = "/delete/developer/{id}")
    public ResponseEntity<?> deleteDeveloperById(@PathVariable final Long id) {

        var result = developerService.deleteDeveloperById(id);

        if (result.isPresent()) {
            // Create your own body result like you want to inform the client about the deletion.
            // All these are just are very simple examples.
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

}
