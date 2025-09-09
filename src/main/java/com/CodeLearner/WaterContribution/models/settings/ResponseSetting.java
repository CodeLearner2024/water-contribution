package com.CodeLearner.WaterContribution.models.settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSetting {
    private Long id;
    private double contributionAmount;
    private double amountPerCan;
    private int memberNumber;

}
