package com.donorsClub.services;

import com.donorsClub.daos.UserDao;
import com.donorsClub.models.User;


/**
 * @since 3/19/2018
 * @author Mafrel
 *
 */
public class ProfileService {
  
  public boolean deActivateUser(long userId){
    UserDao uDao = new UserDao();
    User user = (User)uDao.findById(userId);
    
    if(user.getStatus()==1){
      user.setStatus((short)0);
      return uDao.update(user);
    }
      return false;
  }

}
