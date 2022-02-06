package com.jobforandroid.gb_calculator_2022;

public class CalculatorModel {
    private int firstArg;
    private int secondArg;

    private StringBuilder inputStr = new StringBuilder();

    private int actionSelected;

    private State state;

    private enum State {
        firstArgInput,
        operationSelected,
        secondArgInput,
        resultShow
    }

    public CalculatorModel() {
        state = State.firstArgInput;
    }

    public void onNumPressed(int buttonId) {

        if (state == State.resultShow) {
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if (state == State.operationSelected) {
            state = State.secondArgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() < 9) {
            switch (buttonId) {
                case R.id.btn_zero:
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.btn_1:
                    inputStr.append("1");
                    break;
                case R.id.btn_2:
                    inputStr.append("2");
                    break;
                case R.id.btn_3:
                    inputStr.append("3");
                    break;
                case R.id.btn_4:
                    inputStr.append("4");
                    break;
                case R.id.btn_5:
                    inputStr.append("5");
                    break;
                case R.id.btn_6:
                    inputStr.append("6");
                    break;
                case R.id.btn_7:
                    inputStr.append("7");
                    break;
                case R.id.btn_8:
                    inputStr.append("8");
                    break;
                case R.id.btn_9:
                    inputStr.append("9");
                    break;
            }
        }

    }

    public void onActionPressed(int actionId) {
        if (actionId == R.id.btn_equal && state == State.secondArgInput && inputStr.length() > 0) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.btn_plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.btn_minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.btn_multi:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.btn_division:
                    inputStr.append(firstArg / secondArg);
                    break;
            }

        } else if (inputStr.length() > 0 && state == State.firstArgInput && actionId != R.id.btn_equal) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.operationSelected;
            actionSelected = actionId;
        }
    }

    public String getText() {
        StringBuilder str = new StringBuilder();
        switch (state) {
            default:
                return inputStr.toString();
            case operationSelected:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .toString();
            case secondArgInput:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(inputStr)
                        .toString();
            case resultShow:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(secondArg)
                        .append(" = ")
                        .append(inputStr.toString())
                        .toString();
        }
    }

    private char getOperationChar() {
        switch (actionSelected) {
            case R.id.btn_plus:
                return '+';
            case R.id.btn_minus:
                return '-';
            case R.id.btn_multi:
                return '*';
            case R.id.btn_division:
            default:
                return '/';

        }
    }

    public void reset() {
        state = State.firstArgInput;
        inputStr.setLength(0);
    }
}
