package com.CodeLearner.WaterContribution.models.contribution;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/water-contributions")
public class WaterContributionController {

    public final ContributionService contributionService;

    public WaterContributionController(ContributionService contributionService) {
        this.contributionService = contributionService;
    }

    @PostMapping
    public ResponseEntity<ResponseContribution> create(@RequestBody RequestContribution request){
        ResponseContribution response = contributionService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseContribution>> fetch(@PathVariable("month")Month month){
        List<ResponseContribution> response = contributionService.fetchByMonth(month);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
