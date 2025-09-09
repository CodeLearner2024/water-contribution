package com.CodeLearner.WaterContribution.models.membre;


import com.CodeLearner.WaterContribution.models.config.global.DeleteOperationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements MemberService {
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

    @Override
    public Response update(Long memberId, Request request) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new UnsupportedOperationException("Member does not exist"));
        member.setLastname(request.getLastname());
        member.setFirstname(request.getFirstname());
        Member savedMember = memberRepository.save(member);
        return convert.toResponse(savedMember);
    }

    @Override
    public DeleteOperationResponse delete(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new UnsupportedOperationException("Member does not exist"));
        memberRepository.deleteById(member.getId());
        return new DeleteOperationResponse(true);
    }
}
