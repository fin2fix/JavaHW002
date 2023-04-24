/* Задание №4
 *  К калькулятору из предыдущего дз добавить логирование.
 */

package DZ02;

import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

public class s2dz04 {
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(s2dz02.class.getName());
        FileHandler fh = new FileHandler("logCalc.txt");
        logger.addHandler(fh);
        SimpleFormatter txt = new SimpleFormatter();
        fh.setFormatter(txt);
        fh.setEncoding("UTF-8");

        Scanner scanner = new Scanner(System.in, "866");
        boolean flag = true;
        double number_1 = 0;
        double number_2 = 0;

        while (flag) {
            try {
                System.out.print("Введите первое число:   ");
                number_1 = Double.parseDouble(scanner.nextLine());
                flag = false;
            } catch (Exception e) {
                System.out.println("Введено неверное число или не число. Повторите ввод! ");
            }
        }

        System.out.print("Введите действие (+) (-) (*) (/):   ");
        String str = scanner.nextLine().replace(" ", "");
        char action = str.charAt(0);

        flag = true;
        while (flag) {
            try {
                System.out.print("Введите второе число:   ");
                number_2 = Double.parseDouble(scanner.nextLine());
                flag = false;
            } catch (Exception e) {
                System.out.println("Введено неверное число или не число. Повторите ввод! ");
            }
        }

        double result = 0;
        scanner.close();

        if (action == '+') {
            result = number_1 + number_2;
            System.out.printf("Ответ: %.3f \n", result);
        } else if (action == '-') {
            result = number_1 - number_2;
            System.out.printf("Ответ: %.3f \n", result);
        } else if (action == '*') {
            result = number_1 * number_2;
            System.out.printf("Ответ: %.3f \n", result);
        } else if (action == '/' && number_2 != 0) {
            result = number_1 / number_2;
            System.out.printf("Ответ: %.3f \n", result);
        } else
            System.out.println("Неверная операция!");

        System.out.println();
        logger.info("Введена первая цифра = " + Double.toString(number_1));
        logger.info("Введено действие  " + action);
        logger.info("Введена вторая цифра = " + Double.toString(number_2));
        logger.info("Получен результат  = " + Double.toString(result));
    }
}