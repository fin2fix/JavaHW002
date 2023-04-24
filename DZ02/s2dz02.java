/* Задание №2
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */

package DZ02;

import java.util.logging.*;
import java.io.IOException;
import java.util.Arrays;

public class s2dz02 {
  public static void main(String[] args) throws SecurityException, IOException {
    Logger logger = Logger.getLogger(s2dz02.class.getName());
    FileHandler fh = new FileHandler("logBubble.txt");
    logger.addHandler(fh);
    SimpleFormatter txt = new SimpleFormatter();
    fh.setFormatter(txt);
    fh.setEncoding("UTF-8");

    int[] numbers = { 1, 15, 3, 22, 2, 45, 10 };
    int temp = 0;

    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers.length - 1 - i; j++) {
        if (numbers[j] > numbers[j + 1]) {
          temp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = temp;
        }
        logger.info(Arrays.toString(numbers));
      }
    }
    System.out.println();
    System.out.println(Arrays.toString(numbers));
  }
}