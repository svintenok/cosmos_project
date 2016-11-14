package repository;

import models.CompanyInfo;
import singletons.DBSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class CompanyInfoRepositoryImpl implements CompanyInfoRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void updateCompanyInfo(CompanyInfo companyInfo) {

    }

    @Override
    public CompanyInfo getCompanyInfo() {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from company_info");
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                CompanyInfo companyInfo = new CompanyInfo(
                        rs.getString("text"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("email"));
                return companyInfo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
