package Walletdao;

import java.util.HashMap;

import WalletBean.WalletBean;

public class WalletDao {
	WalletBean beanObj;
	
	HashMap<Long, WalletBean> hm = new HashMap<Long, WalletBean>();
	
	public void addCustomer(WalletBean WalletBeans) {			// Method To Add Customer 
		this.beanObj = WalletBeans;						// Storing object 
		hm.put(WalletBeans.getAccNo(), WalletBeans);			// Store  in Hash Map 
	}
	public HashMap<Long,WalletBean> hm(){						//  Return Hash Map Object
		return hm;
	}

}
