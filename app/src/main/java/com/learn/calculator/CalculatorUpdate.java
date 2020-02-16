package com.learn.calculator;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorUpdate {
    public static void Updater(TextView t, char s, Context context) {
        String temp = (String) t.getText();
        if(temp.length() == 0) {
            temp += s;
            t.setText(temp);
        }
        else {
            if(checkOp(t,s,context)) {
                temp += s;
                t.setText(temp);
            }
            else
                Toast.makeText(context, "Mairu repeat", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean checkOp(TextView t, char c, Context context) {
        String last_char = (String) t.getText();
        char x = last_char.charAt(last_char.length() - 1);
        String ops = "+-*÷%.";
        if (ops.indexOf(c) >= 0 && ops.indexOf(x) >= 0)
            return false;
        else
            return true;
    }
}
