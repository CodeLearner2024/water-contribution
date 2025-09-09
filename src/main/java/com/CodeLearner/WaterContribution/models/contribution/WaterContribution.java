package com.CodeLearner.WaterContribution.models.contribution;

import com.CodeLearner.WaterContribution.models.membre.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_water_contributions")
public class WaterContribution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean contributed;
    private Month month;
    @ManyToOne(optional = false)
    private Member member;
}
