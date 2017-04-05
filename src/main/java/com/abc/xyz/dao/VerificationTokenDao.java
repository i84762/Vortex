package com.abc.xyz.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.abc.xyz.common.CoreDao;
import com.abc.xyz.model.User;
import com.abc.xyz.model.VerificationToken;

/**
 * 
 * @author amrit
 * 
 */
public interface VerificationTokenDao extends CoreDao<VerificationToken>
{
    VerificationToken findByToken(String token);
    VerificationToken findByUser(User user);
    List<VerificationToken> findAllByExpiryDateLessThan(Date now);
    
    void deleteByExpiryDateLessThan(Date now);

    @Modifying
    @Query("delete from VerificationToken t where t.expiryDate <= ?1")
    void deleteAllExpiredSince(Date now);
}