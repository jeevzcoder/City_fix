package org.project.city_fix.DTOs;

import lombok.Getter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

//@Getter
public class RegisterComplaintDto {

    //@NotBlank(message = "Description cannot be blank")
    private String description;

    //@NotNull(message= "Geo Tagging cannot be blank")
    private Double latitude;

    //@NotNull(message= "Geo Tagging cannot be blank")
    private Double longitude;

    //@NotNull(message = "User Id cannot be null")
    private Long userId;

    //@NotBlank(message = "Department cannot be blank")
    private String department;

    public RegisterComplaintDto( Long userId,String department,String description, Double latitude, Double longitude) {
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.userId = userId;
        this.department = department;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Long getUserId() {
        return userId;
    }


    public String getDepartment() {
        return department;
    }




    public String getDescription() {
        return description;
    }
}