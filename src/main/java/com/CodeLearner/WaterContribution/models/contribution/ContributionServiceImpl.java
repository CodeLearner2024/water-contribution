package com.CodeLearner.WaterContribution.models.contribution;

import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

@Service
public class ContributionServiceImpl implements ContributionService{
    private final RepositoryContribution repositoryContribution;
    private final ConverterContribution converter;

    public ContributionServiceImpl(RepositoryContribution repositoryContribution, ConverterContribution converter) {
        this.repositoryContribution = repositoryContribution;
        this.converter = converter;
    }

    @Override
    public ResponseContribution create(RequestContribution request) {
        WaterContribution waterContribution = converter.toEntity(request);
        WaterContribution saved = repositoryContribution.save(waterContribution);
        return converter.toResponse(saved);
    }

    @Override
    public List<ResponseContribution> fetchByMonth(Month month) {
        return repositoryContribution.fetchByMonth(month).stream().map(converter::toResponse).toList();
    }
}
