package com.CodeLearner.WaterContribution.models.membre;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_members")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;


}
