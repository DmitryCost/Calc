import java.util.Scanner;

class Test {
    public static String sum(String sum1, String sum2) throws Exception{
        if (sum1.contains("\"")) {
            sum1 = sum1.replace("\"", "");
        }else {
            throw new Exception("Первым агрументом должна быть строка в ковычках!");
        }
        if (sum2.contains("\"")){
            sum2 = sum2.replace("\"","");
        }else {
            throw new Exception("Строки должны быть заключены в двойные ковычки, работает только с суммой и вычитанием!");
        }
        for (int i = 0; i < sum1.length(); i++) {
            if (sum1.length() > 10){
                throw new Exception("Длина каждой строки должна быть не больше или равной 10 символам!");
            }
        }
        for (int j = 0; j < sum2.length(); j++) {
            if (sum2.length() > 10){
                throw new Exception("Длина каждой строки должна быть не больше или равной 10 символам!");
            }
        }
        String str1 = "\"";
        String result1 = sum1+sum2;
        return str1+result1+str1;
    }
    public static String subtract(String sub1, String sub2) throws Exception {
        if (sub1.contains("\"")) {
            sub1 = sub1.replace("\"", "");
        }else {
            throw new Exception("Первым агрументом должна быть строка в ковычках!");
        }
        if (sub2.contains("\"")) {
            sub2 = sub2.replace("\"","");
        } else {
            throw new Exception("Строки должны быть заключены в двойные ковычки, работает только с суммой и вычитанием!");
        }
        for (int i = 0; i < sub1.length(); i++) {
            if (sub1.length() > 10){
                throw new Exception("Длина каждой строки должна быть не больше или равной 10 символам!");
            }
        }
        for (int j = 0; j < sub2.length(); j++) {
            if (sub2.length() > 10){
                throw new Exception("Длина каждой строки должна быть не больше или равной 10 символам!");
            }
        }
        String str2 = "\"";
        int index = sub1.indexOf(sub2);
        if (index == -1){
            return str2+sub1+str2;
        }else {
            String result2 = sub1.substring(0,index);
            result2 += sub1.substring(index+sub2.length());
            return str2+result2+str2;
        }
    }
    public static String multiply(String mul1, String mul2) throws Exception{
        if (mul1.contains("\"")) {
            mul1 = mul1.replace("\"", "");
        }else {
            throw new Exception("Первым агрументом должна быть строка в ковычках!");
        }
        for (int i = 0; i < mul1.length(); i++) {
            if (mul1.length() > 10){
                throw new Exception("Длина каждой строки должна быть не больше или равной 10 символам!");
            }
        }

        String str3 = "\"";
        int mul3 = Integer.parseInt(mul2);
        if (mul3 <= 0 | mul3 > 10){
            throw new Exception("Работать можно только с числами от 1 до 10 включительно!");
        }
        String result3 = "";
        for (int i = 0; i < mul3; i++) {
            result3 +=mul1;
            if (result3.length() >= 40){
                result3 = result3.substring(0,40)+"...";
                break;
            }
        }
        return str3+result3+str3;
    }
    public static String division(String div1, String div2) throws Exception {
        if (div1.contains("\"")) {
            div1 = div1.replace("\"", "");
        }else {
            throw new Exception("Первым агрументом должна быть строка в ковычках!");
        }
        for (int i = 0; i < div1.length(); i++) {
            if (div1.length() > 10){
                throw new Exception("Длина каждой строки должна быть не больше или равной 10 символам!");
            }
        }
        String str4 = "\"";
        int div3 = Integer.parseInt(div2);
        if (div3 > 10 | div3 <= 0){
            throw new Exception("Работать можно только с числами от 1 до 10 включительно!");
        }
            int length = div1.length()/div3;
            String result4 = div1.substring(0, length);
            return str4+result4+str4;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строковое выражение, калькулятор умеет складывать строки, вычитать, умножать и делить" +
                ", ввод должен быть таким, например, \"Hello\" + \"World\" или \"Hello\" * 4 и т.д");
        String vvod = sc.nextLine().replace(" ","");
        String [] operation = {"+","-","*","/"};
        String [] regexOperation = {"\\+","-","\\*","/"};
        int operationIndex = -1;
        for (int i = 0; i < operation.length; i++) {
            if (vvod.contains(operation[i])){
                operationIndex = i;
                break;
            }
        }
        if (operationIndex == -1) {
            throw new Exception("Такой операции не существует");
        }

        String [] data = vvod.split(regexOperation[operationIndex]);
        if (data.length > 2){
            throw new Exception("Должно быть не более одной операции!");
        }
        String a = data[0];
        String b = data[1];


        if (operation[operationIndex] == "*" || operation[operationIndex] == "/"){
            if (data[1].contains("\"")) {
                throw new Exception("Строку можно умножать или делить только на числа! Исправьте на \"какая-то строка\" *(/) число!");
            }
        }
        switch (operation[operationIndex]) {
            case "+" -> System.out.println(sum(a, b));
            case "-" -> System.out.println(subtract(a, b));
            case "*" -> System.out.println(multiply(a, b));
            case "/" -> System.out.println(division(a, b));
        }
    }
}







