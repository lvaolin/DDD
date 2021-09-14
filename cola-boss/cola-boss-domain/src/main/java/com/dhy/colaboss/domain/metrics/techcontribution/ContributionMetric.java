package com.dhy.colaboss.domain.metrics.techcontribution;

import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.dhy.colaboss.domain.metrics.MainMetric;
import com.dhy.colaboss.domain.metrics.MainMetricType;
import com.dhy.colaboss.domain.user.UserProfile;
import lombok.Data;

/**
 * ContributionMetric
 *
 * @author Frank Zhang
 * @date 2018-08-27 7:06 PM
 */
@Data
public class ContributionMetric extends MainMetric {

    private static Logger logger = LoggerFactory.getLogger(ContributionMetric.class);

    private CodeReviewMetric codeReviewMetric;
    private RefactoringMetric refactoringMetric;
    private MiscMetric miscMetric;

    public ContributionMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setContributionMetric(this);
        this.metricMainType = MainMetricType.TECH_CONTRIBUTION;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getTechContributionWeight();
    }

}