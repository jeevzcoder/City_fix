package org.project.city_fix.Controllers;
import org.project.city_fix.DTOs.RegisterComplaintDto;
import org.project.city_fix.Services.ComplaintService;
import org.project.city_fix.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> registerComplaint(@RequestParam("image")MultipartFile multiPartImage, @RequestParam("userId") Long id,@RequestParam("department") String dept, @RequestParam("description") String desc,@RequestParam("latitude") Double lat,@RequestParam("longitude") Double lon) throws Exception{
        String op= complaintService.registerComplaint(new RegisterComplaintDto(id,dept,desc,lat,lon),multiPartImage);
        return ResponseEntity.status(HttpStatus.OK).body(op);

    }



    @GetMapping("/status/{id}")
    public ResponseEntity<?> fetchComplaintStatus(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(complaintService.checkStatus(id));
    }

    // get image of complaint
    @GetMapping("/image/{id}")
    public ResponseEntity<?> fetchComplaintImage(@PathVariable Long id) throws RuntimeException {
        byte[] imageData = complaintService.downloadImage(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(imageData);
    }

    // get concerned Authority names wr to complaint
    @GetMapping("/authority/{id}")
    public ResponseEntity<?> fetchConcernedAuthority(@PathVariable Long id) throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(complaintService.getConcernedAuthority(id));
    }

    public ResponseEntity<?> deleteComplaint(@PathVariable Long id) throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(complaintService.deleteComplaint(id));
    }






}
