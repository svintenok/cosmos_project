package services;

import models.CompanyInfo;
import repository.CompanyInfoRepository;
import repository.CompanyInfoRepositoryImpl;

/**
 * Author: Svintenok Kate
 * Date: 13.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class CompanyInfoServiceImpl implements CompanyInfoService {
    CompanyInfoRepository companyInfoRepository = new CompanyInfoRepositoryImpl();

    @Override
    public CompanyInfo getCompanyInfo() {
        return companyInfoRepository.getCompanyInfo();
    }
}
