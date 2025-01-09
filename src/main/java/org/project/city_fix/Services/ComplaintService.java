package org.project.city_fix.Services;

import org.project.city_fix.DTOs.RegisterComplaintDto;
import org.project.city_fix.Models.*;
import org.project.city_fix.Repositories.AuthorityRepo;
import org.project.city_fix.Repositories.ComplaintRepo;
import org.project.city_fix.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.springframework.util.ImageUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class ComplaintService {
    ComplaintRepo complaintRepo;
    AuthorityRepo authorityRepo;
    UserRepo userRepo;


    @Autowired
    public ComplaintService(ComplaintRepo complaintRepo, AuthorityRepo authorityRepo,UserRepo userRepo) {
        this.complaintRepo = complaintRepo;
        this.authorityRepo = authorityRepo;
        this.userRepo = userRepo;
    }
    public String registerComplaint(RegisterComplaintDto dto) throws IOException {

        if(!userRepo.existsById(dto.getUserId())) return "User doesn't exist";
        User user=userRepo.findById(dto.getUserId()).get();
        List<Authority> authority=authorityRepo.findByDepartment(Department.valueOf(dto.getDepartment())).get();
        Complaint complaint=new Complaint(dto.getDescription(), ComplaintStatus.valueOf("initiated"), dto.getLatitude(), dto.getLongitude(),authority);
        complaintRepo.save(complaint);
        Long id=complaint.getId();
        return "Complaint registered successfully with Complaint number: "+id;
        //return "asdf";
    }

    public String checkStatus(Long id) throws Exception {
        Optional<Complaint> c=complaintRepo.findById(id);
        //if(c.isPresent()) return c.get().getStatus().toString();

        throw new Exception("Compliant doesn't exist");
    }
}
