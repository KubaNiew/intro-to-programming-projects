import javax.swing.JOptionPane;
import java.util.Scanner;
public class craps {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the craps game!");
        getUserBalance();
        getBet();
        WinLoseRoll();
        playAgain(scanner);
    }
    
    public static int UserBalance;
    public static void getUserBalance() {
        while (true) {
            String balance;
            balance = JOptionPane.showInputDialog("Please input your account balance");
            try {
                UserBalance = Integer.parseInt(balance);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Error: The box cannot be empty");
                continue;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: You must enter a numeric value in the box");
                continue;
            }

            if (UserBalance <= 0.0) {
                JOptionPane.showMessageDialog(null, "Balance must be $1 or greater");
            } else {
                break;
            }
        }
    }

    public static int getUserBet;
    public static void getBet() {
        while (true) {
            numOfGames++;
            String betBalance;
            betBalance = JOptionPane.showInputDialog("Please input your bet");
            try {
                getUserBet = Integer.parseInt(betBalance);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Error: The box cannot be empty");
                continue;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: You must enter a numeric value in the box");
                continue;
            }

            if (getUserBet <= 0 || getUserBet > UserBalance) {
                JOptionPane.showMessageDialog(null, "Bet must be greater than 0 or less than or equal to your balance");
            } else {
                System.out.println("\nGame " + numOfGames + " starting with bet of $" + (double)getUserBet);
                break;
            }
            
        }
    }

    public static void WinLoseRoll() {
        int roll1 = dice1();
        int roll2 = dice2();
        int sum = roll1 + roll2;
        System.out.println("You rolled " + sum + "\n");
        if (winRoll(sum)) {
            System.out.print("You win!\n");
            win();
        } else if (loseRoll(sum)) {
            System.out.print("You lose:(\n");
            lose();
            if (UserBalance <= 0) {
                System.out.print("You have no more money to continue\n");
                balanceIsZero();
                
            }
            
        } else {
            
            while (true) {
                int secondRoll = showRoll();
                System.out.println("You rolled " + secondRoll);
                if (secondRoll == sum) {
                    System.out.print("You Win\n");
                    win();
                    break;
                }  else if (secondRoll == 7) {
                    System.out.println("You lose\n");
                    lose();
                    if (UserBalance <= 0) {
                        balanceIsZero();
                        System.out.print("Buh bye, come back when you have money!");
                        System.exit(0);
                    }
                    break;
                }
            }
        }

        
    }

    static int dice1() {
        return (int) (Math.random() * 6) + 1;
    }

    static int dice2() {
        return (int) (Math.random() * 6) + 1;
    }

    public static boolean winRoll(int sum) {
        return sum == 7 || sum == 11;
    }

    public static boolean loseRoll(int sum) {
        return sum == 2 || sum == 3 || sum == 12;
    }

    public static int showRoll() {
        int roll1 = dice1();
        int roll2 = dice2();
        int sum = roll1 + roll2;
        return sum;
    }

    public static void win() {
        UserBalance += getUserBet;
        numOfGamesWon++;
        System.out.print("\nYour balance is now $" + (double)UserBalance + "\n");
    }

    public static void lose() {
        UserBalance -= getUserBet;
        numOfGamesLost++;
        System.out.print("Your balance is now $" + (double)UserBalance + "\n");
    }

    public static void playAgain(Scanner scanner) {
        while (true) {
            System.out.println("(y/n) would you like to play again? ");
            String user = scanner.next();
            if (user.equals("y")) {
                getBet();
                WinLoseRoll();
                continue;
            } else if (user.equals("n")) {
                System.out.println("Thank you for playing!!\n");
                break;
            }
        }
    }
    
    public static void balanceIsZero() {
        int totalGames = numOfGamesWon + numOfGamesLost;
        double winPercentage = (double) numOfGamesWon / totalGames * 100;
        double lossPercentage = (double) numOfGamesLost / totalGames * 100;
        
        System.out.println("Sadly, you are no longer eligible to play");
        System.out.printf("Your ending account balance is: $%.2f\n", (double) UserBalance);
        System.out.println("your starting balance decreased by 100%");
        System.out.println("you won " + numOfGamesWon + " (%"+ winPercentage +") and lost " + numOfGamesLost + 
        " (%"+ lossPercentage +") games\n");
        System.out.print("buh bye come back when you have money");
        System.exit(0);
        
    }

    

    public static int numOfGames = 0;
    public static int numOfGamesWon = 0;
    public static int numOfGamesLost = 0;
}