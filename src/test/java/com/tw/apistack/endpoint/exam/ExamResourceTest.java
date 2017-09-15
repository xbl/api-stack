package com.tw.apistack.endpoint.exam;

import com.tw.apistack.core.response.Response;
import com.tw.apistack.endpoint.exam.dto.Exam;
import com.tw.apistack.endpoint.hello.HelloResource;
import com.tw.apistack.endpoint.hello.dto.Greeting;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamResourceTest {

    @Test
    public void should_return_httpstatus_badrequest_when_createExam_invalid_input(){
        ExamResource examResource = new ExamResource();
        Exam exam = new Exam();
        Response response = examResource.createExam(exam);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void should_return_httpstatus_ok_when_getCurrentExam(){
        ExamResource examResource = new ExamResource();
        Response response = examResource.getExam();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK);
        assertThat(response.getData()).isNull();
    }
}
