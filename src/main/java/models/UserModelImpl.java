package models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserModelImpl {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_user")
	private int idUser;
	
	private String username;
	
	private BigDecimal balance;
	
	@Column(name="stakes_won")
	private int stakesWon;
	
	@Column(name="stakes_lose")
	private int stakesLose;
	
	@Column(name="money_won")
	private BigDecimal moneyWon;
	
	@Column(name="money_lose")
	private BigDecimal moneyLose;
	
	@Column(name="received_gift_money")
	private BigDecimal receivedGiftMoney;
	
	@Column(name="sent_gift_money")
	private BigDecimal sentGiftMoney;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn(name="id_user", referencedColumnName="id_user")
	@OrderBy("id_operation DESC")
	private List<UserOperationModelImpl> operations;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public int getStakesWon() {
		return stakesWon;
	}

	public void setStakesWon(int stakesWon) {
		this.stakesWon = stakesWon;
	}

	public int getStakesLose() {
		return stakesLose;
	}

	public void setStakesLose(int stakesLose) {
		this.stakesLose = stakesLose;
	}

	public BigDecimal getMoneyWon() {
		return moneyWon;
	}

	public void setMoneyWon(BigDecimal moneyWon) {
		this.moneyWon = moneyWon;
	}

	public BigDecimal getMoneyLose() {
		return moneyLose;
	}

	public void setMoneyLose(BigDecimal moneyLose) {
		this.moneyLose = moneyLose;
	}

	public BigDecimal getReceivedGiftMoney() {
		return receivedGiftMoney;
	}

	public void setReceivedGiftMoney(BigDecimal receivedGiftMoney) {
		this.receivedGiftMoney = receivedGiftMoney;
	}

	public BigDecimal getSentGiftMoney() {
		return sentGiftMoney;
	}

	public void setSentGiftMoney(BigDecimal sentGiftMoney) {
		this.sentGiftMoney = sentGiftMoney;
	}

	public List<UserOperationModelImpl> getOperations() {
		return operations;
	}

	public void setOperations(List<UserOperationModelImpl> operations) {
		this.operations = operations;
	}

	
}
