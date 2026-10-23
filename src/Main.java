import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int sizeBoard = 5;
        String castle = "\uD83C\uDFF0";

        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
        String[][] board = new String[sizeBoard][sizeBoard];
        MonsterSmall[] monsterPlay = new MonsterSmall[countMonster];
        int count=0;

        int step = 0;


        //Создаём замок
        Random random = new Random();
        int castleX = 1 + random.nextInt(5);
        int castleY = 1;

        //Создаём перса
        Person person = new Person(sizeBoard);

        //Создаём монстра
        while (count < countMonster) {
            MonsterSmall monster;

            if (random.nextBoolean()) {
                monster = new MonsterSmall(sizeBoard);
            }
            else {
                monster= new BigMonster(sizeBoard);
            }

            int row = monster.getY() - 1;
            int column = monster.getX() - 1;

            if (board[row][column]== null || board[row][column].equals("  ")) {
                board[row][column] = monster.getMonster();
                monsterPlay[count] = monster;
                count++;
            }

        }



        //Замок
        board[castleY - 1][castleX - 1] = castle;


        // Соглашается играть
        System.out.println("Здорова! Добро пожаловать в игру! Ты готов играть?(ДА или НЕТ)");
        Scanner an = new Scanner(System.in);
        String answer = an.nextLine();

        switch (answer) {
            case "ДА":
            case "да":
            case "Да":
                // Выбираем сложность
                System.out.println("Выбери сложность игры (от 1 до 5):");
                Scanner un = new Scanner(System.in);
                int difficultGame = un.nextInt();
                System.out.println("Выбранная сложность:\t" + difficultGame);
                // Перемещаем игрока
                while (true) {
                    board[person.getY() - 1][person.getX() - 1] = person.getImage();

                    outputBoard(board, person.getLive());

                    // куда ходим
                    Scanner scannery = new Scanner(System.in);
                    Scanner scannerx = new Scanner(System.in);
                    System.out.println("Напиши(x) куда ты хочешь переместить нашего героя? (двигаться можно только на одну клетку)");
                    int x = scannerx.nextInt();
                    System.out.println("Напиши(y) куда ты хочешь переместить нашего героя? (двигаться можно только на одну клетку)");
                    int y = scannery.nextInt();


                    if (x == person.getX() && y == person.getY()) {
                        System.out.println("Координаты не изменены");
                    }
                    // Вводит новые координаты
                    else if (person.isMoveCorrect(x,y)) {

                       if (board[y - 1][x - 1]==null || board[y - 1][x - 1].equals("  ")) {
                           board[person.getY() - 1][person.getX() - 1] = "  ";
                            person.move(x,y);
                            step ++;

                            System.out.println("Ход корректный; новые координаты: " + person.getX() + ", " + person.getY() + "\nХод номер: " + step);
                       }

                       else if (board[y - 1][x - 1].equals(castle)) {
                            System.out.print("Вы прошли игру!!! "+"\uD83D\uDE0D "+" \uD83E\uDD70 "+" \uD83E\uDD73");
                            break;
                       }
                       else {
                            System.out.println("Решите задачу:");
                           for (MonsterSmall monster : monsterPlay) {
                               if (monster.conflictPerson(x, y)) {
                                   if (monster.tastFromM(difficultGame)) {
                                       board[person.getY() - 1][person.getX() - 1] = "  ";
                                       person.move(x, y);
                                       step++;
                                   } else {
                                       person.downLive();
                                   }
                                   break;
                               }
                           }
                       }
                    }
                    else {
                        System.out.println("Некоректный ввод");
                    }

                    if (person.getLive() == 0) {
                        System.out.println("Слушай, я сегодня добрая, поэтому, даю тебе второй шанс, смотри не провались" + "\nЗагатка: без рук, без ног, а ворота отворяет");
                        Scanner tha = new Scanner(System.in);
                        String youAnswer = tha.nextLine();

                        String trueAnswer = "Ветер";
                        if (trueAnswer.equals(youAnswer)) {
                            System.out.println("Ладно, ты не безнодёжен");
                        } else {
                            System.out.println("Приходи в другой раз, дружище");
                        }
                    }
                    if (person.getLive() < 0) {
                        System.out.println("Закончились жизни. Ты лох " +"\uD83D\uDE1D");
                        break;
                    }
                }
                if (person.getLive() < 0) {
                    System.out.println("Закончились жизни. Ты лох");
                    break;
                }


            case "Нет":
            case "НЕТ":
            case "нет":
                break;
        }
    }

    static void outputBoard(String[][] board, int live) {
        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";
        for (String[] row : board) {
            System.out.println(wall);
            for (String cell : row) {
                System.out.print(leftBlock);
                cell = Objects.requireNonNullElse(cell, "  ");
                System.out.print(cell);

            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);
        System.out.println("Количество жизней:\t" + live + "\n");
    }
}



