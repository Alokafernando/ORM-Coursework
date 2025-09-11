package org.example.tdm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTM {
    private String userId;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String role;

    public UserTM(String userId, String name, String email, String phone, String username, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.role = role;
    }
}
