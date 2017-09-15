package com.tw.apistack.endpoint.exam.dto;

import java.util.Date;

public class Exam {
    private long startDateNum;
    private long endDateNum;

    public Exam(){}

    public Exam(long startDateNum, long endDateNum){
        this.startDateNum = startDateNum;
        this.endDateNum = endDateNum;
    }

    public Date getEndDate() {
        return new Date(startDateNum);
    }

    public Date getStartDate() {
        return new Date(endDateNum);
    }

    public void setStartDateNum(long startDateNum) {
        this.startDateNum = startDateNum;
    }

    public void setEndDateNum(long endDateNum) {
        this.endDateNum = endDateNum;
    }

    public long getStartDateNum() {
        return startDateNum;
    }

    public long getEndDateNum() {
        return endDateNum;
    }
}
