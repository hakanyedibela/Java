package learning.java.spring.boot.webclient.controller;

import learning.java.spring.boot.webclient.service.SimpleHttpService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Data
public class SimpleHttpController {

    private final SimpleHttpService simpleHttpService;

    @GetMapping(path = "/simple/get")
    public ResponseEntity<?> getSimpleGet() {
        var get = simpleHttpService.webClientGetCallerFunction();
        return ResponseEntity.status(HttpStatus.OK).body(get);
    }

    @GetMapping(path = "/simple/post")
    public ResponseEntity<?> getSimplePost() {
        var post = simpleHttpService.webClientPostCallerFunction();
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @GetMapping(path = "/simple/put")
    public ResponseEntity<?> getSimplePut() {
        var put = simpleHttpService.webClientPutCallerFunction();
        return ResponseEntity.status(HttpStatus.OK).body(put);
    }

    @GetMapping(path = "/simple/delete")
    public ResponseEntity<?> getSimpleDelete() {
        var delete = simpleHttpService.webClientDeleteCallerFunction();
        return ResponseEntity.status(HttpStatus.OK).body(delete);
    }
}
