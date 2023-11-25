import java.util.*;
import javax.swing.*;

public class NumberGuessingGame {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int sysInput = (int)(Math.random()*100+1);
        int guessedNumber = 0;
        System.out.println("The number you have to guess is :"+sysInput);
        int count = 1;
        while(guessedNumber != sysInput){
            String response = JOptionPane.showInputDialog(null,"Enter a number between 1 and 100",5);
            guessedNumber = Integer.parseInt(response);
            JOptionPane.showMessageDialog(null,determineGuess(guessedNumber, sysInput, count));
            count++;
        }
    }
    public static String determineGuess(int guessedNumber, int sysInput, int count){
    while(count<=5 && count>0) {
        if(guessedNumber <= 0 || guessedNumber > 100){
            return "Your guess is not in the range 1 to 100 !!!";
        }
        else if(guessedNumber == sysInput){
            return "Congratulations!! You won the game in "+count +" guesses\n Your score is "+(6-count)*20+".....";
        }
        else if(guessedNumber > sysInput){
            return "Your guess is higher than the required number, \n Try again in: "+(6-count) +" guesses";
        }
        else if(guessedNumber < sysInput){
            return "Your guess is lower than the required number, \n Try again in: "+(6-count) +" guesses";
        }
        else{
            return "Your guess is incorrect!!!";
        }
    }
    return "Sorry!! Chances over... Better luck next time.";
}
}