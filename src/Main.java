import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Введите данные");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        String rezultat = calc(inputString);
        System.out.println(rezultat);


    }

    static int calculator(String operator, int num1, int num2) {
        int sum = 0;
        switch (operator) {
            case "+":
                sum = num1 + num2;
                break;
            case "-":
                sum = num1 - num2;
                break;
            case "*":
                sum = num1 * num2;
                break;
            case "/":
                sum = num1 / num2;
                break;
            default:
                throw new RuntimeException("Ошибка");
        }
        return sum;

    }


    static int convertRomanToArabic(String romNum) {
        int arabicNum = 0;
        if (romNum.equals("I")) {
            arabicNum = 1;
        } else if (romNum.equals("II")) {
            arabicNum = 2;
        } else if (romNum.equals("III")) {
            arabicNum = 3;
        } else if (romNum.equals("IV")) {
            arabicNum = 4;
        } else if (romNum.equals("V")) {
            arabicNum = 5;
        } else if (romNum.equals("VI")) {
            arabicNum = 6;
        } else if (romNum.equals("VII")) {
            arabicNum = 7;
        } else if (romNum.equals("VIII")) {
            arabicNum = 8;
        } else if (romNum.equals("IX")) {
            arabicNum = 9;
        } else if (romNum.equals("X")) {
            arabicNum = 10;
        } else {
            throw new RuntimeException("Ошибка");
        }
        return arabicNum;
    }

    static String calc(String inputString) throws IOException {
        String result = null;


        String[] sArray = inputString.split(" ");
        String arabicNumbers = "12345678910";
        String romanNumbers = "I II III IV V VI VII VIII IX X";
        String operations = "+-*/";

        if (sArray.length != 3) {
            throw new RuntimeException("Ошибка");
        }
        if (!operations.contains(sArray[1])) {
            throw new RuntimeException("Ошибка");
        }

        if (arabicNumbers.contains(sArray[0]) && arabicNumbers.contains(sArray[2])) {
            arabicInputData(sArray);
            result=arabicInputData(sArray);
            return result;
        } else if (romanNumbers.contains(sArray[0]) && romanNumbers.contains(sArray[2])) {
            romanInputData(sArray);
            result=romanInputData(sArray);
            return result;

        } else {
            throw new RuntimeException("Ошибка");
        }
    }

    static String romanInputData(String[] sArray) throws IOException {


        int arabicNumb1 = convertRomanToArabic(sArray[0]);
        int arabicNumb2 = convertRomanToArabic(sArray[2]);

        int sum = calculator(sArray[1], arabicNumb1, arabicNumb2);

        if (sum <= 0) {
            throw new RuntimeException("Ошибка");
        }
        integerToRomanNumeral(sum);

        String romanSum = integerToRomanNumeral(sum);

        return  romanSum;

    }

    static String arabicInputData(String[] sArray) throws IOException {

        int num1 = Integer.parseInt(sArray[0]);
        if (num1 < 1 || num1 > 10) {
            throw new RuntimeException("Ошибка");
        }
        int num2 = Integer.parseInt(sArray[2]);
        if (num2 < 1 || num2 > 10) {
            throw new RuntimeException("Ошибка");
        }
        int sum = calculator(sArray[1], num1, num2);

        return  (String.valueOf(sum));

    }

    static String integerToRomanNumeral(int input) {
        if (input < 1 || input > 3999)
            return "Неверное римское число";
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;
        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }

}

