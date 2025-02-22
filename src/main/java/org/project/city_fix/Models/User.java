package org.project.city_fix.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String userName;


    @OneToMany
    private List<Complaint> complaintsByUser;
    public User(){}


    public User(Long id, String name, String email, String userName, List<Complaint> complaintsByUser) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.complaintsByUser = complaintsByUser;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Complaint> getComplaintsByUser() {
        return complaintsByUser;
    }

    public void setComplaintsByUser(List<Complaint> complaintsByUser) {
        this.complaintsByUser = complaintsByUser;
    }
}
