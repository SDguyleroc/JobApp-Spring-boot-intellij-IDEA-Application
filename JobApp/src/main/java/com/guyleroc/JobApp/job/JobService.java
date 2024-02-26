package com.guyleroc.JobApp.job;



import java.util.List;

public interface JobService {

    // here we define methods

    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
