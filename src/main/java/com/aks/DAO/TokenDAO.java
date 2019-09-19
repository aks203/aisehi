package com.aks.DAO;

import com.aks.Entity.TokenDetail;

public interface TokenDAO {

    int saveToken(TokenDetail tokenDetail);

    String getToken(int user_id);
}
