package WalletService;

import WalletBean.WalletBean;
import Walletdao.WalletDao;

public class WalletService {
WalletDao daoObj = new WalletDao();
	
	public void bankAccountCreate(WalletBean bankBeanObjCreateAccountObj) {
		daoObj.addCustomer(bankBeanObjCreateAccountObj);
	}
	
	public void showBalanceSer(WalletBean bankBeanShowBalObj) {
		
		if(daoObj.hm().isEmpty()) {									// CHECKING IF HASH MAP IS EMPTY OR NOT
			System.out.println("Please create an account first.");
		}
		else {
			if(daoObj.hm().containsKey(bankBeanShowBalObj.getAccNo())) {
				System.out.println("Your Account Balance is: " +daoObj.hm().get(bankBeanShowBalObj.getAccNo()).getBalance());			// FETCHING THE BALANCE FROM HASHMAP & PRINTING 
			}
			else {
				System.out.println("No such Account Exist.");
			}
		}
	}
	
	public void depositSer(WalletBean bankBeanDepObj) {
		
		if(daoObj.hm().isEmpty()) {
			System.out.println("Please create an account first.");
		}
		else {
			if(daoObj.hm().containsKey(bankBeanDepObj.getAccNo())) {
				float dep = bankBeanDepObj.getDepAmount() + daoObj.hm().get(bankBeanDepObj.getAccNo()).getBalance();						// ADDING DEPOSIT AMOUNT TO BANK ACCOUNT
				daoObj.hm().get(bankBeanDepObj.getAccNo()).setBalance(dep);
				System.out.println("Deposited successfully.");
				System.out.println("Your account balance is: " +daoObj.hm().get(bankBeanDepObj.getAccNo()).getBalance());					// PRINTING THE BANK BALANCE
			}
			else {
				System.out.println("No such Account Exist.");
			}
		}
	}
	
	public void withdrawSer(WalletBean bankBeanWithdrawObj) {
		if(daoObj.hm().isEmpty()) {
			System.out.println("Please create an account first.");
		}
		else {
			if(bankBeanWithdrawObj.getWithdrawAmount() > daoObj.hm().get(bankBeanWithdrawObj.getAccNo()).getBalance()) {		// CHECKING IF WITHDRAW AMOUNT IS GREATER THAN BALANCE OR NOT
				System.out.println("Can't withdraw money. Account Balance is low.");
			}
			else {
				if(daoObj.hm().containsKey(bankBeanWithdrawObj.getAccNo())) {
					float dep = daoObj.hm().get(bankBeanWithdrawObj.getAccNo()).getBalance() - bankBeanWithdrawObj.getWithdrawAmount();			// DECREMENTING WITHDRAW AMOUNT FROM BANK ACCOUNT
					daoObj.hm().get(bankBeanWithdrawObj.getAccNo()).setBalance(dep);
					System.out.println("Withdraw successful.");
					System.out.println("Your account balance is: " +daoObj.hm().get(bankBeanWithdrawObj.getAccNo()).getBalance());				// PRINTING REMAINING BALANCE
				}
				else {
					System.out.println("No such Account Exist.");
				}
			}
		}
	}
	
	public void transferSer(WalletBean bankBeanFundTransObj) {
		if(daoObj.hm().isEmpty()) {
			System.out.println("Please create an account first.");
		}
		else {
			if(daoObj.hm().containsKey(bankBeanFundTransObj.getSourceAccNo())) {				// CHECKING IF SOURCE ACCOUNT EXIST
				if(daoObj.hm().containsKey(bankBeanFundTransObj.getDestAccNo())){
					if(bankBeanFundTransObj.getSourceAccNo()!=bankBeanFundTransObj.getDestAccNo())
					{
					// CHECKING IF DESTINATION ACCOUNT EXIST
					if(daoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).getBalance() > bankBeanFundTransObj.getTransferAmount()) {		// CHECKING IF TRANSFER AMOUNT IS GREATER THAN BALANCE OR NOT
						float transfer = bankBeanFundTransObj.getTransferAmount();
						daoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).setBalance(daoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).getBalance() - transfer);		// DECREMENTING THE TRANSFER AMOUNT
						daoObj.hm().get(bankBeanFundTransObj.getDestAccNo()).setBalance(daoObj.hm().get(bankBeanFundTransObj.getDestAccNo()).getBalance() + transfer);			// ADDING THE TRANSFER AMOUNT
						System.out.println("Funds Transferred Successfully.");
						System.out.println("Remaining balance in account number "+bankBeanFundTransObj.getSourceAccNo()+" is: " +daoObj.hm().get(bankBeanFundTransObj.getSourceAccNo()).getBalance());
					}
					else {
						System.out.println("Can't transfer money. Source Account Balance is low.");
					}
				}
					else
					{
						System.out.println("transfer from same account to same account is invalid");
					}
			}
				else {
					System.out.println("Destination Account Not Exist.");
				}
			}
			else {
				System.out.println("Source Account Not Exist.");
			}
		}
	}
}

