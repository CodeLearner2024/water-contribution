package com.CodeLearner.WaterContribution.models.settings;

import java.util.List;

public interface WaterSettingService {

    public ResponseSetting create(RequestSetting request);

    ResponseSetting fetch();
}
