package com.CodeLearner.WaterContribution.models.settings;

import org.springframework.stereotype.Component;

@Component
public class ConverterSetting {

    public ResponseSetting toResponse(WaterSettings waterSettings){
        ResponseSetting response = new ResponseSetting();
        response.setId(waterSettings.getId());
        response.setAmountPerCan(waterSettings.getAmountPerCan());
        response.setContributionAmount(waterSettings.getContributionAmount());
        return response;
    }

    public WaterSettings toEntity(RequestSetting request){
        WaterSettings entity = new WaterSettings();
        entity.setAmountPerCan(request.getAmountPerCan());
        entity.setContributionAmount(request.getContributionAmount());
        return entity;
    }


}
