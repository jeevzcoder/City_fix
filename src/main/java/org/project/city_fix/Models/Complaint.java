package org.project.city_fix.Models;

import jakarta.persistence.*;


import java.util.List;


@Entity

public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User user;
    private String Description;
    @Enumerated(EnumType.STRING)
    private ComplaintStatus status;
    @Enumerated(EnumType.STRING)
    private Department department;


    private Double latitude;
    private Double longitude;
    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public List<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @OneToMany
    private List<Authority>  authority;





    public Complaint(){}

   public Complaint(User user,String description, ComplaintStatus status, Double latitude, Double longitude, List<Authority> authority, Image image) {
    this.user=user;
    this.Description = description;
    this.status = status;
    this.latitude = latitude;
    this.longitude = longitude;
    this.authority = authority;
    this.image = image;
}
}
