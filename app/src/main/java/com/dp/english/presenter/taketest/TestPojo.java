package com.dp.english.presenter.taketest;

import com.dp.english.model.Answer;
import com.dp.english.model.Question;

import java.util.List;

public class TestPojo {
    private String testName;
    private List<QuestionPojo> questions;

    public TestPojo(String testName, List<QuestionPojo> questions) {
        this.testName = testName;
        this.questions = questions;
    }

   public List<QuestionPojo> getQuestions() {
        return questions;
    }

   public String getTestName() {
        return testName;
    }

}

