package com.CodeLearner.WaterContribution.models.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponse {
    private int manyOfMembers;
    private int contributedMembers;
    private double totalAmountContributed;
    private double amountAlreadyConsumed;
    private double remainingAmount;


}
