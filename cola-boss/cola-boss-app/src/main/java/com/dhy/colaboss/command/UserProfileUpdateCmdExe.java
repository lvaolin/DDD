package com.dhy.colaboss.command;

import com.alibaba.cola.dto.Response;
import com.dhy.colaboss.convertor.UserProfileConvertor;
import com.dhy.colaboss.domain.user.UserProfile;
import com.dhy.colaboss.dto.UserProfileUpdateCmd;
import com.dhy.colaboss.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileUpdateCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}