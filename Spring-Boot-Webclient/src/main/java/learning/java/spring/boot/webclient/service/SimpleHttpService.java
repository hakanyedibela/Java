package learning.java.spring.boot.webclient.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleHttpService {

    private final SimpleApiWebClient simpleApiWebClient;

    public Object webClientGetCallerFunction() {
        return simpleApiWebClient.simpleGetHttpWebClient();
    }

    public Object webClientPostCallerFunction() {
        return simpleApiWebClient.simplePostHttpWebClient();
    }

    public Object webClientPutCallerFunction() {
        return simpleApiWebClient.simplePutHttpWebClient();
    }

    public Object webClientDeleteCallerFunction() {
        return simpleApiWebClient.simpleDeleteHttpWebClient();
    }
}
