package com.aks.Service;

import com.aks.DAO.TokenDAO;
import com.aks.Entity.TokenDetail;
import com.aks.POJO.TokenPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TokenServiceImpl implements TokenService{

    @Autowired
    TokenDAO tokenDao;

    @Override
    public void saveToken(int user_id, String token) {
        TokenPojo tokenPojo=new TokenPojo(user_id, token);
        TokenDetail tokenDetail=new TokenDetail(tokenPojo.getUser_id(), tokenPojo.getToken());
        tokenDao.saveToken(tokenDetail);
    }

    @Override
    public String getToken(int user_id){
        return tokenDao.getToken(user_id);
    }
}
