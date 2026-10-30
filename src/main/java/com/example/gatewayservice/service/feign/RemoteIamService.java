package com.example.gatewayservice.service.feign;

import com.example.gatewayservice.model.GateWayRequest;
import com.example.gatewayservice.model.GateWayResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "central-http-client",
        url = "${internal.access.service.hostname}"
)
public interface RemoteIamService {

    @PostMapping(
            value = "/access/microservice",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    GateWayResponse<String> requestAccess(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String jwt,
            @RequestBody GateWayRequest<String> request
    );

}

