package com.CodeLearner.WaterContribution.models.settings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterSettingRepository extends JpaRepository<WaterSettings,Long> {
}
