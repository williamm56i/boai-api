package org.boai.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

public class HttpUtils {

    /**
     * HTTP GET
     *
     * @param url URL
     * @return json string
     */
    public static String get(String url) {
        return get(url, null);
    }

    /**
     * HTTP GET with custom header
     *
     * @param url       URL
     * @param headerMap custom header
     * @return json string
     */
    public static String get(String url, Map<String, String> headerMap) {
        WebClient webClient = WebClient.create();
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headerMap != null) {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            for (String key: headerMap.keySet()) {
                httpHeaders.set(key, headerMap.get(key));
            }
        }
        return webClient.get().uri(url).headers(headers -> headers.addAll(httpHeaders)).retrieve().bodyToMono(String.class).block();
    }

    /**
     * HTTP POST
     *
     * @param url  URL
     * @param body request boy
     * @return json string
     * @throws JacksonException e
     */
    public static String post(String url, Object body) throws JacksonException {
        return post(url, body, null);
    }

    /**
     * HTTP POST with custom header
     *
     * @param url       URL
     * @param body      request boy
     * @param headerMap custom header
     * @return json string
     * @throws JacksonException e
     */
    public static String post(String url, Object body, Map<String, String> headerMap) throws JacksonException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(body);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        if (headerMap != null) {
            for (String key: headerMap.keySet()) {
                httpHeaders.set(key, headerMap.get(key));
            }
        }

        WebClient webClient = WebClient.create();
        return webClient.post().uri(url).headers(headers -> headers.addAll(httpHeaders)).bodyValue(jsonString).retrieve().bodyToMono(String.class).block();
    }
}
