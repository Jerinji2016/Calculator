package com.dev.calculator;

public class Calculation {
    private String operand1;
    private String operand2;
    private boolean opFlag;
    private char currentOp;
    private double answer;

    Calculation() {
    }

    public String getOperand1() {
        return operand1;
    }

    void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public boolean isOpFlag() {
        return opFlag;
    }

    public void setOpFlag(boolean opFlag) {
        this.opFlag = opFlag;
    }

    public char getCurrentOp() {
        return currentOp;
    }

    void setCurrentOp(char currentOp) {
        this.currentOp = currentOp;
    }

    public double getAnswer() {
        return answer;
    }

    void setAnswer(double answer) {
        this.answer = answer;
    }
}
