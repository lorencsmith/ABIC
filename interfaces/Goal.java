/**
 * A Goal is something a user can set up
 */
public class Goal {

    /**
     * goalName is assumed to be unique.
     * goalName is assumed to be any string sequences.
     */
    private String goalName;

    private boolean isGoalGood;

    /**
     * goalNumber is assumed to be a positive number.
     */
    private int goalNumber;

    /**
     * setGoal assumes there goalName, isGoalGood and goalNumber exists
     * @pre goalName exists
     * @pre isGoalGood exists
     * @pre goalNumber exists
     * @post setGoal is implemented into account
     */
    public void setGoal(String name, boolean b, int number){
        System.out.println(name);
        System.out.println(b);
        System.out.println(number);
    }

    /**
     * removeGoal assumes that there is/are already a goal on the account.
     * @pre setGoal is already implemented into an account
     * @post setGoal is removed
     */
    public void removeGoal(Goal g){

    }

    /**
     * changeGoalAmount assumes that there is/are already a goal on the account
     * @pre setGoal is already implemented into an account
     * @gost setGoal.goalNumber = changeGoalAmount.amount
     */
    public void changeGoalAmount(int amount){
        System.out.println(amount);
    }


}
