package com.CodeLearner.WaterContribution.models.membre;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotBlank(message = "First name must be provided")
    private String firstname;
    @NotBlank(message = "Last name must be provided")
    private String lastname;
}
