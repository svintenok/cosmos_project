package repository;

import models.Token;
import models.User;
import singletons.DBSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Svintenok Kate
 * Date: 04.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class TokenRepositoryImpl implements TokenRepository {

    private Connection con = DBSingleton.getConnection();

    @Override
    public void addToken(Token token) {
        try {
            PreparedStatement psmt = con.prepareStatement("insert into tokens(user_id, token) values(?,?)");
            psmt.setInt(1, token.getUser_id());
            psmt.setString(2, token.getToken());
            psmt.executeUpdate();

        } catch (SQLException e) {}
    }

    @Override
    public void removeToken(int id) {

    }

    @Override
    public Token getTokenByToken(String token) {
        return null;
    }
}
