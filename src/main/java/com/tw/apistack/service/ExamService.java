package com.tw.apistack.service;

import com.tw.apistack.endpoint.exam.dto.Exam;

public class ExamService {
    private Exam exam;

    public boolean creteExam(Exam exam){
        if(exam.getEndDate().after(exam.getStartDate())) {
            this.exam = exam;
            return true;
        }

        return false;
    }

    public Exam getCurrentExam(){
        return exam;
    }
}
