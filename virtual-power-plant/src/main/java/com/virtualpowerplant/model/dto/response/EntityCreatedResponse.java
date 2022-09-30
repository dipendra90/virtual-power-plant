package com.virtualpowerplant.model.dto.response;

import com.virtualpowerplant.base.BaseResponse;
import org.springframework.http.HttpStatus;

public class EntityCreatedResponse extends BaseResponse {

    private String id;

    public EntityCreatedResponse() {

    }

    public EntityCreatedResponse(String message, HttpStatus status, String id) {
        super(message, status);
        this.id = id;
    }



    public EntityCreatedResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
