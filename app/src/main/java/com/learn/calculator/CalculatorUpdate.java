package com.learn.calculator;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorUpdate {
    public static void Updater(TextView t, String s, Context context) {
        String temp = (String) t.getText();
        temp += s;
        t.setText(temp);
    }

    public static boolean checkOp(TextView t, Context context) {
        String last_char = (String) t.getText();
        char x = last_char.charAt(last_char.length()-1);
        String ops = "+-*/%";
        if(ops.indexOf(x) < 0) {
            Toast.makeText(context , "Last Character = " + x, Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}
