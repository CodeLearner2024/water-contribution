package com.CodeLearner.WaterContribution.models.settings;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_water_settings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double contributionAmount;
    private double amountPerCan;
    private int memberNumber;
}
