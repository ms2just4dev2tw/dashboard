package com.ex.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty(value = "user-name", index = 1)
    private String name;

    @JsonProperty(value = "user-pwd", index = 2)
    private String password;

    @JsonProperty(value = "auth-token", index = 3)
    private String authToken;

}
