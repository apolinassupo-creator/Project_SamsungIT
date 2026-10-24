import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

public class MonsterSmall {
    private String monster1 = "\uD83E\uDDDF";
    private int x, y;
    Random random = new Random();
    protected int sizeBoard; // Поле для хранения размера

    // Добавьте этот конструктор:
    public MonsterSmall(int sizeBoard) {
        this.sizeBoard = sizeBoard;
        Random random = new Random();
        x = 1 + random.nextInt(sizeBoard);
        y = 1 + random.nextInt(sizeBoard - 1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getMonster() {
        return monster1;
    }

    public void setMonster(String image) {
        this.monster1 = image;
    }

    public boolean conflictPerson(int personX, int personY) {
        return personX == x && personY == y;
    }
    public boolean  tastFromM(int difficultGame) {
        if (difficultGame == 1) {

            int question = random.nextInt(10);
            int questions = random.nextInt(10);
            System.out.println("Решите задачу:" + question + "*" + questions + "= ");

            Scanner the = new Scanner(System.in);
            int use_answer = the.nextInt();
            if (use_answer == question * questions) {
                System.out.println("Правильно! Но это было легко");
                return true;
            }
            else {
                System.out.println("Серьёзно? Ты даже с этим не справился, калькулятор возьми, гений");
                return false;

            }

        }

        else if (difficultGame == 2) {
            int question = random.nextInt(1000);
            int questions = random.nextInt(1, 10);
            System.out.println("Решите задачу(запиши только целую часть):" + question + "//" + questions + "= ");

            Scanner the = new Scanner(System.in);
            int use_answer = the.nextInt();
            if (use_answer == question / questions) {
                System.out.println("Правильно! Но это было легко");
                return true;
            } else {
                System.out.println("Серьёзно? Ты даже с этим не справился, калькулятор возьми, гений");
                return false;

            }
        }
        else if (difficultGame == 3) {
            int question = random.nextInt(2);
            int questions = random.nextInt(3);
            System.out.println("Решите задачу:" + question + "**" + questions + "= ");

            Scanner the = new Scanner(System.in);
            int use_answer = the.nextInt();
            if (use_answer == Math.pow(question,questions)) {
                System.out.println("Правильно! Но это было легко");
                return true;
            } else {
                System.out.println("Серьёзно? Ты даже с этим не справился, калькулятор возьми, гений");
                return false;

            }
        }
        else if (difficultGame == 4) {
            int question = random.nextInt(10);
            int questions = random.nextInt(7);
            System.out.println("Решите задачу:" + "("+question +"+"+ questions +")"+ "-"+ "("+question +"*"+ questions+")"+"= ");

            Scanner the = new Scanner(System.in);
            int use_answer = the.nextInt();
            if (use_answer == (questions+question)-(questions*question)) {
                System.out.println("Правильно! Но это было легко");
                return true;
            } else {
                System.out.println("Серьёзно? Ты даже с этим не справился, калькулятор возьми, гений");
                return false;

            }
        }
        else if (difficultGame == 5) {
            int questionx = random.nextInt(10);
            int questiony = random.nextInt(7);
            int num= random.nextInt(10);
            System.out.println("Решите задачу:" + "("+questionx + "**"+ "2"+")" + "+" + "2" +"*"+ questiony + "+" + num + "= ");

            Scanner the = new Scanner(System.in);
            int use_answer = the.nextInt();
            if (use_answer == Math.pow(questionx,2)+(2*questiony)+num) {
                System.out.println("Правильно! Но это было легко"+ "\uD83D\uDE34");
                return true;
            } else {
                System.out.println("Серьёзно? Ты даже с этим не справился, калькулятор возьми, гений");
                return false;

            }

        }
        else {
            return false;
        }
    }

    public boolean testFromM(int difficultGame) {
        return false;
    }

}
