package com.CodeLearner.WaterContribution.models.membre;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final MemberConvert convert;

    public ServiceImpl(MemberRepository memberRepository, MemberConvert convert) {
        this.memberRepository = memberRepository;
        this.convert = convert;
    }

    @Override
    public Response create(Request request) {
        Member member = convert.toEntity(request);
        Member savedMemer = memberRepository.save(member);
        return convert.toResponse(savedMemer);
    }

    @Override
    public List<Response> fetch() {
        return memberRepository.findAll().stream().map(convert::toResponse).toList();
    }
}
