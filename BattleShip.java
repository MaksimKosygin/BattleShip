import java.util.Scanner;

public class BattleShip {
    static String playerName1 = "P1";
    static String playerName2 = "P2";
    static Scanner scanner = new Scanner(System.in);
    static int[][] battlefield1 = new int[10][10];
    static int[][] battlefield2 = new int[10][10];
    static int[][] monitor1 = new int[10][10];
    static int[][] monitor2 = new int[10][10];

    public static void main(String[] args) {

        System.out.println("Player#1, please enter your name: ");
        playerName1 = scanner.nextLine();
        System.out.println("Player#2, please enter your name: ");
        playerName2 = scanner.nextLine();

        placeShips(playerName1, battlefield1);
        placeShips(playerName2, battlefield2);
        do {
            makeTurn(playerName1, monitor1, battlefield2);
            makeTurn(playerName2, monitor2, battlefield1);
        } while (!isWinCondition());

    }

    public static void placeShips(String playerName, int[][] battlefield) {
        int deck = 4;
        while (deck >= 1) {
            drawField(battlefield);

            System.out.println(playerName + ", please choose place your " + deck + "-deck ships on the battlefield");


            System.out.println("Please enter OX coordinate");
            int x = scanner.nextInt() - 1;
            System.out.println("Please enter OY coordinate");
            int y = scanner.nextInt() - 1;
            System.out.println("Choose direction: ");
            System.out.println("1. Vertical");
            System.out.println("2. Horizontal");
            int direction = scanner.nextInt();


            for (int i = 0; i < deck; i++) {
                if (direction == 1) {
                    battlefield[x][y + i] = 1;
                } else {
                    battlefield[x + i][y] = 1;
                }
            }

            battlefield[x][y] = 1; // need?
            deck--;
        }
    }

    public static void drawField(int[][] battlefield) {
        System.out.println("   А Б В Г Д Е Ж З И К");
        for (int i = 0; i < battlefield.length; i++) {
            if (i < 9) {
                System.out.print(i + 1 + "  ");
            } else {
                System.out.print(i + 1 + " ");
            }
            for (int j = 0; j < battlefield[0].length; j++) {
                if (battlefield[j][i] == 0) {                           // инверсия матрицы?? поменяли местами  i j для корректной работы.
                    System.out.print("- ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }

    }

    public static void makeTurn(String playerName, int[][] monitor, int[][] battlefield) {
        while (true) {
            System.out.println(playerName + ", please make your turn.");
            System.out.println("   А Б В Г Д Е Ж З И К");
            for (int i = 0; i < monitor.length; i++) {
                if (i < 9) {
                    System.out.print(i + 1 + "  ");
                } else {
                    System.out.print(i + 1 + " ");
                }
                for (int j = 0; j < monitor[1].length; j++) {
                    if (monitor[j][i] == 0) {                           // инверсия матрицы?? поменяли местами  i j для корректной работы.
                        System.out.print("- ");
                    } else if (monitor[j][i] == 1) {
                        System.out.print(". ");
                    } else {
                        System.out.print("X ");
                                           }
                }
                System.out.println();
            }
            System.out.println("Please enter OX coordinate");
            int x = scanner.nextInt() - 1;
            System.out.println("Please enter OY coordinate");
            int y = scanner.nextInt() - 1;

            if (battlefield[x][y] == 1) {
                System.out.println("Hit! Make your turn again");
                monitor[x][y] = 2;
            } else {
                System.out.println("Miss! Your opponent turn!");
                monitor[x][y] = 1;
                break;
            }
        }
    }

    public static boolean isWinCondition(){
        int counter1 = 0;
        for (int i = 0; i < monitor1.length ; i++) {
            for (int j = 0; j < monitor1[i].length; j++) {
                if (monitor1[i][j] == 2){
                    counter1++;
                }
            }
        }



        int counter2 = 0;
        for (int i = 0; i < monitor2.length ; i++) {
            for (int j = 0; j < monitor2[i].length; j++) {
                if (monitor2[i][j] == 2){
                    counter2++;
                }
            }
        }
        if (counter1 == 10){
            System.out.println(playerName1 + "WIN");
            return true;
        }
        if (counter2 == 10){
            System.out.println(playerName2 + "WIN");
            return true;
        }
        return false;
    }
}
