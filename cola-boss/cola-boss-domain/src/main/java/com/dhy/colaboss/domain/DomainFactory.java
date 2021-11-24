package com.dhy.colaboss.domain;

import com.dhy.colaboss.domain.user.UserProfile;

/**
 * 获取领域实体的入口
 */
public class DomainFactory {

    public static UserProfile getUserProfile(){
        return new UserProfile();
    }

}
