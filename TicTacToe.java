import java.util.*;

public class TicTacToe {
    static Scanner input = new Scanner(System.in);
    static char[][] gameBoard = new char[3][3];
    static ArrayList<Integer> player2Positions = new ArrayList<Integer>();
    static ArrayList<Integer> player1Positions = new ArrayList<Integer>();

    public static void main(String[] args){
        newGameBoard();
        playGame();
    }

    public static void newGameBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j<3;j++) {
                gameBoard[i][j] = ' ';
            }
        }
    }

    public static void playGame() {
        int position  = 0;
        while(true) {
            //Timer();
            for (int i = 0; i < 9; i++) {
                System.out.println("Please Enter position(1-9): ");

                try {
                    position = input.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("Please enter a number");
                }

                while (position > 9 || position < 1 || player1Positions.contains(position) || player2Positions.contains(position)) {
                    System.out.println("Try Another position (1-9)");
                    position = input.nextInt();
                }

                i = i % 2;

                switch (i) {
                    case 0: {
                        Update(gameBoard, position, "player1");
                        break;
                    }
                    case 1: {
                        Update(gameBoard, position, "player2");
                        break;
                    }
                }

                printGameBoard(gameBoard);
                String result = checkWinner();

                if(!result.equals(" ")) {
                    System.out.println(result);
                    System.exit(0);
                }

            }
            System.out.println("Its a tie");
        }
    }
    public static void printGameBoard(char[][] gameBoard) {
        for(char[] row: gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static String Update(char[][] gameBoard, int position, String player){
        char symbol = ' ';

        //System.out.println("It has been " + Timer() + "seconds");
        if(player.equals("player1")){
            symbol = 'X';
            player1Positions.add(position);
        }else if (player.equals("player2")) {
            symbol = 'O';
            player2Positions.add(position);
        }

        switch(position){
            case 1:{
                gameBoard[0][0] = symbol;
                break;
            }
            case 2:{
                gameBoard[0][1] = symbol;
                break;
            }
            case 3:{
                gameBoard[0][2] = symbol;
                break;
            }
            case 4:{
                gameBoard[1][0] = symbol;
                break;
            }
            case 5:{
                gameBoard[1][1] = symbol;
                break;
            }
            case 6:{
                gameBoard[1][2] = symbol;
                break;
            }
            case 7:{
                gameBoard[2][0] = symbol;
                break;
            }
            case 8:{
                gameBoard[2][1] = symbol;
                break;
            }
            case 9:{
                gameBoard[2][2] = symbol;
                break;
            }
        }
        return player;
    }

    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);

        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List botCol = Arrays.asList(3,6,9);

        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<List>();

        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(botCol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l: winning) {
            if(player1Positions.containsAll(l)) {
                return "Player 1 Wins";
            }else if (player2Positions.containsAll(l)) {
                return "Player 2 Wins";
            }
        }

        return " ";
    }
    public static long Timer(){
        long start = System.currentTimeMillis();
        long time = start/1000;
        long timeSeconds = time%60;
        return timeSeconds;
    }

    public static void Gui(){

    }
}