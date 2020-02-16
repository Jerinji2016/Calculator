package com.learn.calculator;

import android.widget.TextView;

public class CalculatorUpdate {
    public static void Updater(TextView t, String s) {
        String temp = (String) t.getText();
        temp += s;
        t.setText(temp);
    }

    public static boolean checkOp(TextView t) {
        String last_char = (String) t.getText();
        char x = last_char.charAt(last_char.length()-1);

        return false;
    }
}
