package com.dhy.colaboss.command.query;

import com.alibaba.cola.dto.SingleResponse;
import com.dhy.colaboss.dto.UserProfileGetQry;
import com.dhy.colaboss.dto.clientobject.UserProfileCO;
import com.dhy.colaboss.gatewayimpl.database.UserProfileMapper;
import com.dhy.colaboss.gatewayimpl.database.dataobject.UserProfileDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileGetQryExe {

    @Resource
    private UserProfileMapper userProfileMapper;

    public SingleResponse<UserProfileCO> execute(UserProfileGetQry qry) {
        UserProfileDO userProfileDO = userProfileMapper.getByUserId(qry.getUserId());
        UserProfileCO userProfileCO = new UserProfileCO();
        BeanUtils.copyProperties(userProfileDO, userProfileCO);
        return SingleResponse.of(userProfileCO);
    }

}
