package com.cord.pos.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class GlobalApiResponse {

    private String message;
    private Boolean status;
    private Object data;

}
