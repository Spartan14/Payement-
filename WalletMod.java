package WalletUI;
import java.util.Scanner;
import java.util.regex.Pattern;

import WalletBean.WalletBean;
import WalletService.WalletService;
public class WalletMod {
	static int i=1000;
	WalletService serviceObj = new WalletService();
	Scanner sc = new Scanner(System.in);
	
	//************************************************************************************************
	//*************BANK MAIN MODULES METHODS**********************************************************
	//************************************************************************************************
	public void createAccount() {
		System.out.print("Enter Name: ");
		String name = nameCheck(sc.next());
		System.out.print("Enter Mobile No.: ");
		long mobNo = mobCheck(sc.nextLong());
		long accNo = mobNo + i ;
		i=i+1;
		System.out.print("Enter Balance: "); 
		float balance = amountCheck(sc.nextFloat());
		WalletBean bankBeanObjCreateAccountObj = new WalletBean(accNo, name, mobNo, balance);
		System.out.println("Account created with Account Number: " +accNo);
		serviceObj.bankAccountCreate(bankBeanObjCreateAccountObj);
	}
	
	public void showBalance() {
		System.out.print("Enter Account Number: ");
		long accNo = sc.nextLong();
		WalletBean bankBeanShowBalObj = new WalletBean(accNo);
		serviceObj.showBalanceSer(bankBeanShowBalObj);
	}
	
	public void deposit() {
		System.out.print("Enter Account Number: ");
		long accNo = sc.nextLong();
		System.out.print("Enter Deposit Amount: ");
		float depAmount = amountCheck(sc.nextFloat());
		WalletBean bankBeanDeptObj = new WalletBean(accNo, depAmount);
		serviceObj.depositSer(bankBeanDeptObj);
	}
	
	public void withdraw() {
		System.out.print("Enter Account Number: ");
		long accNo = sc.nextLong();
		System.out.print("Enter Withdraw Amount: ");
		float withdrawAmount = amountCheck(sc.nextFloat());
		WalletBean bankBeanWithdrawObj = new WalletBean(withdrawAmount, accNo);
		serviceObj.withdrawSer(bankBeanWithdrawObj);
	}
	
	public void fundTransfer() {
		System.out.println("Enter Source Account Number: ");
		long sourceAccNo = sc.nextLong();
		System.out.println("Enter Destination Account Number: ");
		long destAccNo = sc.nextLong();
		System.out.println("Enter Amount to transfer: ");
		float transferAmount = amountCheck(sc.nextFloat());
		WalletBean bankBeanFundTransObj = new WalletBean(sourceAccNo, destAccNo, transferAmount);
		serviceObj.transferSer(bankBeanFundTransObj);
	}
	
	

//validation method

	
	//  Check the desired amount is available or not
	public float amountCheck(float amount) {
		while(true) {
			if(amount<=0) {
				System.out.println("Amount should be greater than 0.");
				System.out.println("Enter again: ");
				amount = sc.nextInt();
			}
			else {
				return amount;
			}
		}
	}
	
	// Check is correct or not
	public String nameCheck(String name) {
		while(true) {
			if(Pattern.matches("([A-Z])*([a-z])*", name)){
				return name;
			}
			else {
				System.out.println("Name should only have alphabets.");
				System.out.println("Enter again: ");
				name = sc.next();
			}
		}
	}
	
	//	check mobile number is valid or not
	public long mobCheck(long mob) { 
		while(true) {
			if(String.valueOf(mob).length()<10||String.valueOf(mob).length()>10) 
			{
				System.out.println("Enter valid mobile number.");
				mob = sc.nextLong();
			}
			else {
				return mob;
			}
		}
	}

}
