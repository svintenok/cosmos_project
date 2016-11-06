package repository;

import models.Token;
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
            PreparedStatement psmt = con.prepareStatement("insert into token(user_id, token) values(?,?)");
            psmt.setInt(1, token.getUser_id());
            psmt.setString(2, token.getToken());
            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeToken(int user_id) {
        try {
            PreparedStatement psmt = con.prepareStatement("delete from token where user_id=?");
            psmt.setInt(1, user_id);
            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Token getTokenByTokenString(String tokenString) {
        try {
            PreparedStatement psmt =  con.prepareStatement("select * from token where token=?");
            psmt.setString(1, tokenString);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                Token token = new Token(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("token")
                );
                return token;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
