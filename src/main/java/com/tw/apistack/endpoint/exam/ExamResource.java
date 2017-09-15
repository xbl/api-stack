package com.tw.apistack.endpoint.exam;

import com.sun.deploy.net.HttpResponse;
import com.tw.apistack.endpoint.exam.dto.Exam;
import com.tw.apistack.endpoint.hello.dto.Greeting;
import com.tw.apistack.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Calendar;

@RestController
public class ExamResource {
    private ExamService examService = new ExamService();

    @PostMapping(value = "/exam")
    public HttpStatus createExam(@RequestBody Exam exam){
        return examService.creteExam(exam) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @GetMapping("/exam")
    public Exam getExam() {
        return examService.getCurrentExam();
    }
}
