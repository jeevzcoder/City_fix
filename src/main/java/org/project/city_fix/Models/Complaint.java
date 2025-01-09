package org.project.city_fix.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //private String Name;
    @OneToOne
    private User user;
    private String Description;
    @Enumerated(EnumType.STRING)
    private ComplaintStatus status;
    private Double latitude;
    private Double longitude;
    //@Lob
    //@Type(type = "org.hibernate.type.ImageType")

    //private Image image;

    @OneToMany
    private List<Authority>  authority;

    public Complaint() {
    }


    public Complaint(String description, ComplaintStatus status, Double latitude, Double longitude,  List<Authority> authority) {
        //Name = name;
        Description = description;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
        //this.image = image;
        this.authority = authority;
    }
}
