package repository;

import models.About;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface AboutRepository {
    void updateAbout(About about);

    About getAbout();
}
