package com.tw.apistack.service;

import com.tw.apistack.endpoint.exam.dto.Exam;

import java.util.Calendar;
import java.util.Date;

public class ExamService {
    private Exam exam;

    private static ExamService instance = null;
    protected ExamService() {
    }

    public static ExamService getInstance() {
        if(instance == null) {
            instance = new ExamService();
        }
        return instance;
    }

    public boolean createExam(Exam exam) {
        boolean isValid = IsValid(exam);
        if(isValid) {
            this.exam = exam;
        }

        return isValid;
    }

    public Exam getCurrentExam(){
        return exam;
    }

    private boolean IsValid(Exam exam){
        if (exam == null)
            return false;

        Date startDate = exam.getStartDate();
        Date endDate = exam.getEndDate();
        Date today = getToday();

        return  (startDate.after(today) || startDate.equals(today)) && endDate.after(startDate);
    }

    private Date getToday(){
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        return today.getTime();
    }
}
