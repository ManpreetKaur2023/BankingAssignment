package bankingAssignment;

import java.util.Scanner;

public class ATM extends BankOperations {
	Scanner sc = new Scanner(System.in);
	double balance;
	String pin;
	String changedPin;

	public ATM(double balance, String pin) {
		super();
		this.balance = balance;
		this.pin = pin;
	}

	@Override
	void withdrawAmount() {
		System.out.println("Select amount to be withdrawn from ATM :");
		double amountTOBeWithdrawn = sc.nextDouble();
		if (amountTOBeWithdrawn <= balance) {
			balance = balance - amountTOBeWithdrawn;
			System.out.println(balance);
		} else {
			System.out.println("Not enough balance");
			System.exit(0);
		}

	}

	@Override
	void depositAmount() {
		System.out.println("Select amount to be deposited");
		double amounttoToBeDeposited = sc.nextDouble();
		balance = balance + amounttoToBeDeposited;
		System.out.println(balance);
	}

	@Override
	void viewBalance() {
		System.out.println("Balance left in account: " + balance);
	}

	@Override
	public void changePinPassword() {
		System.out.println("You can reset your pin");

		for (int i = 0; i < 3; i++) {

			System.out.println("Enter new Pin");
			changedPin = sc.next();

			if (changedPin.equals(pin)) {
				System.out.println("Old and new pin should be different");

			}

			else if (changedPin.length() < 4) {
				System.out.println("Pin should have atleast 4 charcters");

			}

			else {
				System.out.println("Your new Pin is: " + changedPin);
				break;
			}

		}
	}
}
