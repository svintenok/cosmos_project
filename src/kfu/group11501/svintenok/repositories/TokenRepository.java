package kfu.group11501.svintenok.repositories;


import kfu.group11501.svintenok.models.Token;

/**
 * Author: Svintenok Kate
 * Date: 04.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface TokenRepository {
    void addToken(Token token);
    void removeToken(int userId);

    Token getTokenByTokenString(String token);
}
