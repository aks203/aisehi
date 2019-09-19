package com.aks.Service;


public interface TokenService {
    int saveToken(int user_id, String token);
    String getToken(int user_id);
}
