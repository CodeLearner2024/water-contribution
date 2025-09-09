package com.CodeLearner.WaterContribution.models.membre;

import java.util.List;

public interface MemberService {

    Response create(Request request);

    List<Response> fetch();
}
