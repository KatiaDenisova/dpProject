package com.dp.english.presenter.taketest;

import io.reactivex.annotations.Nullable;

public class TakeTestPresenter {
    private TestPojo test;
    private int qNumber = 0;

    public TakeTestPresenter(TestPojo test) {
        this.test = test;
    }

    @Nullable
    public QuestionPojo nextQuestion() {
        QuestionPojo questionPojo;
        if(qNumber < test.getQuestions().size()) {
            questionPojo = test.getQuestions().get(qNumber);
            qNumber++;
        } else {
            questionPojo = null;
        }
        return questionPojo;
    }

}
