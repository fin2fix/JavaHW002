/*Задание №1
В файле содержится строка с исходными данными в такой форме:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
*/

package DZ02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class s2dz01 {

  public static void main(String[] args) {
    String textFromFile = "";
    try (BufferedReader reader = new BufferedReader(new FileReader("data1.txt"))) {
      textFromFile = reader.readLine();
    } catch (IOException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    String textList = textFromFile.replace(":", ",").replace('\"', ' ').substring(1, textFromFile.length() - 2);
    String[] data = textList.split(",");

    StringBuilder list = new StringBuilder();
    list.append("SELECT * FROM students WHERE name = ");

    for (int i = 0; i < data.length - 1; i = i + 2) {
      data[i] = data[i].trim();
      data[i + 1] = data[i + 1].trim();

      if (data[i].equals("name") && !data[i + 1].equals("null")) {
        list.append('\"');
        list.append(data[i + 1]);
        list.append("\" AND country = ");
      }
      if (data[i].equals("country") && !data[i + 1].equals("null")) {
        list.append('\"');
        list.append(data[i + 1]);
        list.append("\" AND city = ");
      }
      if (data[i].equals("city") && !data[i + 1].equals("null")) {
        list.append('\"');
        list.append(data[i + 1]);
        list.append("\"");
      }
    }
    System.out.println();
    System.out.println(list);
  }
}