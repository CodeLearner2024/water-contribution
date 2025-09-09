package com.CodeLearner.WaterContribution.models.membre;

import com.CodeLearner.WaterContribution.models.config.global.DeleteOperationResponse;

import java.util.List;

public interface MemberService {

    Response create(Request request);

    List<Response> fetch();

    Response update(Long memberId,Request request);

    DeleteOperationResponse delete(Long memberId);


}
