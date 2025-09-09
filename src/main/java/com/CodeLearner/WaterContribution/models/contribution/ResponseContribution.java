package com.CodeLearner.WaterContribution.models.contribution;

import com.CodeLearner.WaterContribution.models.membre.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseContribution {
    private boolean contributed;
    private Month month;
    private Response member;
}
