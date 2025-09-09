package com.CodeLearner.WaterContribution.models.report;

import com.CodeLearner.WaterContribution.models.contribution.RepositoryContribution;
import com.CodeLearner.WaterContribution.models.contribution.WaterContribution;
import com.CodeLearner.WaterContribution.models.membre.MemberRepository;
import com.CodeLearner.WaterContribution.models.settings.WaterSettingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private final MemberRepository memberRepository;
    private final RepositoryContribution repositoryContribution;
    private final WaterSettingRepository waterSettingRepository;

    public ReportService(MemberRepository memberRepository, RepositoryContribution repositoryContribution, WaterSettingRepository waterSettingRepository) {
        this.memberRepository = memberRepository;
        this.repositoryContribution = repositoryContribution;
        this.waterSettingRepository = waterSettingRepository;
    }

    public ReportResponse visualizeReport(){
        List<WaterContribution> waterContributions = repositoryContribution.findAll();
        ReportResponse response = new ReportResponse();
        response.setManyOfMembers(memberRepository.findAll().size());
        response.setContributedMembers((int)waterContributions.stream().map(WaterContribution::isContributed).count());
        response.setAmountAlreadyConsumed(waterSettingRepository.findById(1L).get().getContributionAmount()*(int)waterContributions.stream().map(WaterContribution::isContributed).count());
        response.setTotalAmountContributed(waterSettingRepository.findById(1L).get().getContributionAmount()*memberRepository.findAll().size());
        return response;
    }


}
