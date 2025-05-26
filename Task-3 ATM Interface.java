import java.util.Scanner;
class ATM {
    int amount = 2500000;
    void withdraw(int w) {
        if (amount > w) {
            amount = amount - w;
        } else {
            Main.flag = 1;
        }
    }
    void deposit(int d) {
        amount = amount + d;
    }
    void check_balance() {
        System.out.println("Balance in the ATM machine is: " + amount);
    }
}
class User extends ATM {
    int balance = 500000;

    void withdrawal(int wi) {
        if (amount > wi && balance > wi) {
            balance = balance - wi;
            amount = amount - wi;  
        } else {
            Main.flag = 2;
        }
    }

    void depositing(int de) {
        balance = balance + de;
        amount = amount + de; 
    }

    void check_your_balance() {
        System.out.println("Balance in your account is: " + balance);
    }
}
public class Main {
    static int flag = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User u = new User();
        while (true) {
            System.out.println("Services Provided: ");
            System.out.println("1. For Withdrawing Money.");
            System.out.println("2. For Depositing Money");
            System.out.println("3. For checking your account balance.");
            System.out.println("4. For checking the balance in ATM Machine.");
            System.out.println("5. Exit");
            int choice;
            System.out.print("Enter the service you require: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount you want to withdraw: ");
                    int with = sc.nextInt();
                    u.withdrawal(with);
                    if (flag == 0) {
                        System.out.println("Your transaction is successful!");
                    } else if (flag == 1) {
                        System.out.println("Insufficient balance in the ATM machine.");
                        System.out.println("Hence your transaction failed.");
                    } else if (flag == 2) {
                        System.out.println("Insufficient balance in your account.");
                        System.out.println("Hence your transaction failed.");
                    }
                    flag = 0;  
                    break;
                case 2:
                    System.out.print("Enter the amount you want to deposit: ");
                    int dep = sc.nextInt();
                    u.depositing(dep);
                    System.out.println("Your transaction is successful!");
                    break;
                case 3:
                    u.check_your_balance();
                    break;
                case 4:
                    u.check_balance();
                    break;
                case 5:
                    System.out.println("Thank You for using our service!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You entered an invalid option.");
                    break;
            }
            System.out.println();  
        }
    }
}