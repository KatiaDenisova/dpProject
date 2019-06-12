package com.dp.english.presenter.taketest;

import com.dp.english.model.Answer;

import java.util.List;

public class QuestionPojo {
    private String nameQuestion;
    private List<Answer> answers = null;

    public QuestionPojo(String nameQuestion, List<Answer> answers) {
        this.nameQuestion = nameQuestion;
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getNameQuestion() {
        return nameQuestion;
    }

}
