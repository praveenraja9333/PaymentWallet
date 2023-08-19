package com.vrp.system.paymentsystem.paymentwallet.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
class MainwalletApiTest {


    @Test
    void postOrder() throws IOException, InterruptedException {
        RestTemplate restTemplate=new RestTemplate();
        RequestEntity<String> request=new RequestEntity<>("", HttpMethod.GET, URI.create("http://localhost:8080/api/v1/postOrder"));
        ResponseEntity<Integer> responseEntity =restTemplate.exchange(request, Integer.class);
        assertEquals(0,responseEntity.getBody());
        HttpRequest request1=HttpRequest.newBuilder(URI.create("http://localhost:8080/api/v1/postOrder")).method("GET",HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response= HttpClient.newHttpClient().send(request1,HttpResponse.BodyHandlers.ofString());
        assertEquals(0,response.body());
    }

    @Test
    void deleteRestricted() {
    }

    @Test
    void putRestricted() {
    }

    @Test
    void getRestricted() {
    }

    @Test
    void getBalancesPerPage() {
    }
}