package com.dorvis.quizapp.model;

/**
 * Created by sai on 18/2/18.
 */

public class Question3 extends Question {
    private int PYTHONID;
    private String PythonQUESTION;
    private String pOPTA;
    private String pOPTB;
    private String pOPTC;
    private int pANSWER;


    public Question3() {

    }

    public Question3(String queSTION, String optA, String optB, String optC,
                     int ansWER) {

        PythonQUESTION = queSTION;
        pOPTA = optA;
        pOPTB = optB;
        pOPTC = optC;
        pANSWER = ansWER;
    }

    public int getPYTHONID() {
        return PYTHONID;
    }

    public void setPYTHONID(int PYTHONID) {
        this.PYTHONID = PYTHONID;
    }

    public String getPythonQUESTION() {
        return PythonQUESTION;
    }

    public void setPythonQUESTION(String pythonQUESTION) {
        PythonQUESTION = pythonQUESTION;
    }

    public String getpOPTA() {
        return pOPTA;
    }

    public void setpOPTA(String pOPTA) {
        this.pOPTA = pOPTA;
    }

    public String getpOPTB() {
        return pOPTB;
    }

    public void setpOPTB(String pOPTB) {
        this.pOPTB = pOPTB;
    }

    public String getpOPTC() {
        return pOPTC;
    }

    public void setpOPTC(String pOPTC) {
        this.pOPTC = pOPTC;
    }

    public int getpANSWER() {
        return pANSWER;
    }

    public void setpANSWER(int pANSWER) {
        this.pANSWER = pANSWER;
    }
}