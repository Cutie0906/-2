import java.util.*;

public class tas4 {
    public static void main(String[] args) {
        System.out.println(splitter(5, 7, "hello world bus out ok"));
        System.out.println(Arrays.toString(split("()()()")));
        System.out.println(toCamelCase("bus_tass"));
        System.out.println(toSnakeCase("busTass"));
        System.out.println(overTime(new double[] {9,17,30,1.5}));
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(bugger(39));
        System.out.println(toStarShorthand("777777geff"));
        System.out.println(doesRhyme("Sam I jam!", "Green eggs and ham."));
        System.out.println(trouble(1222345,12345));
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
    }

//1. Бесси работает над сочинением для своего класса писателей. Поскольку ее почерк довольно плох, она решает напечатать эссе с помощью текстового процессора. Эссе содержит N слов (1≤N≤100), разделенных пробелами. Каждое слово имеет длину от 1 до 15 символов включительно и состоит только из прописных или строчных букв. Согласно инструкции к заданию, эссе должно быть отформатировано очень специфическим образом: каждая строка должна содержать не более K (1≤K≤80) символов, не считая пробелов. К счастью, текстовый процессор Бесси может справиться с этим требованием, используя следующую стратегию:
//– Если Бесси набирает Слово, и это слово может поместиться в текущей строке, поместите его в эту строку. В противном случае поместите слово на следующую строку и продолжайте добавлять к этой строке. Конечно, последовательные слова в одной строке все равно должны быть разделены одним пробелом. В конце любой строки не должно быть места.
//–	К сожалению, текстовый процессор Бесси только что сломался. Пожалуйста, помогите ей правильно оформить свое эссе!
    
    public static String splitter(int n, int k,String string){
        String[] words = string.split(" ");
        String curStr = "";
        String result = "";

        if (n > words.length) return "Wrong esse!";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (curStr.replace(" ","").length()+ word.length() <=k)
                curStr+=word + " ";
            else{
                result +=curStr+"\n";
                curStr=word+" ";
            }
        }if (curStr.length() > 0) {
            result += curStr + "\n";
        }
        return result;
    }

//2. Напишите функцию, которая группирует строку в кластер скобок. Каждый кластер должен быть сбалансирован. 

    public static String[] split(String string){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            int pS = 0;
            int pE = 0;
            int countX = 0;
            int countY = 0;
            if (string.charAt(i) == '('){
                pS=i;
                countX++;
                i++;
                while (i < string.length() && countX-countY != 0){
                    if (string.charAt(i) == '(') countX++;
                    else if (string.charAt(i) == ')') countY++;
                    i++;
                }

                pE = i;
                list.add(string.substring(pS,pE));
                i--;
            }
        }
        String[] strings = new String[list.size()];
        return strings=list.toArray(strings);
    }

//3. Создайте две функции toCamelCase () и toSnakeCase (), каждая из которых берет одну строку и преобразует ее либо в camelCase, либо в snake_case. 

    public static String toCamelCase(String string){
        String[] words = string.split("_");
        String result = words[0];
        for (int i = 1; i < words.length; i++) {
            result+=words[i].substring(0,1).toUpperCase()+words[i].substring(1);
        }
        return result;
    }
//3. Создайте две функции toCamelCase () и toSnakeCase (), каждая из которых берет одну строку и преобразует ее либо в camelCase, либо в snake_case. 

    public static String toSnakeCase(String string){
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                result +="_"+string.toLowerCase().charAt(i);
            }
            else result+=string.charAt(i);
        }
        return result;
    }

//4. Напишите функцию, которая вычисляет сверхурочную работу и оплату, связанную с сверхурочной работой.

    public static String overTime(double[] arr){
        double sum = 0;
        for (double i = arr[0]; i < arr[1]; i+=0.25) {
            if (i>17) {sum+=0.25*arr[2]*arr[3];}
            else sum+=0.25*arr[2];
        }
        return String.format("$%.2f",sum);
    }
//5. Индекс массы тела (ИМТ) определяется путем измерения вашего веса в килограммах и деления на квадрат вашего роста в метрах. Категории ИМТ таковы:

    public static String BMI (String weight,String height){
        String[] weig = weight.split(" ");
        String[] heig = height.split(" ");
        String result = "";
        double kilos = weig[1].equals("pounds") ? Double.parseDouble(weig[0]) * 0.453592 : Double.parseDouble(weig[0]);
        double meters = heig[1].equals("inches") ? Double.parseDouble(heig[0]) * 0.0254 : Double.parseDouble(heig[0]);
        double val = kilos / (meters * meters);
        val = Math.round(val * 10.0) / 10.0;
        if (val < 18.5) result += val + " Underweight";
        if (val >= 18.5 && val <= 24.5) result += val + " Normal weight";
        if (val >= 25 && val <= 29.9) result += val + " Overweight";
        if (val >= 30) result += val + " Obesity";
        return result;
    }
//6. Создайте функцию, которая принимает число и возвращает его мультипликативное постоянство, которое представляет собой количество раз, которое вы должны умножать цифры в num, пока не достигнете одной цифры.    

    public static int bugger(int n){
       int result = 0;
       while (Integer.toString(n).length() > 1){
           int param = n;
           n=1;
           while(param>0) {
               n *=param%10;
               param = param / 10;
           }
           result++;
       }
       return result;
    }
//7. Напишите функцию, которая преобразует строку в звездную стенографию. Если символ повторяется n раз, преобразуйте его в символ*n.  
    
    public static String toStarShorthand(String string){
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        String result = "";
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (!strings.contains(Character.toString(string.charAt(i)))) {
                strings.add(count,Character.toString(string.charAt(i)));
                numbers.add(count,1);
                for(int j = i+1; j < string.length();j++) {
                    if (string.charAt(j) == string.charAt(i)) {
                        numbers.add(count,numbers.get(count)+1);
                    }
                }
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
           if (numbers.get(i)==1){
               result +=strings.get(i)+"*";
           }
           else if (strings.get(i).matches("[0-9]+")){
               result +="("+numbers.get(i)+"*"+strings.get(i)+")*";
           }
           else result +=numbers.get(i)+strings.get(i)+"*";
        }
        return result.substring(0,result.length()-1);
    }
//8. Создайте функцию, которая возвращает true, если две строки рифмуются, и false в противном случае. Для целей этого упражнения две строки рифмуются, если последнее слово из каждого предложения содержит одни и те же гласные.
    
    public static boolean doesRhyme(String firstString, String secondString){
        String firstLastWord = firstString.substring(firstString.lastIndexOf(" ")+1);
        String secondLastWord = secondString.substring(secondString.lastIndexOf(" ")+1);
        int jCount = 0;
        int fNum = 0, sNum=0;
        for (int i = 0; i < firstLastWord.length(); i++) {
            if (Character.toString(firstLastWord.charAt(i)).matches("[AIOUEYaiouey]")){
                fNum++;
                for (int j = jCount; j < secondLastWord.length(); j++) {
                    jCount++;
                    if (Character.toString(secondLastWord.charAt(j)).matches("[AIOUEYaiouey]")){
                        if (secondLastWord.charAt(j) == firstLastWord.charAt(i)){
                            sNum++;
                            break;
                        }
                    }
                }
            }

        }
         if (sNum==fNum){
             return true;
         }
         else{
             return false;
         }
    }
//9. Создайте функцию, которая принимает два целых числа и возвращает true, если число повторяется три раза подряд в любом месте в num1 и то же самое число повторяется два раза подряд в num2. 
    public static boolean trouble(int num1, int num2){
        String numberOne = Integer.toString(num1);
        String numberTwo = Integer.toString(num2);
        for (int i = 0; i < numberOne.length()-2; i++) {
            if (numberOne.charAt(i)==numberOne.charAt(i+1) && numberOne.charAt(i)==numberOne.charAt(i+2)){
                for (int j = 0; j < numberTwo.length()-1; j++) {
                    if (numberOne.charAt(i)==numberTwo.charAt(j) && numberOne.charAt(i)==numberTwo.charAt(j+1)){
                        return true;
                    }
                }
            }
        }
        return  false;
    }
//10.	Предположим, что пара одинаковых символов служит концами книги для всех символов между ними. Напишите функцию, которая возвращает общее количество уникальных символов (книг, так сказать) между всеми парами концов книги.
    public static int countUniqueBooks(String books, char divider){
        int result=0;
        for (int i = 0; i < books.length(); i++) {
            if ( books.charAt(i) == divider){
                ArrayList<Character> uniqueSymbol = new ArrayList();
                int j = i+1;
                while(j < books.length() && books.charAt(j) != divider){
                    if (!uniqueSymbol.contains(books.charAt(j))){
                        uniqueSymbol.add(books.charAt(j));
                    }
                    j++;
                }
                i = j;
                result+=uniqueSymbol.size();
            }
        }
        return result;
    }
}
