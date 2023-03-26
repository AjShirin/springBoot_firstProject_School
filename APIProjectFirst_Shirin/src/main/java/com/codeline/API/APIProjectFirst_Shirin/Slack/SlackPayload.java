package com.codeline.API.APIProjectFirst_Shirin.Slack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class SlackPayload {

    private String text;

   // constructor (the function name is the same as the class name)
    public SlackPayload(String text) {
        this.text = text;
    }
}