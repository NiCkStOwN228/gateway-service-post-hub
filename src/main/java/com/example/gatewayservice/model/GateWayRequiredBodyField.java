package com.example.gatewayservice.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class GateWayRequiredBodyField implements Serializable {
    private Integer userId;
}

