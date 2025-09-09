package com.CodeLearner.WaterContribution.models.settings;

import org.springframework.stereotype.Service;


@Service
public class WaterSettingServiceImpl implements WaterSettingService{
    private final WaterSettingRepository waterSettingRepository;
    private final ConverterSetting converterSetting;

    public WaterSettingServiceImpl(WaterSettingRepository waterSettingRepository, ConverterSetting converterSetting) {
        this.waterSettingRepository = waterSettingRepository;
        this.converterSetting = converterSetting;
    }

    @Override
    public ResponseSetting create(RequestSetting request) {
        WaterSettings waterSettings = converterSetting.toEntity(request);
        waterSettings.setId(1L);
        WaterSettings saved = waterSettingRepository.save(waterSettings);
        return converterSetting.toResponse(saved);
    }

    @Override
    public ResponseSetting fetch() {
WaterSettings waterSettings = waterSettingRepository.findAll().stream().findFirst().orElse(new WaterSettings());
        return converterSetting.toResponse(waterSettings);
    }
}
