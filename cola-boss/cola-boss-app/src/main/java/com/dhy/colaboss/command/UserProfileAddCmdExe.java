package com.dhy.colaboss.command;

import com.alibaba.cola.dto.Response;
import com.dhy.colaboss.convertor.UserProfileConvertor;
import com.dhy.colaboss.domain.user.UserProfile;
import com.dhy.colaboss.dto.UserProfileAddCmd;
import com.dhy.colaboss.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserProfileAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:25 PM
 */
@Component
public class UserProfileAddCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileAddCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.create(userProfile);
        return Response.buildSuccess();
    }
}
