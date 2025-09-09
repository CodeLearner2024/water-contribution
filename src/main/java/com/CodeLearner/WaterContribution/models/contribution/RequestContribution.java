package com.CodeLearner.WaterContribution.models.contribution;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestContribution {
    private Long memberId;
    private boolean contributed;
    private Month month;
}
