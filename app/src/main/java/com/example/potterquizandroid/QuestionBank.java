package com.example.potterquizandroid;

public class QuestionBank {
    private int questionId;
    private boolean answer;

    QuestionBank(int qId, boolean ans)
    {
        questionId = qId;
        answer = ans;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
