package org.project.city_fix.Controllers;

import org.project.city_fix.DTOs.RegisterComplaintDto;
import org.project.city_fix.Services.ComplaintService;
import org.project.city_fix.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    ComplaintService complaintService;
    ImageService imageService;


    @Autowired
    public ComplaintController(ComplaintService complaintService, ImageService iService) {
        this.complaintService=complaintService;
        this.imageService=iService;
    }


    @PostMapping(value = "/register")
    public String registerComplaint(@RequestParam("image")MultipartFile image, @RequestParam("userId") Long id,@RequestParam("department") String dept, @RequestParam("description") String desc,@RequestParam("latitude") Double lat,@RequestParam("longitude") Double lon) throws Exception{
        RegisterComplaintDto dto=new RegisterComplaintDto(id,dept,desc,lat,lon);
        String uploadImage = imageService.uploadImage(image);
        //return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
        return complaintService.registerComplaint(dto);
    }




    @GetMapping("/status/{id}")
    public String checkStatus(@PathVariable("id") Long id) throws Exception{
        return complaintService.checkStatus(id);
    }


}
