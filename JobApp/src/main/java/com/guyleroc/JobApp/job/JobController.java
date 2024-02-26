package com.guyleroc.JobApp.job;

import com.guyleroc.JobApp.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {


   private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){


        Job job = jobService.getJobById(id);
        if(job != null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
       return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
//creat method
   @PostMapping("/jobs")
    public ResponseEntity<String> creatJob(@RequestBody Job job){
        jobService.createJob(job);

       Company c = job.getCompany();
        return new ResponseEntity<>("Job Added successfully", HttpStatus.CREATED);
   }
//delete method
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);

        if(deleted)
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);

        return new ResponseEntity<>("job not found", HttpStatus.NOT_FOUND);
    }
//
      @PutMapping("/jobs/{id}")
      public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated){
            return new ResponseEntity<>("Job updated Successsfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job not found unable to update", HttpStatus.NOT_FOUND);
      }
//
//    @GetMapping("/jobs/{id}/company")
}
