package repository;


import models.Token;

/**
 * Author: Svintenok Kate
 * Date: 04.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface TokenRepository {
    void addToken(Token token);
    void removeToken(int user_id);

    Token getTokenByToken(String token);
}
