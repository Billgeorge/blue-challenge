package com.blue.express.character_core.constant;

public enum FameAction {

    LIKE("like"),DISLIKE("dislike");

    private String action;

    FameAction(String action){
        this.action = action;
    }

    public String getAction(){
        return this.action;
    }
}
