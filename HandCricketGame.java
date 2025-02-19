package Hand_Cricket_Game;
import java.util.*;

public class HandCricketGame {
    static Scanner sc=new Scanner(System.in);
    static Random rand=new Random();
    public static int userFirstBowling()
    {
        int target=0;
        int userScore;
        int sysScore;
        while(true){
            System.out.print("Your CHoice (0-10) : ");
            userScore=sc.nextInt();
            sysScore=rand.nextInt(0,11);
            System.out.println("System Choice : "+sysScore);
            if(sysScore==userScore){
                System.out.println("System Out !!");
                break;
            }
            target+=sysScore;
        }
        return target;
    }

    public static int userFirstBatting()
    {
        int target=0;
        int userScore;
        int sysScore;
        while(true){
            System.out.print("Your Choice (0-10) : ");
            userScore=sc.nextInt();
            sysScore=rand.nextInt(0,11);
            System.out.println("System choice : "+sysScore);
            if(userScore==sysScore){
                System.out.println("You are Out!!");
                System.out.println("Your Total Score is = "+target);
                break;
            }
            target+=userScore;
            System.out.println("Your Current Score : "+target);
        }
        return target;
    }

    public static boolean userSecondBowling(int target)
    {
        int defendScore=target;
        System.out.println("You are to Bowl Now!");
        while(true){
            System.out.print("Your Choice (0-10) : ");
            int userScore=sc.nextInt();
            int sysScore=rand.nextInt(0,11);
            System.out.println("System Choice : "+sysScore);
            if(sysScore==userScore){
                if(defendScore==0){
                    System.out.println("Match Draw!");
                }else {
                    System.out.println("System Out!");
                    return true;
                }
            }
            defendScore=defendScore-sysScore;
            System.out.println("Remaining Score : "+defendScore);
            if(defendScore<0){
                return false;
            }
        }
    }

    public static boolean userSecondBatting(int target){
        int reqScore=target;
        System.out.println("You are to Bat Now !!");
        while(true){
            System.out.print("Your Choice (0-10) : ");
            int userScore=sc.nextInt();
            int sysScore=rand.nextInt(0,11);
            System.out.println("System Choice : "+sysScore);
            if(userScore!=sysScore){
                reqScore=reqScore-userScore;
                System.out.println("Required Score to win : "+reqScore);
            }
            if(reqScore<0){
                return true;
            }
            if(sysScore==userScore){
                if(reqScore==0){
                    System.out.println("Match Draw !!");
                }else{
                    System.out.println("You are Out !!");
                }
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("***** Welcome to HAND CRICKET GAME *****");
        sSystem.out.println();
        System.out.println("What do you Choose:\t0.Heads\t1.Tails");
        int toss=sc.nextInt();
        int sysToss=rand.nextInt(0,2);
        boolean result;
        if(toss==sysToss){
            System.out.println("You won the Toss!");
            System.out.println("What do you choose:\t0.Batting\t1.Bowling");
            int userChoice=sc.nextInt();
            if(userChoice==0){
                int target=userFirstBatting();
                result=userSecondBowling(target);
            }else{
               int target=userFirstBowling();
               System.out.println("System Total Score : "+target);
               result=userSecondBatting(target);

            }
        }else{
            int sysChoice=rand.nextInt(0,2);
            if(sysChoice==0){
                System.out.println("You lost the Toss!");
                System.out.println("System chose batting:\nYou Bowl first");
                int target=userFirstBowling();
                result=userSecondBatting(target);

            }else{
                System.out.println("You lost the Toss!");
                System.out.println("System chose bowling:\nYou Bat first !!");
                int target=userFirstBatting();
                result=userSecondBowling(target);
            }
        }
        if(result){
            System.out.println("Hurray !! You won the match!");
        }else{
            System.out.println("Oops !! You Lost the match!");
        }
    }
   
   
  
   
}
