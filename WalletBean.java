package WalletBean;
public class WalletBean {
	private long srcAccNo, dstAccNo;
	private float balance, depAmt, withdrawAmt, transferAmt;
	private String name;
	private long mobNo,  accNo;
	
	//CONSTRUCTORS STARTS
	public WalletBean() {
		super();
	}
	
	public WalletBean(long accNo, String name, long mobNo, float balance) {
		this.accNo = accNo;
		this.name = name;
		this.mobNo = mobNo;
		this.balance = balance;
	}
	
	public WalletBean(long accNo) {
		this.accNo = accNo;
	}
	
	public WalletBean(long accNo, float depAmount) {
		this.accNo = accNo;
		this.depAmt = depAmount;
	}
	
	public WalletBean(float withdrawAmount, long accNo) {
		this.withdrawAmt = withdrawAmount;
		this.accNo = accNo;
	}
	
	public WalletBean(long sourceAccNo, long destAccNo, float transferAmount) {
		this.srcAccNo = sourceAccNo;
		this.dstAccNo = destAccNo;
		this.transferAmt = transferAmount;
	}
	
	//CONSTRUCTORS ENDS
	
	//GETTER & SETTER STARTS
	public float getTransferAmount() {
		return transferAmt;
	}

	public void setTransferAmount(float transferAmount) {
		this.transferAmt = transferAmount;
	}
	
	public float getWithdrawAmount() {
		return withdrawAmt;
	}

	public void setWithdrawAmount(float withdrawAmount) {
		this.withdrawAmt = withdrawAmount;
	}

	public float getDepAmount() {
		return depAmt;
	}

	public void setDepAmount(float depAmount) {
		this.depAmt = depAmount;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public long getSourceAccNo() {
		return srcAccNo;
	}

	public void setSourceAccNo(long sourceAccNo) {
		this.srcAccNo = sourceAccNo;
	}

	public long getDestAccNo() {
		return dstAccNo;
	}

	public void setDestAccNo(long destAccNo) {
		this.dstAccNo = destAccNo;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

}
