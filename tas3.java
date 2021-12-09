public class tas3{
    public static void main(String[] args){
        int[] mass1 = {1,3,4,4,4};
        int[] mass2 = {2,5,7};
        System.out.println(solutions(1, 0, -1));
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(solutions(496));
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(same(mass1, mass2));
        System.out.println(isKaprekar(2));
        System.out.println(rightTriangle(145, 105, 100));
    
    }
    //Квадратное уравнение ax2 + bx + c = 0 имеет либо 0, либо 1, либо 2 различных решения для действительных значений x. учитывая a, b и c, вы должны вернуть число решений в уравнение. 
    public static int solutions(int x1, int x2, int x3){
        int disk = 0;
        disk = x2 * x2 - 4 * x1 * x3;
        if (disk > 0) {
            return 2;
        }
        else if (disk == 0) {
            return 1;
        }
        else return 0;
    }

    //Напишите функцию, которая возвращает позицию второго вхождения " zip " в строку, или -1, если оно не происходит по крайней мере дважды. 
    public static int findZip(String zip_string){
        String[] zip_mas = zip_string.split("zip");
        if (zip_mas.length == 3) {
            int count = 3; 
            String one = "";            
            String two = "";
            one = zip_mas[0];
            two = zip_mas[1];
            count += one.length() + two.length();
            return count;
        }
        else return -1;
    }
    //Создайте функцию, которая проверяет, является ли целое число совершенным числом или нет. 
    public static boolean solutions(int var){
        int sum = 0; 
        for (int i = 1; i < var; i++){
            if (var % i == 0){
                sum += i;
            }
        }
        return sum == var;
    }
    //Создайте функцию, которая принимает строку и возвращает новую строку с заменой ее первого и последнего символов
    public static String flipEndChars(String str){
        char one_char ; 
        char two_char ;
        if (str.length() > 1){
            one_char = str.charAt(0);
            two_char = str.charAt(str.length()-1);
            if (one_char == two_char){
                return "Two's a pair.";
            }
            else {
                return two_char + str.substring(1, str.length()-1) + one_char;
            }
        }
        else {
            return "Incompatible.";
        }
    }
    //Создайте функцию, которая определяет, является ли строка допустимым шестнадцатеричным кодом
    public static boolean isValidHexCode(String HEX){
        try{
            if (HEX.charAt(0) == '#'){
                HEX = HEX.substring(1, HEX.length());
                if (HEX.length() == 6){
                    int valid = Integer.parseInt(HEX, 16);
                    return true;
                }
                else return false;
            }
            else return false;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    //Напишите функцию, которая возвращает true, если два массива имеют одинаковое количество уникальных элементов, и false в противном случае
    public static boolean same(int[] mass1, int[] mass2){
        int len_mass1 = mass1.length;
        int len_mass2 = mass2.length;
        for (int a = 0; a < mass1.length; a++){
            for (int i = a + 1; i < mass1.length; i++){
                if (mass1[a] == mass1[i]) {
                    len_mass1--;
                    break;
                }
            }
        }
        for (int a = 0; a < mass2.length; a++){
            for (int i = a + 1; i < mass2.length; i++){
                if (mass2[a] == mass2[i]) {
                    len_mass2--;
                    break;
                }
            }
        }
        if (len_mass1 == len_mass2) return true;
        else return false;
    }
    //Число Капрекара-это положительное целое число, которое после возведения в квадрат и разбиения на две лексикографические части равно сумме двух полученных новых чисел
    public static boolean isKaprekar(int var) {
        int square = 0;
        int temp = 0;
        int countDigits = 0;
        int firstPart = 0;
        int secondPart = 0;
        int sum = 0;
        square = var * var;
        temp = square;
        while(temp != 0) {
        countDigits++;
        temp /= 10;
        }
        
        for(int i = countDigits - 1; i > 0; i--) {
        firstPart = square / (int)Math.pow(10, i);
        secondPart = square % (int)Math.pow(10, i);
        
        if(firstPart == 0 || secondPart == 0) {
        continue;
        }
        
        sum = firstPart + secondPart;
        if( sum == var )
        return true;
        }
        
        return false;
        }
    //Учитывая три числа, x, y и z, определите, являются ли они ребрами прямоугольного треугольника. 
    public static boolean rightTriangle(int a, int b, int c ){
        if (Math.pow(a,2) == Math.pow(b,2) + Math.pow(c,2) || Math.pow(b,2) == Math.pow(a,2) + Math.pow(c,2) || Math.pow(c,2) == Math.pow(a,2) + Math.pow(b,2)){
            return true;
        }
        else{
            return false;
        }
    }
    


}
