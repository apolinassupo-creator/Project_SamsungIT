public class Perement {
        public static void main(String[] args) {
            int x = 5;
            int y = 10;
            int z = 15;
            int lala = 53;
            int id = 6;
            if (id == 1 && id==6) {
                System.out.println("Проходите! Директор");
            } else if (id == 6) {
                System.out.println("Ну вам можно, Менеджер");
            } else {
                System.out.println("Пошёл вон!");
            }
            String answer = (id==6 || id ==1) ? "Разрешено" : "Запрещено";
            System.out.println(answer);
        }

}

