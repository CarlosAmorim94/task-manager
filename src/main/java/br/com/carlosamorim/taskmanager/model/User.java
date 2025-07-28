package br.com.carlosamorim.taskmanager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;

}
