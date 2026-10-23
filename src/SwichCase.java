import java.util.Scanner;

public class SwichCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        switch (month) {
            case "Январь":
            case "Апрель":
            case "Июль":
            case "Август":
            case "Октябрь":
            case "Декабрь":
                System.out.println(31);
                break;
            case "Февраль":
                System.out.println(29);
                break;
            case "Март":
            case "Май":
            case "Июнь":
            case "Сентябрь":
            case "Ноябрь":
                System.out.println(30);
                break;
            default:
                System.out.println("Ты не знаешь месяцы?");
        }
    }
}
/*Scanner scanner = new Scanner(System.in);
String answer = scanner.nextLine();
System.out.println("Ваш ответ:\t" + answer);
System.out.println("Количество жизней: " + personLive + " " + person);*/
