package com.tw.apistack.endpoint.login;

import com.tw.apistack.core.response.Response;
import com.tw.apistack.endpoint.exam.dto.Exam;
import com.tw.apistack.endpoint.login.dto.Candidate;
import com.tw.apistack.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@RestController
public class SignUpResource {

    private static Set<Candidate> candidates= new HashSet<>();
    private static final String CANDIDATE_INFO_MISSING_MESSAGE = "Info is missing, please check";
    private static final String DUPLICATED_PHONE_NUMBER_MESSAGE = "Phone number is used";
    private static final String SIGN_UP_SUCCESSED_MESSAGE = "Successed";


    @PostMapping("/signup")
    public Response signUp(@RequestBody Candidate candidate) {

        if(candidate == null || candidate.getPhoneNumber() == null || candidate.getLocation() == null || candidate.getName() == null) {
            return new Response(HttpStatus.BAD_REQUEST, CANDIDATE_INFO_MISSING_MESSAGE, null);
        }

        if(candidates.contains(candidate)){
            return new Response(HttpStatus.BAD_REQUEST, DUPLICATED_PHONE_NUMBER_MESSAGE, null);
        }

        candidates.add(candidate);
        return new Response(HttpStatus.OK, SIGN_UP_SUCCESSED_MESSAGE, candidates);
    }

    @GetMapping("/signup")
    public Set<Candidate> showCandidates(){
        return candidates;
    }


}
