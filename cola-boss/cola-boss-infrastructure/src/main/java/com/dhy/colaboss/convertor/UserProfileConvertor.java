package com.dhy.colaboss.convertor;

import com.dhy.colaboss.domain.user.Role;
import com.dhy.colaboss.domain.user.UserProfile;
import com.dhy.colaboss.dto.clientobject.UserProfileCO;
import com.dhy.colaboss.gatewayimpl.database.dataobject.UserProfileDO;
import org.springframework.beans.BeanUtils;

public class UserProfileConvertor{

    public static UserProfile toEntity(UserProfileCO userProfileCO){
        UserProfile userProfile = new UserProfile();
        BeanUtils.copyProperties(userProfileCO, userProfile);
        userProfile.setRole(Role.valueOf(userProfileCO.getRole()));
        return userProfile;
    }

    public static UserProfileDO toDataObject(UserProfile userProfile){
        UserProfileDO userProfileDO = new UserProfileDO();
        BeanUtils.copyProperties(userProfile, userProfileDO);
        userProfileDO.setRole(userProfile.getRole().name());
        return userProfileDO;
    }

    public static UserProfileDO toDataObjectForCreate(UserProfile userProfile){
        UserProfileDO userProfileDO = toDataObject(userProfile);
        return userProfileDO;
    }

    public static UserProfileDO  toDataObjectForUpdate(UserProfile userProfile){
        UserProfileDO userProfileDO = toDataObject(userProfile);
        return userProfileDO;
    }
}
