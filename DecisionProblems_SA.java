/*
Decision Problems Menu
Mr. Jay
ICS4U1-02
Sarah Ali
Feb 2020
 */

package com.company;

import java.util.*;

public class DecisionProblems_SA {

    static Scanner in = new Scanner(System.in);

    public static void DiscountPrices ()
    {
        System.out.println("Enter the amount of purchases:");
        int price = in.nextInt();

        if (price > 1000)
        {
            System.out.println("Discounted Price: " + (price/10*9));
        }
        else
        {
            System.out.println("Price: " + price);
        }
    }

    public static void OrderChecker ()
    {
        final int boltPrice = 5;
        final int nutPrice = 3;
        final int washerPrice = 1;

        System.out.print("Number of bolts: ");
        int bolt = in.nextInt();
        System.out.print("Number of nuts: ");
        int nut = in.nextInt();
        System.out.print("Number of washers: ");
        int washer = in.nextInt();

        System.out.println();

        if (nut < bolt)
        {
            System.out.println("Check the Order: too few nuts");
        }
        if (washer < 2*bolt)
        {
            System.out.println("Check the Order: too few washers");
        }
        if (nut >= bolt && washer >= 2*bolt)
        {
            System.out.println("Order is OK.");
        }

        System.out.println("\nTotal cost: " + (bolt * boltPrice + nut * nutPrice + washer * washerPrice));
    }

    public static void LastChanceGas ()
    {
        System.out.println("Tank Capacity: ");
        int tankCapacity = in.nextInt();
        System.out.println("Gage Reading: ");
        int gageReading = in.nextInt();
        System.out.println("Miles per Gallon: ");
        int milesPerGallon = in.nextInt();

        if (tankCapacity * gageReading / 100 * milesPerGallon < 200)
        {
            System.out.println("Get Gas!");
        }
        else
        {
            System.out.println("Safe to Proceed");
        }
    }

    public static void PieEatingContest ()
    {
        System.out.print("Enter contestant's weight: ");
        int weight = in.nextInt();

        if (weight < 220 || weight > 280)
        {
            System.out.println("Too heavy to participate!");
        }
        else
        {
            System.out.println("The contestant may proceed.");
        }
    }

//*****************************************Ground Beef Value Calculator**********************************************

    public static void GroundBeefValueCalculator ()
    {
        double priceA, priceB, pricePerLeanA, pricePerLeanB;
        int percentLeanA, percentLeanB;

        System.out.println("Price per pound package A: "); //Ask for cost per pound of package A
        priceA = in.nextDouble();
        System.out.println("Percent lean package A: "); //Ask for percent lean meat in package A
        percentLeanA = in.nextInt();
        System.out.println("Price per pound package B: "); //Ask for cost per pound of package B
        priceB = in.nextDouble();
        System.out.println("Percent lean package B: "); //Ask for percent lean meat in package B
        percentLeanB = in.nextInt();

        pricePerLeanA = priceA / percentLeanA * 100; //Calculate the cost per pound of lean meat in package A
        pricePerLeanB = priceB / percentLeanB * 100; //Calculate the cost per pound of lean meat in package B

        System.out.print("\nPackage A cost per pound of lean: ");
        System.out.format("%.2f%n", pricePerLeanA); //Output cost per pound of lean meat rounded to 2 decimal places
        System.out.print("Package B cost per pound of lean: ");
        System.out.format("%.2f%n", pricePerLeanB);

        if (pricePerLeanA < pricePerLeanB) //determine which package has the best value by comparing cost per pound of lean meat in packages A and B
        {
            System.out.println("Package A is the best value");
        }
        else
        {
            System.out.println("Package B is the best value");
        }
    }

    public static void Y2KProblemDetector ()
    {
        System.out.print("Year of Birth: ");
        int birth = in.nextInt();
        System.out.print("Current Year: ");
        int current = in.nextInt();

        if (birth >= 20)
        {
            birth += 1900;
        }
        else
        {
            birth += 2000;
        }
        if (current <= 20)
        {
            current += 2000;
        }
        else
        {
            current += 1900;
        }

        int age = current - birth;

        System.out.println("Your age: " + age);
    }

    public static void WindChillIndex ()
    {
        System.out.print("Enter wind speed: ");
        double v = in.nextDouble();
        System.out.print("Enter temperature: ");
        double t = in.nextDouble();

        double wci;

        if (v >= 0 && v <= 4)
        {
            wci = t;
        }
        else if (v >= 45)
        {
            wci = 1.6*t - 55;
        }
        else
        {
            wci = 91.4 + (91.4 - t)*(0.0203*v - 0.304*Math.sqrt(v) - 0.474);
        }

        System.out.println("The wind chill index is " + wci);
    }

    public static void YourAgeInSeconds ()
    {
        System.out.print("Enter age in years: ");
        int year = in.nextInt();
        System.out.print("...months: ");
        int month = in.nextInt();
        System.out.print("...and days: ");
        int day = in.nextInt();

        int seconds = year * 365 * 24 * 60 * 60 + day * 24 * 60 * 60;

        int [] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month; i++)
        {
            seconds += monthDays[i];
        }

        System.out.println("Your age in seconds is: " + seconds);
    }

    public static void MatineeMovieTickets ()
    {
        System.out.print("Enter age: ");
        int age = in.nextInt();
        System.out.print("Enter time: ");
        int time = in.nextInt();

        if (age > 13)
        {
            if (time < 1700)
            {
                System.out.println("Your price is $5.00");
            }
            else
            {
                System.out.println("Your price is $8.00");
            }
        }
        else
        {
            if (time < 1700)
            {
                System.out.println("Your price is $2.00");
            }
            else
            {
                System.out.println("Your price is $4.00");
            }
        }
    }

    public static void MidnightMadness ()
    {
        System.out.print("Enter age: ");
        int age = in.nextInt();
        System.out.print("Enter time: ");
        int time = in.nextInt();

        if (age > 13)
        {
            if (time < 1700)
            {
                System.out.println("Your price is $5.00");
            }
            else if (time > 2200)
            {
                System.out.println("Your price is $4.00");
            }
            else
            {
                System.out.println("Your price is $8.00");
            }
        }
        else
        {
            if (time < 1700)
            {
                System.out.println("Your price is $2.00");
            }
            else if (time > 2200)
            {
                System.out.println("Sorry! No kids allowed at this time");
            }
            else
            {
                System.out.println("Your price is $4.00");
            }
        }
    }

//**********************************************Internet Delicatessen*********************************************

    public static void InternetDelicatessen ()
    {
        String item;
        int price, overNightDelivery, shipping;

        System.out.print("Enter the item: "); //Ask for the name of item
        in.nextLine();
        item = in.nextLine();
        System.out.print("Enter the price: "); //Ask for the cost of the item
        price = in.nextInt();
        System.out.print("Overnight delivery (0==no, 1==yes): "); //Ask if overnight delivery applies
        overNightDelivery = in.nextInt();

        if (price < 1000)
        {
            shipping = 200; //add $2 shipping cost if item price is less than $10
        }
        else
        {
            shipping = 300; //add $3 shipping cost if item price is equal to or more than $10
        }
        if (overNightDelivery == 1)
        {
            shipping += 500; //add extra $5 shipping cost if overnight delivery applies
        }

        System.out.println("\nInvoice:");
        System.out.print("\t" + item); //format item to indent
        System.out.format("%" + (25 - item.length()) + ".2f%n", price/100.0); //format prices to be aligned with uniform total field width of 25
        System.out.print("\tShipping");
        System.out.format("%17.2f%n", shipping/100.0); //convert prices to dollars with two decimal places
        System.out.print("\tTotal");
        System.out.format("%20.2f%n", (price+shipping)/100.0);
    }

    public static void SteamEngineEfficiency ()
    {
        System.out.print("Enter the air temperature: ");
        double airTemp = in.nextDouble();
        System.out.print("Enter the steam temperature: ");
        double steamTemp = in.nextDouble();

        if (steamTemp < 373)
        {
            System.out.println("The maximum possible efficiency of the steam engine is 0.");
        }
        else
        {
            System.out.println("The maximum possible efficiency of the steam engine is " + (1 - airTemp/steamTemp));
            //System.out.format("%.f%n", 1 - airTemp/steamTemp);
        }
    }

    public static void MicrowaveOven ()
    {
        System.out.print("Enter the number of items being heated: ");
        int itemNum = in.nextInt();
        System.out.print("Enter the single-item heating time: ");
        int heatingTime = in.nextInt();

        if (itemNum == 1)
        {
            System.out.println("The heating time is " + heatingTime);
        }
        else if (itemNum == 2)
        {
            System.out.println("The heating time is " + 1.5*heatingTime);
        }
        else if (itemNum == 3)
        {
            System.out.println("The heating time is " + (2*heatingTime));
        }
        else
        {
            System.out.println("Heating more than 3 items at a time is not recommended.");
        }
    }

    public static void FantasyGame ()
    {
        System.out.println("Welcome to Yertle's Quest!");
        System.out.println("Enter your character's name: ");
        in.nextLine();
        String name = in.nextLine();
        System.out.println("Enter strength (1-10):");
        int strength = in.nextInt();
        System.out.println("Enter health (1-10):");
        int health = in.nextInt();
        System.out.println("Enter luck (1-10):");
        int luck = in.nextInt();

        if (strength + health + luck > 15)
        {
            System.out.println("\nYou have given your character too many points! Default values have been assigned:");
            System.out.println(name + ", strength: 5, health: 5, luck: 5");
        }
        else
        {
            System.out.println("\nHere are your character's stats:");
            System.out.println(name + ", strength: " + strength + ", health: " + health + ", luck: " + luck);
        }
    }

    public static void CheckCharge ()
    {
        System.out.print("Enter balance in checking account: ");
        double checkingAccount = in.nextDouble();
        System.out.print("Enter balance in savings account: ");
        double savingsAccount = in.nextDouble();

        if (checkingAccount > 1000 || savingsAccount > 1500)
        {
            System.out.println("There is no service charge for writing checks.");
        }
        else
        {
            System.out.println("There is a $0.15 service charge per check.");
        }
    }

    public static void TirePressure ()
    {
        System.out.println("Input right front pressure");
        int rightFrontPressure = in.nextInt();
        System.out.println("Input left front pressure");
        int leftFrontPressure = in.nextInt();
        System.out.println("Input right rear pressure");
        int rightRearPressure = in.nextInt();
        System.out.println("Input left rear pressure");
        int leftRearPressure = in.nextInt();

        if (rightFrontPressure == leftFrontPressure && rightRearPressure == leftRearPressure)
        {
            System.out.println("\nInflation is OK");
        }
        else
        {
            System.out.println("\nInflation is BAD!");
        }
    }

    public static void MoreTirePressure ()
    {
        boolean goodPressure = true;

        System.out.println("Input right front pressure");
        int rightFrontPressure = in.nextInt();
        if (rightFrontPressure <= 35 || rightFrontPressure >= 45)
        {
            System.out.println("Warning: pressure is out of range\n");
            goodPressure = false;
        }

        System.out.println("Input left front pressure");
        int leftFrontPressure = in.nextInt();
        if (leftFrontPressure <= 35 || leftFrontPressure >= 45)
        {
            System.out.println("Warning: pressure is out of range\n");
            goodPressure = false;
        }

        System.out.println("Input right rear pressure");
        int rightRearPressure = in.nextInt();
        if (rightRearPressure <= 35 || rightRearPressure >= 45)
        {
            System.out.println("Warning: pressure is out of range\n");
            goodPressure = false;
        }

        System.out.println("Input left rear pressure");
        int leftRearPressure = in.nextInt();
        if (leftRearPressure <= 35 || leftRearPressure >= 45)
        {
            System.out.println("Warning: pressure is out of range\n");
            goodPressure = false;
        }

        if (rightFrontPressure == leftFrontPressure && rightRearPressure == leftRearPressure && goodPressure)
        {
            System.out.println("\nInflation is OK!");
        }
        else
        {
            System.out.println("\nInflation is BAD!");
        }
    }

//********************************************The Pressure is Building*************************************************

    public static void ThePressureIsBuilding ()
    {
        int rightFrontPressure, leftFrontPressure, rightRearPressure, leftRearPressure;

        System.out.println("Input right front pressure"); //Ask for pressure in right front tire
        rightFrontPressure = in.nextInt();
        System.out.println("Input left front pressure"); //Ask for pressure in left front tire
        leftFrontPressure = in.nextInt();
        System.out.println("Input right rear pressure"); //Ask for pressure in right rear tire
        rightRearPressure = in.nextInt();
        System.out.println("Input left rear pressure"); //Ask for pressure in left rear tire
        leftRearPressure = in.nextInt();

        if (Math.abs(rightFrontPressure - leftFrontPressure) <= 3 && Math.abs(rightRearPressure - leftRearPressure) <= 3) //check if front tires are within 3 psi of each other and rear tires are within 3 psi of each other
        {
            System.out.println("\nInflation is OK");
        }
        else
        {
            System.out.println("\nInflation is BAD!");
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Enter a number to display a program:");
            System.out.println("(*** = key program)");
            System.out.println();
            System.out.println("1 - Discount Prices");
            System.out.println("2 - Order Checker");
            System.out.println("3 - Last Chance Gas");
            System.out.println("4 - Pie Eating Contest");
            System.out.println("***5 - Ground Beef Value Calculator");
            System.out.println("6 - Y2K Problem Detector");
            System.out.println("7 - Wind Chill Index");
            System.out.println("8 - Your Age in Seconds");
            System.out.println("9 - Matinee Movie Tickets");
            System.out.println("10 - Midnight Madness");
            System.out.println("***11 - Internet Delicatessen");
            System.out.println("12 - Steam Engine Efficiency");
            System.out.println("13 - Microwave Oven");
            System.out.println("14 - Fantasy Game");
            System.out.println("15 - Check Charge");
            System.out.println("16 - Tire Pressure");
            System.out.println("17 - More Tire Pressure");
            System.out.println("***18 - The Pressure is Building");
            System.out.println("Enter 0 to quit");
            choice = in.nextInt();
            System.out.println();

            if (choice == 1) {
                DiscountPrices();
            } else if (choice == 2) {
                OrderChecker();
            } else if (choice == 3) {
                LastChanceGas();
            } else if (choice == 4) {
                PieEatingContest();
            } else if (choice == 5) {
                GroundBeefValueCalculator();
            } else if (choice == 6) {
                Y2KProblemDetector();
            } else if (choice == 7) {
                WindChillIndex();
            } else if (choice == 8) {
                YourAgeInSeconds();
            } else if (choice == 9) {
                MatineeMovieTickets();
            } else if (choice == 10) {
                MidnightMadness();
            } else if (choice == 11) {
                InternetDelicatessen();
            } else if (choice == 12) {
                SteamEngineEfficiency();
            } else if (choice == 13) {
                MicrowaveOven();
            } else if (choice == 14) {
                FantasyGame();
            } else if (choice == 15) {
                CheckCharge();
            } else if (choice == 16) {
                TirePressure();
            } else if (choice == 17) {
                MoreTirePressure();
            } else if (choice == 18) {
                ThePressureIsBuilding();
            }

            System.out.println();
            System.out.println("Press enter to continue.");
            in.nextLine();
            in.nextLine();
        }
        while (choice != 0);

        System.out.println("The program has ended");
    }
}
