/*
*   Author : Jerin P Jimmy
*   Code Mechanic
*   No Copyright
* */

package com.learn.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView calc_box, ans_box;
    double n1 = 0, n2 = 0, result = 0;
    Calculation calculation = new Calculation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation.setOperand1("0");
        calculation.setOperand2("0");
        calculation.setAnswer(0);
        calculation.setCurrentOp('+');
        calculation.setOpFlag(true);
    }

    public void Calc(View view) {
        calc_box = findViewById(R.id.eqn_text);
        ans_box = findViewById(R.id.ans_text);
        String s = (String) calc_box.getText();
        switch (view.getId()) {
            case R.id.num0:
                CalculatorUpdate.Updater(calc_box, '0', getApplicationContext(), calculation);
                break;
            case R.id.num1:
                CalculatorUpdate.Updater(calc_box, '1', getApplicationContext(), calculation);
                break;
            case R.id.num2:
                CalculatorUpdate.Updater(calc_box, '2', getApplicationContext(), calculation);
                break;
            case R.id.num3:
                CalculatorUpdate.Updater(calc_box, '3', getApplicationContext(), calculation);
                break;
            case R.id.num4:
                CalculatorUpdate.Updater(calc_box, '4', getApplicationContext(), calculation);
                break;
            case R.id.num5:
                CalculatorUpdate.Updater(calc_box, '5', getApplicationContext(), calculation);
                break;
            case R.id.num6:
                CalculatorUpdate.Updater(calc_box, '6', getApplicationContext(), calculation);
                break;
            case R.id.num7:
                CalculatorUpdate.Updater(calc_box, '7', getApplicationContext(), calculation);
                break;
            case R.id.num8:
                CalculatorUpdate.Updater(calc_box, '8', getApplicationContext(), calculation);
                break;
            case R.id.num9:
                CalculatorUpdate.Updater(calc_box, '9', getApplicationContext(), calculation);
                break;

            case R.id.dot:
                CalculatorUpdate.Updater(calc_box, '.', getApplicationContext(), calculation);
                break;

            case R.id.add:
                CalculatorUpdate.Updater(calc_box, '+', getApplicationContext(), calculation);
                break;
            case R.id.sub:
                CalculatorUpdate.Updater(calc_box, '-', getApplicationContext(), calculation);
                break;
            case R.id.mul:
                CalculatorUpdate.Updater(calc_box, '*', getApplicationContext(), calculation);
                break;
            case R.id.div:
                CalculatorUpdate.Updater(calc_box, '÷', getApplicationContext(), calculation);
                break;
            case R.id.mod:
                CalculatorUpdate.Updater(calc_box, '%', getApplicationContext(), calculation);
                break;

            case R.id.del:
                if (s.length() != 0) {
                    s = s.substring(0, (s.length() - 1));
                    calc_box.setText(s);
                }
                String n = calculation.getOperand2();
                n = n.substring(0, (n.length() - 1));
                calculation.setOperand2(n);
                break;

            case R.id.equal:
                double n1 = Double.parseDouble(calculation.getOperand1());
                double n2 = Double.parseDouble(calculation.getOperand2());
                switch (calculation.getCurrentOp()) {
                    case '+':
                        n1 = n1 + n2;
                        break;
                    case '-':
                        n1 = n1 - n2;
                        break;
                    case '*':
                        n1 = n1 * n2;
                        break;
                    case '÷':
                        n1 = n1 / n2;
                        break;
                    case '%':
                        n1 = n1 % n2;
                        break;
                }
                calculation.setAnswer(n1);
                ans_box.setText(Double.toString(calculation.getAnswer()));
                break;

            case R.id.clear:
                calc_box.setText("");
                calculation.setOperand1("0");
                calculation.setOperand2("0");
                calculation.setCurrentOp('+');
                calculation.setAnswer(0);
                break;
        }
    }
}