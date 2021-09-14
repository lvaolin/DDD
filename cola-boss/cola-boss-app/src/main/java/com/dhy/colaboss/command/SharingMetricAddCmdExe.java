package com.dhy.colaboss.command;

import com.alibaba.cola.dto.Response;
import com.dhy.colaboss.domain.metrics.techinfluence.InfluenceMetric;
import com.dhy.colaboss.domain.metrics.techinfluence.SharingMetric;
import com.dhy.colaboss.domain.metrics.techinfluence.SharingMetricItem;
import com.dhy.colaboss.domain.metrics.techinfluence.SharingScope;
import com.dhy.colaboss.domain.user.UserProfile;
import com.dhy.colaboss.dto.SharingMetricAddCmd;
import com.dhy.colaboss.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * SharingMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-02 5:00 PM
 */
@Component
public class SharingMetricAddCmdExe{

    @Resource
    private MetricGateway metricGateway;

    public Response execute(SharingMetricAddCmd cmd) {
        SharingMetricItem sharingMetricItem = new SharingMetricItem();
        BeanUtils.copyProperties(cmd.getSharingMetricCO(), sharingMetricItem);
        sharingMetricItem.setSubMetric(new SharingMetric(new InfluenceMetric(new UserProfile(cmd.getSharingMetricCO().getOwnerId()))));
        sharingMetricItem.setSharingScope(SharingScope.valueOf(cmd.getSharingMetricCO().getSharingScope()));
        metricGateway.save(sharingMetricItem);
        return Response.buildSuccess();
    }
}
