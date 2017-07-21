package models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user_operations")
public class UserOperationModelImpl {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_operation")
	private int idOperation;
	
	@Column(name="id_user")
	private int idUser;
	
	private String date;
	
	@Transient
	private String rawAmount;
	
	private BigDecimal amount;
	
	@Column(name="current_balance")
	private BigDecimal currentBalance;
	
	public int getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getRawAmount() {
		return rawAmount;
	}
	public void setRawAmount(String rawAmount) {
		this.rawAmount = rawAmount;
	}
	

}
