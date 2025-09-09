package com.CodeLearner.WaterContribution.models.membre;

import org.springframework.stereotype.Component;

@Component
public class MemberConvert {
    public Response toResponse(Member member){
        Response response = new Response();
        response.setId(member.getId());
        response.setLastname(member.getLastname());
        response.setFirstname(member.getFirstname());
        return response;
    }

    public Member toEntity(Request request){
        Member member = new Member();
        member.setFirstname(request.getFirstname());
        member.setLastname(request.getLastname());
        return member;
    }

}
