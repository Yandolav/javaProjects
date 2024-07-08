import java.io.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        String path = args[0];
        String[] mas = args[1].split("\\.");
        LocalDate date = LocalDate.of(Integer.parseInt(mas[2]), Integer.parseInt(mas[1]), Integer.parseInt(mas[0]));
        long result = 0;
        try(FileReader in = new FileReader(path)) {
            int i;
            StringBuilder str = new StringBuilder();
            while( (i = in.read()) != -1) {
                if(i != ' ' && i != ',') {
                    str.append((char)i);
                }
                else {
                    if(str.length() == 10 && str.charAt(2) == '.' && str.charAt(5) == '.') {
                        if(str.charAt(8) != ';' && str.charAt(8) != '(') {
                            String a = str.toString();
                            String[] arr = a.split("\\.");
                            LocalDate twoDate = LocalDate.of(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
                            if (date.getYear() == twoDate.getYear() && date.getMonth() == twoDate.getMonth() && date.getDayOfMonth() == twoDate.getDayOfMonth()) {
                                result++;
                            }
                        }
                    }
                    str.delete(0, str.length());
                }
            }

        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Дата: " + date + " Ограничения: " + result);

    }
}