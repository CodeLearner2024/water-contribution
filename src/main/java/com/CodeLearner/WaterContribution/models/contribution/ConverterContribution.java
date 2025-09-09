package com.CodeLearner.WaterContribution.models.contribution;

import com.CodeLearner.WaterContribution.models.membre.MemberConvert;
import org.springframework.stereotype.Component;

@Component
public class ConverterContribution {
    private final MemberConvert convert;

    public ConverterContribution(MemberConvert convert) {
        this.convert = convert;
    }

    public ResponseContribution toResponse(WaterContribution waterContribution){
        ResponseContribution response = new ResponseContribution();
        response.setContributed(waterContribution.isContributed());
        response.setMonth(waterContribution.getMonth());
        response.setMember(convert.toResponse(waterContribution.getMember()));
        return response;
    }


    public WaterContribution toEntity(RequestContribution request){
        WaterContribution waterContribution = new WaterContribution();
        waterContribution.setContributed(request.isContributed());
        waterContribution.setMonth(request.getMonth());
        return waterContribution;
    }
}
