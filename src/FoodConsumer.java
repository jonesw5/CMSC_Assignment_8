/*
FoodConsumer is identical to FoodProducer except that the random number
generated in run will be removed from the FoodBank object.
 */

public class FoodConsumer extends Thread{
    private FoodBank bank;
    public static boolean lock = false;

    public FoodConsumer(FoodBank foodBank) {
        this.bank = foodBank;
    }

    public void run(){
        synchronized (bank){
            while (true) {
                int rando = (int) (1 + (Math.random() * 99));
                if (!bank.hasEnough(rando)) {
                    try {
                        System.out.println("Waiting for Food");
                        bank.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                bank.takeFood(rando);
                System.out.println("Taking food: " + rando);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
