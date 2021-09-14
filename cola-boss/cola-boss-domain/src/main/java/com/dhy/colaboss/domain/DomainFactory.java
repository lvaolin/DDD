package com.dhy.colaboss.domain;

import com.dhy.colaboss.domain.user.UserProfile;

public class DomainFactory {

    public static UserProfile getUserProfile(){
        return new UserProfile();
    }

}
