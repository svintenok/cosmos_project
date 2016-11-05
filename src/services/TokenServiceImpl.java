package services;

import models.Token;
import repository.TokenRepository;
import repository.TokenRepositoryImpl;

/**
 * Author: Svintenok Kate
 * Date: 04.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class TokenServiceImpl implements TokenService {
    private TokenRepository tokenRepository = new TokenRepositoryImpl();


    @Override
    public void addToken(Token token) {
        tokenRepository.addToken(token);
    }
}
