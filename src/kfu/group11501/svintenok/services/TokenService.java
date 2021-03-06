package kfu.group11501.svintenok.services;

import kfu.group11501.svintenok.models.Token;

/**
 * Author: Svintenok Kate
 * Date: 04.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface TokenService {

    void removeToken(String user_login);
    void addToken(Token token);
    Token getToken(String tokenSting);
}
