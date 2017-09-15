package com.tw.apistack.endpoint.exam;

import com.tw.apistack.endpoint.exam.dto.Exam;
import com.tw.apistack.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExamResource {

    @PostMapping(value = "/exam")
    public HttpStatus createExam(@RequestBody Exam exam){
        return ExamService.getInstance().creteExam(exam) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @GetMapping("/exam")
    public Exam getExam() {
        return ExamService.getInstance().getCurrentExam();
    }
}
