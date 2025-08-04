package br.com.carlosamorim.taskmanager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Task {

    @Id
    private String id;
    private User user;
    private String title;
    private String description;
    private boolean completed = Boolean.FALSE;
}
