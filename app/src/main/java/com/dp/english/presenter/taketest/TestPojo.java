package com.dp.english.presenter.taketest;

import com.dp.english.model.Answer;
import com.dp.english.model.Question;

import java.util.List;

public class TestPojo {
    private String testName;
    private List<QuestionPojo> questions = null;

    public TestPojo(String testName, List<QuestionPojo> questions) {
        this.testName = testName;
        this.questions = questions;
    }

    List<QuestionPojo> getQuestions() {
        return questions;
    }

    String getTestName() {
        return testName;
    }

}
