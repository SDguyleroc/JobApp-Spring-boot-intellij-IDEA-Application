package com.guyleroc.JobApp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>>  getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany){

        boolean updated = companyService.updateCompany(id, updatedCompany);
        if(updated){
            return new ResponseEntity<>("Job updated Successsfully", HttpStatus.OK);
        } else {
        return new ResponseEntity<>("Job not found unable to update", HttpStatus.NOT_FOUND);}
    }

    @PostMapping
    public ResponseEntity<String> creatCompany(@RequestBody Company company){
        companyService.creatCompany(company);

        return new ResponseEntity<>("Company created Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean deleted = companyService.deleteCompany(id);
        if (deleted){
            return new ResponseEntity<>("Company deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);}
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if (company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);

        }else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
}

