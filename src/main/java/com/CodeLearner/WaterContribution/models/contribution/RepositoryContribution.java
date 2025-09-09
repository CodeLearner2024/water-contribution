package com.CodeLearner.WaterContribution.models.contribution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface RepositoryContribution extends JpaRepository<WaterContribution,Long> {


    @Query(value = "select a from WaterContribution a where a.month =: month")
    List<WaterContribution> fetchByMonth(Month month);
}
