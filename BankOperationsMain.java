package bankingAssignment;

import java.util.Scanner;

public class BankOperationsMain {

	public static void main(String[] args) {
		BankOperations bankingOperations = null;
		AccountDetails accountDetails = new AccountDetails("98765", "Manpreet", 5000, "1234", "abcd");

		// AccountDetails accountDetails = new AccountDetails("1234567","Aman",8000,"0989","qwerty");

		// AccountDetails accountDetails = new AccountDetails("9801","Asha",3000,"11189","hello");

		Scanner sc = new Scanner(System.in);
		String accountNumber = accountDetails.getAccountNumber();
		String nameOfAccountHolder = accountDetails.getNameofAccountHolder();
		System.out.println("Account no: " + accountNumber + "       Name of account Holder: " + nameOfAccountHolder);
		System.out.println("Which opertaion do you want to perform(ATM or OnlineBanking)");
		String operation = sc.next();
		double fundsAvailable = accountDetails.getfundsAvailable();

		switch (operation) {
		case "ATM":
			System.out.println("Enter ATM pin");
			String enteredATMPin = sc.next();
			String pin = accountDetails.getAtmPin(enteredATMPin);

			if (pin.equals(enteredATMPin)) {
				bankingOperations = new ATM(fundsAvailable, pin);
			} else {
				System.out.println("Incorrect PIN");
				System.exit(0);
			}
			break;

		case "OnlineBanking":
			System.out.println("Enter Online Banking  Password");
			String enteredBankingPassword = sc.next();
			String password = accountDetails.getOnlinePassword(enteredBankingPassword);

			if (password.equals(enteredBankingPassword)) {

				bankingOperations = new OnlineBanking(fundsAvailable, password);
			} else {
				System.out.println("Incorrect Password");
				System.exit(0);
			}
			break;

		default:
			System.out.println("Select correct Action");
			System.exit(0);
			break;
		}

		System.out.println("Deposit / Withdrawl / View Balance / Change Pin");
		String actionToBePerformed = sc.next();

		if (actionToBePerformed.equalsIgnoreCase("Withdrawl")) {
			bankingOperations.withdrawAmount();
			bankingOperations.viewBalance();
		} else if (actionToBePerformed.equalsIgnoreCase("Deposit")) {
			bankingOperations.depositAmount();
			bankingOperations.viewBalance();
		} else if (actionToBePerformed.equalsIgnoreCase("Balance")) {
			bankingOperations.viewBalance();
		} else if (actionToBePerformed.equalsIgnoreCase("ChangePin")) {
			bankingOperations.changePinPassword();
		} else {
			System.out.println("Incorrect action.");
		}

	}

}
