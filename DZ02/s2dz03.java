/*
 * Задание 3.* В файле содержится строка с данными:
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}; {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}; {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */

package DZ02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class s2dz03 {

  public static void main(String[] args) {
    String textFromFile = "";
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream("data3task.txt"), "UTF-8"))) {
      textFromFile = reader.readLine();
    } catch (IOException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    String textList = textFromFile.replace(":", ",").replace('\"', ' ');
    String[] data = textList.split(";");

    StringBuilder list = new StringBuilder();

    for (String text : data) {
      String[] result = text.substring(2, text.length() - 2).split(",");

      for (int i = 0; i < result.length - 1; i = i + 2) {
        result[i] = result[i].trim();
        result[i + 1] = result[i + 1].trim();

        if (result[i].equals("фамилия") && !result[i + 1].equals("null")) {
          list.append("Студент ");
          list.append(result[i + 1]);
        }
        if (result[i].equals("оценка") && !result[i + 1].equals("null")) {
          list.append(" получил ");
          list.append(result[i + 1]);
        }
        if (result[i].equals("предмет") && !result[i + 1].equals("null")) {
          list.append(" по предмету ");
          list.append(result[i + 1]);
          list.append(".\n");
        }
      }
    }
    System.out.println();
    System.out.println(list);
  }
}