package org.project.city_fix.Services;

import org.project.city_fix.DTOs.RegisterComplaintDto;
import org.project.city_fix.Exceptions.ComplaintDoesntExist;
import org.project.city_fix.Exceptions.EnterAllFeildsException;
import org.project.city_fix.Exceptions.UserNotFoundException;
import org.project.city_fix.Models.*;
import org.project.city_fix.Repositories.AuthorityRepo;
import org.project.city_fix.Repositories.ComplaintRepo;
import org.project.city_fix.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//import com.springframework.util.ImageUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ComplaintService {
    ComplaintRepo complaintRepo;
    AuthorityRepo authorityRepo;
    UserRepo userRepo;
    ImageService imageService;


    @Autowired
    public ComplaintService(ComplaintRepo complaintRepo, AuthorityRepo authorityRepo,UserRepo userRepo,ImageService imageService) {
        this.complaintRepo = complaintRepo;
        this.authorityRepo = authorityRepo;
        this.userRepo = userRepo;
        this.imageService=imageService;
    }
    public String registerComplaint(RegisterComplaintDto dto, MultipartFile multiPartImage) throws RuntimeException, IOException {
        if (dto.getUserId() == null || dto.getDepartment() == null || dto.getDescription() == null || dto.getLatitude() == null || dto.getLongitude() == null) {
            throw new EnterAllFeildsException("Kindly enter all the fields.");
        }
        if(userRepo.findById(dto.getUserId()).isEmpty()) {
            throw new UserNotFoundException("Kindly register as user first");
        }
        User user=userRepo.findById(dto.getUserId()).get();

        //Assuming Dept would be provided with drop down
        List<Authority> authority=authorityRepo.findByDepartment(Department.valueOf(dto.getDepartment())).get();
        var image= new Image(multiPartImage.getOriginalFilename(), multiPartImage.getContentType(), ImageUtils.compressImage(multiPartImage.getBytes()));
        Complaint complaint=new Complaint(user,dto.getDescription(), ComplaintStatus.valueOf("initiated"), dto.getLatitude(), dto.getLongitude(),authority,imageService.uploadImage(multiPartImage));
        Complaint comp=complaintRepo.save(complaint);
        long id=comp.getId()+1000;

        return "Complaint registered successfully with Complaint number: "+id;

    }

    public String checkStatus(Long id) throws Exception {
        Optional<Complaint> c=complaintRepo.findById(id-1000L);
        if(c.isPresent() && c.get().getStatus()!=ComplaintStatus.deleted){
            return c.get().getStatus().toString();
        }

        throw new Exception("Compliant doesn't exist");
    }

    public byte[] downloadImage(Long id) {
        Optional<Complaint> c=complaintRepo.findById(id-1000L);
        if(c.isEmpty())throw new ComplaintDoesntExist("The complain with the given id doesn't exist, pls check!!!");

        return imageService.downloadImage(c.get().getImage().getName());

    }

    public Object getConcernedAuthority(Long id)throws RuntimeException {
        Optional<Complaint> c=complaintRepo.findById(id-1000L);
        if(c.isEmpty())throw new ComplaintDoesntExist("The complain with the given id doesn't exist, pls check!!!");
        if(authorityRepo.findByDepartment(c.get().getDepartment()).isEmpty()) throw new RuntimeException("Authority not update");
        List<String> authorities=new ArrayList<>();
        for(Authority a:authorityRepo.findByDepartment(c.get().getDepartment()).get()){
            authorities.add(a.getName());
        }
                return authorities;

    }

    public Object deleteComplaint(Long id) throws RuntimeException{
        Optional<Complaint> c=complaintRepo.findById(id-1000L);
        if(c.isPresent() && c.get().getStatus()!=ComplaintStatus.deleted){
            c.get().setStatus(ComplaintStatus.deleted);
            complaintRepo.save(c.get());
            return "Complaint deleted successfully";
        }

        throw new Exception("Compliant doesn't exist");
    }
}
