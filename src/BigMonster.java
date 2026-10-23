import java.util.ArrayList;
import java.util.Scanner;

public class BigMonster extends MonsterSmall {
    BigMonster(int sizeBoard) {
        super(sizeBoard);
        setMonster("\uD83D\uDC79");
    }

    @Override
    public boolean tastFromM(int difficultGame) {
        int x = random.nextInt(16);
        int y = random.nextInt(60);
        int z = random.nextInt(69);
        if (difficultGame == 1) {
            return testFromM();
        }
        else if (difficultGame == 2) {
            int trueAnswer = x * y - z;
            System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");

            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Верно! Но ты выбрал уровень два. Думаю ты согласишься со мной, что это задачка для детсадовца.");
                return true;
            } else {
                System.out.println("Ты проиграл!? Ладно, не ожидал от тебя");
                System.out.println(trueAnswer);
                return false;
            }
        }
        else if (difficultGame == 3) {
            String trueAnswer = Integer.toBinaryString(z);

            System.out.println("Переведите число: " + z + " в двоичную систему счисления");

            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();

            if (answer.equals(trueAnswer)) {
                System.out.println("Верно! А ты не плох. Ну ты меня удивишь если ответишь на уровне 5");
                return true;
            } else {
                System.out.println(trueAnswer);
                System.out.println("Ты проиграл! Поробуй ещё раз, может повезёт");
                return false;
            }
        }
        else if (difficultGame == 4) {


            System.out.println("Сначало вспомни чему равно число " + "пи, а затем вычесли длину окружности с радиусом "+x);
            float x1=x;
            Scanner scanner = new Scanner(System.in);
            float answer = scanner.nextFloat();
            float trueAnswer = Math.round(3.14f * 2.0f * x1 * 100) / 100.0f;

            if (answer==trueAnswer) {
                System.out.println("Верно! Я тебя могу поздравить.");
                return true;
            } else {
                System.out.println("Ты проиграл! Ничего страшного, у тебя есть калькулятор, интеренет, дерзай!");
                System.out.println(trueAnswer);
                return false;
            }
        }
        else if (difficultGame == 5) {

            int x1 = random.nextInt(5);
            int y1 = random.nextInt(6);
            int z1 = random.nextInt(9);
            System.out.println("Какова вероятность того, что из суммки достанут синий карандаша, если всего "+ z1 + " зелёных "+ x1 + " синих " + y1 +" красных. Ответ округлите до десятых");

            double trueAnswer = Math.round((double) x1 / (x1 + y1 + z1) * 10) / 10.0;
            Scanner scanner = new Scanner(System.in);
            float answer = scanner.nextFloat();


            if (answer==trueAnswer) {
                System.out.println("Верно! Я тебя могу поздравить.");
                return true;
            } else {
                System.out.println("Ты проиграл! Ничего страшного, у тебя есть калькулятор, интеренет, дерзай!");
                System.out.println(trueAnswer);
                return false;
            }
        }
        else {
            return false;
        }
    }
    public boolean testFromM(){
        return super.tastFromM(1);
    }

}
