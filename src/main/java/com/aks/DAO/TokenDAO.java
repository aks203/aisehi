package com.aks.DAO;

import com.aks.Entity.TokenDetail;
import com.aks.POJO.TokenPojo;

public interface TokenDAO {

    void saveToken(TokenDetail tokenDetail);

    String getToken(int user_id);
}
