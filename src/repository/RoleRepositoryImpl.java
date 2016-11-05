package repository;

import models.Role;
import singletons.DBSingleton;

import java.sql.Connection;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class RoleRepositoryImpl implements RoleRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public Role getRoleById(int id) {
        return null;
    }
}
