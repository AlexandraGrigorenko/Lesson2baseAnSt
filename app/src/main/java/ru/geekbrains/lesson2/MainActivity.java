package ru.geekbrains.lesson2;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Observable;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private final Calculator calculator = new Calculator();
    Button buttons;
    Double operand = null;
    String lastOperation = "=";
    private Button button11;
    private Button button22;
    private Button button33;
    private Button button14;
    private Button button25;
    private Button button36;
    private Button button17;
    private Button button28;
    private Button button29;
    private Button button10;
    private Button button2sub;
    private Button button1summ;
    private Button button3div;
    private Button button3multip;
    private Button button3Clear;
    private Button button3equal;
    private TextView resultField;
    private EditText numberField;
    private TextView operationField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initField();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(operationField, calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        Calculator = instanceState.getParcelable(operationField);
        setShowResultText();
    }

    private void initField() {
        initButton();
        setClickListener();
    }

    private void initButton() {
        button11 = findViewById(R.id.button11);
        button22 = findViewById(R.id.button22);
        button33 = findViewById(R.id.button33);
        button14 = findViewById(R.id.button14);
        button25 = findViewById(R.id.button25);
        button36 = findViewById(R.id.button36);
        button17 = findViewById(R.id.button17);
        button28 = findViewById(R.id.button28);
        button29 = findViewById(R.id.button29);
        button10 = findViewById(R.id.button10);
        button1summ = findViewById(R.id.button1summ);
        button2sub = findViewById(R.id.button2sub);
        button3div = findViewById(R.id.button3div);
        button3multip = findViewById(R.id.button3multip);
        button3Clear = findViewById(R.id.button3Clear);
        button3equal = findViewById(R.id.button3equal);
        resultField = findViewById(R.id.resultField);
        numberField = findViewById(R.id.numberField);
        operationField = findViewById(R.id.operationField);
    }

    private void setClickListener() {
        button11.setOnClickListener(this);
        button22.setOnClickListener(this);
        button33.setOnClickListener(this);
        button14.setOnClickListener(this);
        button25.setOnClickListener(this);
        button36.setOnClickListener(this);
        button17.setOnClickListener(this);
        button28.setOnClickListener(this);
        button29.setOnClickListener(this);
        button10.setOnClickListener(this);
        button1summ.setOnClickListener(this);
        button2sub.setOnClickListener(this);
        button3div.setOnClickListener(this);
        button3multip.setOnClickListener(this);
        button3Clear.setOnClickListener(this);
        button3equal.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        numberField.append(buttons.getText());
        if (lastOperation.equals("=") && buttons != null) {
            buttons = null;
        }
        try {
            switch (v.getId()) {
                case '+':
                    setOperation(button1summ);
                    break;
                case '-':
                    setOperation(button2sub);
                    break;
                case '*':
                    setOperation(button3multip);
                    break;
                case '/':
                    setOperation(button3div);
                    break;
                case '=':
                    model.calculate();
                    break;
                case 'C':
                    model.clear();
                    break;
                default:
                    model.addDigit(evt.getActionCommand());
                    break;
            }
        } catch (NumberFormatException ex) {
        }
    }

    public void update(Observable o, Object arg) {
        display.setText(model.getValue());
    }

}
    }




