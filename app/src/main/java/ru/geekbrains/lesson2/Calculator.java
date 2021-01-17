package ru.geekbrains.lesson2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Observable;

public class Calculator implements Parcelable {

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };
    private final char button2sub = "-";
    private final char button1summ = "+";
    private final char button3div = "÷";
    private final char button3multip = "×";
    private final char OpNone = 0;
    char pendingOp = 0;
    char previousValue = 0;
    char currentValue = 0;
    private double resultField;
    private double numberField;
    private char operationField;

    {


    }

    protected LogicCalculator(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getValue() {
        return Integer.toString(currentValue);
    }

    public void addDigit(String s) {
        char c = s.charAt(0);
        String val = getValue() + c;
        setDisplay((char) Integer.parseInt(val));
    }

    public void addDigit(char c) {
        String val = getValue() + c;
        setDisplay((char) Integer.parseInt(val));
    }

    public void setOperation(char op) {
        if (pendingOp != OpNone)
            calculate();
        previousValue = currentValue;
        this.pendingOp = op;
        currentValue = 0;
    }

    public void setDisplay(char value) {
        currentValue = value;
        setChanged();
        notifyObservers();
    }

    public void clear() {

        this.pendingOp = OpNone;
        previousValue = 0;
        setDisplay((char) 0);
    }

    public void calculate() {
        if (pendingOp == button1summ) {
            setDisplay((char) (previousValue + currentValue));
        } else if (pendingOp == button2sub) {
            setDisplay((char) (previousValue - currentValue));
        } else if (pendingOp == button3multip) {
            setDisplay((char) (previousValue * currentValue));
        } else if (pendingOp == button3div) {
            setDisplay((char) (previousValue / currentValue));
        }
        pendingOp = OpNone;
        previousValue = 0;
    }

}

    public void actionPerformed() {

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


public class p(Double number, String operation) {

        if(operand ==null)

    {
        operand = number;
    }
        else

    {
        if (lastOperation.equals("=")) {
            lastOperation = operation;
        }
        switch (lastOperation) {
            case "=":
                operand = number;
                break;
            case "/":
                if (number == 0) {
                    operand = 0.0;
                } else {
                    operand /= number;
                }
                break;
            case "*":
                operand *= number;
                break;
            case "+":
                operand += number;
                break;
            case "-":
                operand -= number;
                break;
            case 'C':
                operand.clear();
                break;
        }
    }
        resultField.setText(operand.toString().

    replace('.',','))
            numberField.setText("")
}
/*
public class LogicCalculator {
            try {
        switch (evt.getActionCommand().charAt(0)) {
            case '+':
                model.setOperation(CalcModel.OP_ADD);
                break;
            case '-':
                model.setOperation(CalcModel.OP_SUB);
                break;
            case '*':
                model.setOperation(CalcModel.OP_MUL);
                break;
            case '/':
                model.setOperation(CalcModel.OP_DIV);
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
    } catch (NumberFormatException ex) {}
            resultField.setText(operand.toString().replace('.', ','));
        numberField.setText("");
}
}
*/