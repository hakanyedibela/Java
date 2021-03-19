package learning.java.spring.boot.webclient.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Data
public class SimpleApiWebClient {

    private final WebClient webClient;

    private static final String getUrl = "/get";
    private static final String postUrl = "/post";
    private static final String putUrl = "/put";
    private static final String deleteUrl = "/delete";

    public Object simpleGetHttpWebClient() {
        return webClient
                .get()
                .uri(getUrl)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> {
                    log.error("Client Error Code {} ", clientResponse.statusCode());
                    return Mono.error(Exception::new);
                })
                .bodyToMono(Object.class)
                .block();
    }

    public Object simplePostHttpWebClient() {
        return webClient
                .post()
                .uri(postUrl)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> {
                    log.error("Client Error Code {} ", clientResponse.statusCode());
                    return Mono.error(Exception::new);
                })
                .bodyToMono(Object.class)
                .block();
    }

    public Object simplePutHttpWebClient() {
        return webClient
                .put()
                .uri(putUrl)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> {
                    log.error("Client Error Code {} ", clientResponse.statusCode());
                    return Mono.error(Exception::new);
                })
                .bodyToMono(Object.class)
                .block();
    }

    public Object simpleDeleteHttpWebClient() {
        return webClient
                .delete()
                .uri(deleteUrl)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> {
                    log.error("Client Error Code {} ", clientResponse.statusCode());
                    return Mono.error(Exception::new);
                })
                .bodyToMono(Object.class)
                .block();
    }

}
