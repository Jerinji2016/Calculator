package com.learn.calculator;

import android.content.Context;
import android.widget.TextView;

class CalculatorUpdate {
    static void Updater(TextView t, char s, Context context, Calculation calculation) {
        String temp = (String) t.getText();
        if (checkOp(t, s, context, calculation)) {          //  Check for consecutive operator repeat
            //  Continue to append value
            temp += s;
            t.setText(temp);

            if (Character.getNumericValue(s) >= 0 && Character.getNumericValue(s) <= 9 || s == '.') {
                calculation.setOperand2(calculation.getOperand2()+s);
            }
            else if (Character.getNumericValue(s) < 0) {
                double n1 = Double.parseDouble(calculation.getOperand1());
                double n2= Double.parseDouble(calculation.getOperand2());
                switch (calculation.getCurrentOp()) {
                    case '+' :
                        n1 = n1 + n2;
                        break;
                    case '-' :
                        n1 = n1 - n2;
                        break;
                    case '*' :
                        n1 = n1 * n2;
                        break;
                    case '÷' :
                        n1 = n1 / n2;
                        break;
                    case '%' :
                        n1 = n1 % n2;
                        break;
                }
                calculation.setOperand1(Double.toString(n1));
                calculation.setOperand2("");
                calculation.setCurrentOp(s);
                calculation.setOpFlag(true);
            }
        }
    }

    private static boolean checkOp(TextView t, char c, Context context, Calculation calculation) {
        String last_char = (String) t.getText();

        if(last_char.length() == 0) {
            if(Character.getNumericValue(c) < 0)
                return false;
            else
                return true;
        }
        char x = last_char.charAt(last_char.length() - 1);
        String ops = "+-*÷%.";

        if (ops.indexOf(c) >= 0 && ops.indexOf(x) >= 0) {
            return false;
        }
        else {
            if(c == '.' && calculation.isOpFlag()) {
                calculation.setOpFlag(false);
                return true;
            }
            else if(!calculation.isOpFlag() && c == '.')
                return false;
            return true;
        }
    }
}
