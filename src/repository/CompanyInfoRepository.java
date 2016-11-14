package repository;

import models.CompanyInfo;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface CompanyInfoRepository {
    void updateCompanyInfo(CompanyInfo companyInfo);

    CompanyInfo getCompanyInfo();
}
