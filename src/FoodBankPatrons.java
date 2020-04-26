/*
Create a Java program that uses monitors to control access to a FoodBank object.
You will create a FoodBank class that has a food amount and methods to give and
take food. You will create two Thread classes for this program that will either
put food into the food bank or take food from the food bank. Food cannot be taken
if there is no food available to take. This is not a true producer/consumer problem.
You only have one condition, which is to wait if there is no food available to take.
Both giving and taking food must involve locking the FoodBank object and unlocking
it when done and the FoodBank object must never enter an invalid state (a negative
amount of food) The methods to take and give food must print out exactly what is
happening with each action in the method, i.e. “Waiting to get food”, “Taking 10
items of food, the balance is now 20 items”.


FoodBankPatrons will have a main method in which a FoodBank, FoodProcuder,
and FoodConsumer object are created. The FoodProducer and FoodConsumer
must share the same FoodBank object. Once created, the main method starts
these threads.
 */


public class FoodBankPatrons {

    public static void main(String[] args) {

        FoodBank foodBank = new FoodBank();

        FoodProducer foodProducer = new FoodProducer(foodBank);

        FoodConsumer foodConsumer = new FoodConsumer(foodBank);

        foodProducer.start();

        foodConsumer.start();

    }

}
