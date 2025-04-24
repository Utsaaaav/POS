package com.cord.pos.controller;

import com.cord.pos.dto.GlobalApiResponse;
import org.springframework.stereotype.Component;

@Component
public class BaseController {

    public GlobalApiResponse successResponse(String message, Object data){

        return GlobalApiResponse.builder()
                .message(message)
                .data(data)
                .status(true)
                .build();
    }

    public GlobalApiResponse failureResponse(String message, Object data){

        return GlobalApiResponse.builder()
                .message(message)
                .data(data)
                .status(false)
                .build();

    }

}
