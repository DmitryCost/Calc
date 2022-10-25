import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Roman roman = new Roman();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение арабскими числами, 2+2 или римскими, (I+IV)," +
                " используйте только операции: +,-,*,/, далее нажмите Enter и все!");
        String input = scan.nextLine().replaceAll(" ", "");
        String [] operations = {"+", "-", "/", "*"};
        //Входят в синтаксис регулярных выражений символы:"+","*"
        String [] regexOperations = {"\\+","-","/","\\*"};
        //Определение арифмитического действия
        int operationsIndex = -1;
        for (int i=0; i<operations.length; i++){
            if(input.contains(operations[i])){
                operationsIndex = i;
                break;
            }
        }
        if (operationsIndex==-1){
            System.out.println("Вы ввели неправильное арифмитическое действие");
            return;
        }

        // Сплитим по знаку и возвращаем массив чисел
        String [] arrExpression = input.split(regexOperations[operationsIndex]);
        if (arrExpression.length > 2){
            throw new IOException("Нельзя совершать операции более с чем двумя операндами");
        }
        if (roman.isRoman(arrExpression[0]) == roman.isRoman(arrExpression[1])){
            int a,b;
            boolean isRoman = roman.isRoman(arrExpression[0]);
            if (isRoman) {
                a = roman.romanToInt(arrExpression[0]);
                b = roman.romanToInt(arrExpression[1]);
            } else {
                //Конвертация строки в число
                a = Integer.parseInt(arrExpression[0]);
                b = Integer.parseInt(arrExpression[1]);
            }

            if (a >= 10) {
                throw new IllegalArgumentException("Числа должны быть отличными от 0 или не больше 10!");
            } else if (a <= 0) {
                throw new IllegalArgumentException("Числа должны быть отличными от 0 или не больше 10!");
            } else if (b >= 10) {
                throw new IllegalArgumentException("Числа должны быть отличными от 0 или не больше 10!");
            } else if (b <= 0) {
                throw new IllegalArgumentException("Числа должны быть отличными от 0 или не больше 10!");
            }

            //Арифметика с числами
            int result = 0;
            switch (operations[operationsIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                //Ловим исключение для деления на 0
                case "/":
                    try {
                        result = a / b;
                    } catch (ArithmeticException | InputMismatchException exp) {
                        System.out.println("Exception: " + exp);
                        System.out.println("На 0 делить нельзя!");
                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Что-то пошло не так, попробуй снова");
            } if (isRoman){
                System.out.println(roman.intToRoman(result));
            } else {
                System.out.println(result);
            }

        } else {
            System.out.println("Запись должна быть в одном формате");
        }
    }
}

