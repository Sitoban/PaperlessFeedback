package com.example.a1018651.obhs.beans;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by 1018651 on 03/08/2018.
 */

public class FeedbackBean {
    private static FeedbackBean instance;
    private FeedbackBean(){
        numberOfFeedbacks = 0;
        feedBackPsiList = new ArrayList();
    };

    public static FeedbackBean getInstance() {
        if(instance == null) {
            instance = new FeedbackBean();
        }
        return instance;
    }

    private int numberOfFeedbacks;
    List feedBackPsiList;

    public void addFeedBack(float psi) {
        numberOfFeedbacks++;
        feedBackPsiList.add(psi);
    }

    public String getFeedBackCount() {
        return ("" + numberOfFeedbacks);
    }
}
