package com.CodeLearner.WaterContribution.models.membre;

import com.CodeLearner.WaterContribution.models.config.global.DeleteOperationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping
    public ResponseEntity<Response> create(@RequestBody Request request){
        Response response = memberService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Response>> fetch(){
        List<Response> responses = memberService.fetch();
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<Response> update(@PathVariable("memberId") Long memberId,@RequestBody Request request){
        Response response = memberService.update(memberId, request);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/{membreId}")
    public ResponseEntity<DeleteOperationResponse> delete(@PathVariable("memberId") Long memberId){
        DeleteOperationResponse response = memberService.delete(memberId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
