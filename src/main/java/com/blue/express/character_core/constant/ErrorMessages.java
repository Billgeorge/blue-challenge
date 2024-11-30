package com.blue.express.character_core.constant;

public enum ErrorMessages {
    INVALID_ORDERBY_PARAM("Invalid orderby param, allow values: LIKE,DISLIKE"),
    INTERNAL_SERVER_ERROR("Error processing your request");
    private final String message;

    public String getMessage() {
        return message;
    }
    ErrorMessages(String message){
        this.message = message;
    }
}
