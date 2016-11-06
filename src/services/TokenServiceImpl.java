package services;

import models.Token;
import models.User;
import repository.TokenRepository;
import repository.TokenRepositoryImpl;
import repository.UserRepositoryImpl;

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
