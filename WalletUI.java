package WalletUI;

import java.util.Scanner;
public class WalletUI {
	public static void main(String args[]) {
		int i;
		char choice;
		WalletMod WalletMods = new WalletMod();
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("\n Welcome to our online Wallet Portal\n 1. Create Account \n 2. Show Balance \n 3. Deposit \n 4. Withdraw \n 5. Fund Transfer \n 6. Exit\n");
			System.out.print("Enter your choice : ");
			i= sc.nextInt();
			switch(i) {
			case 1:
				WalletMods.createAccount();
				break;
			case 2:
				WalletMods.showBalance();
				break;
			case 3:
				WalletMods.deposit();
				break;
			case 4:
				WalletMods.withdraw();
				break;
			case 5:
				WalletMods.fundTransfer();
				break;
			case 6:
				System.out.println("Thank You ! for using ");
				System.exit(0);
			}
			System.out.print("Do you want to continue (y/n)...? : ");
			choice = sc.next().charAt(0);
			if(choice == 'y' || choice=='Y')
				continue;
			else {
				System.out.println("Thank You !");
				System.exit(0);
			}
		} while(i != 6 );
		sc.close();
	}
}
