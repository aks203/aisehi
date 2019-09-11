package com.aks.Service;

import com.aks.POJO.TokenPojo;

public interface TokenService {
    void saveToken(int user_id, String token);
    String getToken(int user_id);
}
