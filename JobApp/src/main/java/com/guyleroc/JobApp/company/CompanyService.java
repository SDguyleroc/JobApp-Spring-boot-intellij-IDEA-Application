package com.guyleroc.JobApp.company;

import java.util.List;

public interface CompanyService {

        List<Company> getAllCompanies();
        boolean updateCompany(Long id,Company updatedCompany );

        void creatCompany(Company company);
        boolean deleteCompany(Long id);
        Company getCompanyById(Long id);
}
