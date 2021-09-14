package com.dhy.colaboss.domain.metrics.appquality;

import com.dhy.colaboss.domain.metrics.MainMetric;
import com.dhy.colaboss.domain.metrics.MainMetricType;
import com.dhy.colaboss.domain.metrics.devquality.BugMetric;
import com.dhy.colaboss.domain.user.UserProfile;

public class AppQualityMetric extends MainMetric {

    private AppMetric appMetric;

    public AppQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setAppQualityMetric(this);
        this.metricMainType = MainMetricType.APP_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getAppQualityWeight();
    }
}
