package com.mehmethalman.shipmentservice.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new ErrorDecoder.Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 404) {
            return new ResourceNotFoundException("karşı serviste istenen kaynak bulunamadı (Feign 404).");
        }

        if (response.status() == 400) {
            return new RuntimeException("Karşı servise hatalı istek gönderildi (Feign 400).");
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}