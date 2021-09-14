package com.dhy.colaboss.command;

import com.alibaba.cola.dto.Response;
import com.dhy.colaboss.domain.metrics.techinfluence.AuthorType;
import com.dhy.colaboss.domain.metrics.techinfluence.InfluenceMetric;
import com.dhy.colaboss.domain.metrics.techinfluence.PatentMetric;
import com.dhy.colaboss.domain.metrics.techinfluence.PatentMetricItem;
import com.dhy.colaboss.domain.user.UserProfile;
import com.dhy.colaboss.dto.PatentMetricAddCmd;
import com.dhy.colaboss.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * PatentMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:41 AM
 */
@Component
public class PatentMetricAddCmdExe{

    @Resource
    private MetricGateway metricGateway;

    public Response execute(PatentMetricAddCmd cmd) {
        PatentMetricItem patentMetricItem = new PatentMetricItem();
        BeanUtils.copyProperties(cmd.getPatentMetricCO(), patentMetricItem);
        patentMetricItem.setSubMetric(new PatentMetric(new InfluenceMetric(new UserProfile(cmd.getPatentMetricCO().getOwnerId()))));
        patentMetricItem.setAuthorType(AuthorType.valueOf(cmd.getPatentMetricCO().getAuthorType()));
        metricGateway.save(patentMetricItem);
        return Response.buildSuccess();
    }
}