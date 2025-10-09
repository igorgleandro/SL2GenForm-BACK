package com.sl2genform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long user_id;
    private String name;
    private String email;
    private String surname;
    private String password;
    private String role;
    private String theme;
    private String avatar;
}
