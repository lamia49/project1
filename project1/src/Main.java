import java.util.*;

public class Main {
    public static void checkP(int p)throws Exception{
        if(p<=0||p>9){
            throw new Exception("the number is Out of Boundry");
        }}
    static ArrayList<Integer>playp=new ArrayList<>();
    static ArrayList<Integer>Cpp=new ArrayList<>();

    public static void DisplayGame(char[][] game) {
        for (char[] row : game) {
            for (char coulme : row) {
                System.out.print(coulme);
            }
            System.out.println();
        }
    }
    public static void play(char[][] game, int p, String user) {
        char symbol = ' ';
            if (user.equals("Player")) {
                symbol = 'X';
                playp.add(p);
            } else if (user.equals("Computer")) {
                symbol = 'O';
                Cpp.add(p);
            }
         switch (p){
             case 1:
            game[0][0] = symbol;
            break;
             case 2:
            game[0][2] = symbol;
            break;
             case 3:
            game[0][4] = symbol;
            break;
             case 4:
            game[2][0] = symbol;
            break;
             case 5:
            game[2][2] = symbol;
            break;
             case 6:
            game[2][4] = symbol;
            break;
             case 7:
            game[4][0] = symbol;
            break;
             case 8:
            game[4][2] = symbol;
            break;
             case 9:
            game[4][4] = symbol;
             default:
                 break;
            }
    }

    public static boolean cheakwin(char[][] game,boolean gameon) {



       //h1
        if (game[0][0] == 'X' && game[0][2] == 'X' && game[0][4] == 'X') {
            System.out.println("Congrats You win!!");
            DisplayGame(game);
            System.exit(0);
        } else if (game[0][0] == 'O' && game[0][2] == 'O' && game[0][4] == 'O')  {
            DisplayGame(game);
            System.out.println("Good Luck next time");
            System.exit(0);
        }


      //h2
        if (game[2][0] == 'X' && game[2][2] == 'X' && game[2][4] == 'X') {
            DisplayGame(game);
            System.out.println("Congrats You win!!");
            System.exit(0);
        } else if (game[2][0] == 'O' && game[2][2] == 'O' && game[2][4] == 'O') {
            DisplayGame(game);
            System.out.println("Good Luck next time");
            System.exit(0);
        }

       //h3
        if (game[4][0] == 'X' && game[4][2] == 'X' && game[4][4] == 'X') {
            DisplayGame(game);
            System.out.println("Congrats You win!!");
        } else if (game[4][0] == 'O' && game[4][2] == 'O' && game[4][4] == 'O') {
            DisplayGame(game);
            System.out.println("Good Luck next time");
            System.exit(0);
        }

       //v1
        if (game[0][0] == 'X' && game[2][0] == 'X' && game[4][0] == 'X') {
            DisplayGame(game);
            System.out.println("Congrats You win!!");
            System.exit(0);
        } else if (game[0][0] == 'O' && game[2][0] == 'O' && game[4][0] == 'O') {
            DisplayGame(game);
            System.out.println("Good Luck next time");
            System.exit(0);
        }

       //v2
        if (game[0][2] == 'X' && game[2][2] == 'X' && game[4][2] == 'X') {
            DisplayGame(game);
            System.out.println("Congrats You win!!");
            System.exit(0);
        } else if (game[0][2] == 'O' && game[2][2] == 'O' && game[4][2] == 'O') {
            DisplayGame(game);
            System.out.println("Good Luck next time");
            System.exit(0);
        }

     //v3
        if (game[0][4] == 'X' && game[2][4] == 'X' && game[4][4] == 'X') {
            DisplayGame(game);
            System.out.println("Congrats You win!!");
            System.exit(0);
        } else if (game[0][4] == 'O' && game[2][4] == 'O' && game[4][4] == 'O') {
            DisplayGame(game);
            System.out.println("Good Luck next time");
            System.exit(0);
        }

        //خط مايل
        if (game[0][0] == 'X' && game[2][2] == 'X' && game[4][4] == 'X') {
            DisplayGame(game);
            System.out.println("Congrats You win!!");
            System.exit(0);
        } else if (game[0][0] == 'O' && game[2][2] == 'O' && game[4][4] == 'O') {
            DisplayGame(game);
            System.out.println("Good Luck next time");
            System.exit(0);
        }

        if (game[0][4] == 'X' && game[2][2] == 'X' && game[4][0] == 'X') {
            DisplayGame(game);
            System.out.println("Congrats You win!!");
            System.exit(0);
        } else if (game[0][4] == 'O' && game[2][2] == 'O' && game[4][0] == 'O') {
            DisplayGame(game);
            System.out.println("Good Luck next time");
            System.exit(0);
        }


        return gameon;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] game =
                {       {' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '}};
        DisplayGame(game);
        boolean gameon=true;
        int Cpostion=0;
        int postion=0;
        try {
            do {
                System.out.println("Chose your postion from 1to9 : ");
                postion = input.nextInt();
                checkP(postion);
                while (playp.contains(postion) || Cpp.contains(postion)) {
                    System.out.println("Postion is taken,Enter another postion : ");
                    postion = input.nextInt();
                    cheakwin(game, gameon);
                    DisplayGame(game);
                }
                play(game, postion, "Player");
                if (playp.size() + Cpp.size() == 9) {
                    cheakwin(game, gameon);
                    DisplayGame(game);
                    System.out.println("The board is full!.");
                    gameon = false;
                    break;
                }
                Random rand = new Random();
                Cpostion = rand.nextInt(9) + 1;
                while (playp.contains(Cpostion) || Cpp.contains(Cpostion)) {
                    Cpostion = rand.nextInt(9) + 1;

                }
                play(game, Cpostion, "Computer");
                DisplayGame(game);
                cheakwin(game, gameon);
            } while (gameon);
        }catch(InputMismatchException e1) {
            System.out.println("please Enter only number.");}
        catch(Exception e){
            System.out.printf(e.getMessage());
        }
    }
}

