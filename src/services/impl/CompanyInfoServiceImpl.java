package services.impl;

import models.CompanyInfo;
import repository.CompanyInfoRepository;
import repository.impl.CompanyInfoRepositoryImpl;
import services.CompanyInfoService;

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
