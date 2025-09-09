package com.CodeLearner.WaterContribution.models.contribution;

import java.time.Month;
import java.util.List;

public interface ContributionService {

    public ResponseContribution create(RequestContribution request);

    public List<ResponseContribution> fetchByMonth(Month month);

}
