package kfu.group11501.svintenok.services.impl;

import kfu.group11501.svintenok.models.Token;
import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.repositories.TokenRepository;
import kfu.group11501.svintenok.repositories.impl.TokenRepositoryImpl;
import kfu.group11501.svintenok.repositories.impl.UserRepositoryImpl;
import kfu.group11501.svintenok.services.TokenService;

/**
 * Author: Svintenok Kate
 * Date: 04.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class TokenServiceImpl implements TokenService {
    private TokenRepository tokenRepository = new TokenRepositoryImpl();


    @Override
    public void removeToken(String user_login) {
        User user = new UserRepositoryImpl().getUserByLogin(user_login);
        tokenRepository.removeToken(user.getId());
    }

    @Override
    public void addToken(Token token) {
        tokenRepository.addToken(token);
    }

    @Override
    public Token getToken(String tokenSting) {
        return tokenRepository.getTokenByTokenString(tokenSting);
    }


}
