package repository;

import models.About;
import singletons.DBSingleton;

import java.sql.Connection;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class AboutRepositoryImpl implements AboutRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void updateAbout(About about) {

    }

    @Override
    public About getAbout() {
        return null;
    }
}
