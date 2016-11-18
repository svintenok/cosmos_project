package kfu.group11501.svintenok.services.impl;

import kfu.group11501.svintenok.models.CompanyInfo;
import kfu.group11501.svintenok.repositories.CompanyInfoRepository;
import kfu.group11501.svintenok.repositories.impl.CompanyInfoRepositoryImpl;
import kfu.group11501.svintenok.services.CompanyInfoService;

/**
 * Author: Svintenok Kate
 * Date: 13.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class CompanyInfoServiceImpl implements CompanyInfoService {
    CompanyInfoRepository companyInfoRepository = new CompanyInfoRepositoryImpl();

    @Override
    public void updateCompanyInfo(CompanyInfo companyInfo) {
        companyInfoRepository.updateCompanyInfo(companyInfo);
    }

    @Override
    public CompanyInfo getCompanyInfo() {
        return companyInfoRepository.getCompanyInfo();
    }
}
