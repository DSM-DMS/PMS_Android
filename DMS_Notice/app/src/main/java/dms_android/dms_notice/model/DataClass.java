package dms_android.dms_notice.model;

import java.util.ArrayList;

/**
 * Created by root1 on 2017. 8. 10..
 */

public class DataClass {
    private String questionName;

    private ArrayList<String> answerList;

    public DataClass(String questionName, ArrayList<String> answerList) {
        this.questionName = questionName;
        this.answerList = answerList;
    }

    public String getQuestionName() {
        return questionName;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }
}
