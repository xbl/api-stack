package com.tw.apistack.endpoint.exam;

import com.tw.apistack.core.response.Response;
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
    public Response createExam(@RequestBody Exam exam){
        HttpStatus httpStatus = ExamService.getInstance().createExam(exam) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new Response(httpStatus, "", null);
    }

    @GetMapping("/exam")
    public Response getExam() {
        Exam exam = ExamService.getInstance().getCurrentExam();
        return new Response(HttpStatus.OK, "", exam);
    }
}
