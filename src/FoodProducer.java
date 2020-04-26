/*
FoodProducer will have a single instance variable named bank of type FoodBank.
FoodProducer will have a parameterized constructor with a single parameter of
type FoodBank. The parameterized constructor will initialize the value of
bank to the single parameter. FoodProducer will extend the Thread class and
override Thread’s run method. FoodProducer’s run method will loop infinitely.
On each loop iteration run will generate a random number from 1-100 and add
that much food to the bank instance variable. After adding food, the thread
will sleep for 100 milliseconds.
*/

public class FoodProducer extends Thread{

    private FoodBank bank;

    public static boolean lock = false;

    public FoodProducer(FoodBank foodBank) {

        this.bank =foodBank;

    }

    public synchronized void run(){

        while(true){

            int rando = (int) ( 1 + (Math.random() * 99));

            bank.giveFood(rando);
            System.out.println("Giving food: " + rando);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
