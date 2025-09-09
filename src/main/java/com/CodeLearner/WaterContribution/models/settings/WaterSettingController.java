package com.CodeLearner.WaterContribution.models.settings;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/water-setting")
public class WaterSettingController {

    private final WaterSettingService waterSettingService;

    public WaterSettingController(WaterSettingService waterSettingService) {
        this.waterSettingService = waterSettingService;
    }

    @PostMapping
    public ResponseEntity<ResponseSetting> create(@RequestBody RequestSetting request){
        ResponseSetting response = waterSettingService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseSetting> fetch(){
        ResponseSetting response = waterSettingService.fetch();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
