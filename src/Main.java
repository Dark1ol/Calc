import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        try {
            String[] mass = input.split(" ");// разбивает строку в массив по знаку помещенному в скобку
            if (mass.length > 3) {
                throw new Exception("Необходимо ввести операцию, состоящую только из 2х чисел и одного знака");
            }
            int result = 0;
            String znak = (mass[1]);
            String a1 = null;
            String a2 = null;
            int chs1 = 0;
            int chs2 = 0;
            for (int i = 0; i < 10; i++) {
                if (mass[0].equalsIgnoreCase(String.valueOf(Rome.values()[i]))) {
                    a1 = mass[0];
                    chs1 = ++i;
                }
            }
            for (int i = 0; i < 10; i++) {
                if (mass[2].equalsIgnoreCase(String.valueOf(Rome.values()[i]))) {
                    a2 = mass[2];
                    chs2 = ++i;
                }
            }
            if (a1 == null || a2 == null) {
                chs1 = Integer.parseInt(mass[0]);// преобразовывает строку в целое число
                chs2 = Integer.parseInt(mass[2]);
            }
            if (chs1 > 0 && chs1 < 11 && chs2 > 0 && chs2 < 11) {

                switch (znak) {
                    case "+":
                        result = chs1 + chs2;
                        break;
                    case "-":
                        result = chs1 - chs2;
                        break;
                    case "*":
                        result = chs1 * chs2;
                        break;
                    case "/":
                        result = chs1 / chs2;
                        break;
                    case "%":
                        throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
                if (a1 == null || a2 == null) {
                    return Integer.toString(result);
                } else {
                    return String.valueOf(Rome.values()[result - 1]);//выводит в римском формате
                }
            } else {
                throw new Exception("Необходимо ввести числа от 1 до 10");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Необходимо ввести значения через пробел(пр. 1 + 1); Римские числа не могут быть отрицательными");
        } catch (NumberFormatException e) {
            throw new Exception("Введите целые числа, только римские, или только английские");
        }
    }
}