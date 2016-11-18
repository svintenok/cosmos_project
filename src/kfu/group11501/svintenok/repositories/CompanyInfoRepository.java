package kfu.group11501.svintenok.repositories;

import kfu.group11501.svintenok.models.CompanyInfo;

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
