package com.dorvis.quizapp.model;

/**
 * Created by sai on 16/2/18.
 */

public class Question {
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private int ANSWER;
    public Question()
    {

    }
    public Question(String qUESTION, String oPTA, String oPTB, String oPTC,
                    int aNSWER) {

        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        ANSWER = aNSWER;
    }

    public int getID()
    {
        return ID;
    }
    public String getQUESTION() {
        return QUESTION;
    }
    public String getOPTA() {
        return OPTA;
    }
    public String getOPTB() {
        return OPTB;
    }
    public String getOPTC() {
        return OPTC;
    }
    public int getANSWER() {
        return ANSWER;
    }
    public void setID(int id)
    {
        ID=id;
    }
    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }
    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }
    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }
    public void setOPTC(String oPTC) {
        OPTC = oPTC;
    }
    public void setANSWER(int aNSWER) {
        ANSWER = aNSWER;
    }

}