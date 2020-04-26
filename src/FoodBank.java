/*
FoodBank will have a single instance variable named food of type int. FoodBank will define
a default constructor which initializes food to zero. FoodBank will have two methods:
giveFood and takeFood. Both methods will have a single parameter of type int. giveFood
will add the value of the parameter to the food instance variable, takeFood will subtract
the value.
 */


public class FoodBank {
    private int food;
    public static boolean lock = false;
    private int needed = 0;
    public FoodBank() {
        food = 0;
    }

    public synchronized void giveFood(int moreFood){
        food += moreFood;
        System.out.println("Food Now Available: " + food);
        if (lock && (food >= needed)){
            notify();
            needed = 0;
            lock = false;
        }
    }

    public synchronized void takeFood(int lessFood){
        food -= lessFood;
        System.out.println("Food Now Available: " + food);
    }

    public boolean hasEnough(int numNeeded){
        if (food < numNeeded) {
            lock = true;
            needed = numNeeded;
            return false;
        }
        return false;
    }
}
