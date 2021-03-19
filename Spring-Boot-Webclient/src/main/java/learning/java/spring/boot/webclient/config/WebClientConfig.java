package learning.java.spring.boot.webclient.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import learning.java.spring.boot.webclient.service.SimpleApiWebClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class WebClientConfig {

    @Value("${spring.webclient.url}")
    private String baseUrl;

    @Bean
    public SimpleApiWebClient simpleApiWebClient() {
        return new SimpleApiWebClient(webClient());
    }

    private WebClient webClient() {

        var httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(connection -> {
                   connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                   .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
                });


        return WebClient.builder()
                .baseUrl(baseUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .filters(exchangeFilterFunctions -> {
                    exchangeFilterFunctions.add(logRequest());
                    exchangeFilterFunctions.add(logResponse());
                })
                .build();

    }

    private static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("API Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers().forEach((name, values)
                    -> values.forEach(value
                    -> log.debug("HEADER_KEY_{}=HEADER_VALUE_{}", name, value)));
            log.info("API Body Request {}", clientRequest.body());
            return Mono.just(clientRequest);
        });
    }

    private static ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            log.info("API Status Code: {}", clientResponse.statusCode().value());
            log.info("API Response Reason: {}", clientResponse.statusCode().getReasonPhrase());
            return Mono.just(clientResponse);
        });
    }

}
