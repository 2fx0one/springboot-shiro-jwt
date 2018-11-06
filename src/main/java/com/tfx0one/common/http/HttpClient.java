package com.tfx0one.common.http;


import io.swagger.models.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClient {
    public String client(String url, HttpMethod method, MultiValueMap<String, String> params) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response1 = template.getForEntity(url, String.class);
        return response1.getBody();
    }
}
