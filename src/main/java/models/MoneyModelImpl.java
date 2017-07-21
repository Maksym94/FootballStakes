package models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="system_balance")
public class MoneyModelImpl {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_system_money")
	private int idSystemMoney;
	
	@Column(name="received_bank_money")
	private BigDecimal receivedBankMoney;
	
	@Column(name="received_users_money")
	private BigDecimal receivedUsersMoney;
	
	@Column(name="payed_users_money")
	private BigDecimal payedUsersMoney;
	
	@Column(name="received_commissions_gift_money")
	private BigDecimal receivedCommissionsGiftMoney;
	
	public int getIdSystemMoney() {
		return idSystemMoney;
	}
	public void setIdSystemMoney(int idSystemMoney) {
		this.idSystemMoney = idSystemMoney;
	}
	public BigDecimal getReceivedBankMoney() {
		return receivedBankMoney;
	}
	public void setReceivedBankMoney(BigDecimal receivedBankMoney) {
		this.receivedBankMoney = receivedBankMoney;
	}
	public BigDecimal getReceivedUsersMoney() {
		return receivedUsersMoney;
	}
	public void setReceivedUsersMoney(BigDecimal receivedUsersMoney) {
		this.receivedUsersMoney = receivedUsersMoney;
	}
	public BigDecimal getPayedUsersMoney() {
		return payedUsersMoney;
	}
	public void setPayedUsersMoney(BigDecimal payedUsersMoney) {
		this.payedUsersMoney = payedUsersMoney;
	}
	public BigDecimal getReceivedCommissionsGiftMoney() {
		return receivedCommissionsGiftMoney;
	}
	public void setReceivedCommissionsGiftMoney(BigDecimal receivedCommissionsGiftMoney) {
		this.receivedCommissionsGiftMoney = receivedCommissionsGiftMoney;
	}
	
	
}

