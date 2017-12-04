package org.somrainc.com.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class AuthDTO {

    private String username;
    public String password;

}
