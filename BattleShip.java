import java.util.Scanner;

public class BattleShip {
    static String playerName1 = "P1";
    static String playerName2 = "P2";
    static Scanner scanner = new Scanner(System.in);
    static int[][] battlefield1 = new int[10][10];
    static int[][] battlefield2 = new int[10][10];

    public static void main(String[] args){

//        System.out.println("Player#1, please enter your name: ");
//        playerName1 = scanner.nextLine();
//        System.out.println("Player#2, please enter your name: ");
//        playerName2 = scanner.nextLine();




    }

    public static void draw(){
        System.out.println(playerName1 + ", please choose place your 4-deck ships on the battlefield");
        System.out.println("   А Б В Г Д Е Ж З И К");
        for (int i = 0; i <9; i++) {
            System.out.println(i + 1 + "  - - - - - - - - - -");
        }
        System.out.println(10 + " - - - - - - - - - -");

        System.out.println("Please enter OX coordinate");
        int x = scanner.nextInt();
        System.out.println("Please enter OY coordinate");
        int y = scanner.nextInt();
        System.out.println("Choose direction: ");
        System.out.println("1. Vertical");
        System.out.println("2. Horizontal");
        int direction = scanner.nextInt();
        battlefield1[x][y] = 1;
        if(direction == 1){
            battlefield1[x][y+1] = 1;
            battlefield1[x][y+2] = 1;
            battlefield1[x][y+3] = 1;
        }else {
            battlefield1[x+1][y] = 1;
            battlefield1[x+2][y] = 1;
            battlefield1[x+3][y] = 1;
        }

        for (int i = 0; i < battlefield1.length; i++) {
            for (int j = 0; j < battlefield2.length; j++) {

            }
        }
    }

}
