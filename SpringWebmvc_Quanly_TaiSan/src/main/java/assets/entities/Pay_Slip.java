package assets.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pay_Slip")
public class Pay_Slip {
	@Id
	@Column(name = "Pay_Slip_Id")
	private String pay_Slip_Id;
	@Column(name = "Borrower")
	private String borrower;
	@Column(name = "PaymentDate")
	private Date paymentDate;
	@Column(name = "Amount")
	private Integer amount;
	
	
	
	@ManyToOne
	@JoinColumn(name = "AssetID",referencedColumnName = "AssetID")
	private Asset_List asset_Lists;
	
	@ManyToOne
	@JoinColumn(name = "AsetId",referencedColumnName = "AsetId")
	private Assets assets;
	
	
	public Pay_Slip() {
		// TODO Auto-generated constructor stub
	}


	public Pay_Slip(String pay_Slip_Id, String borrower, Date paymentDate, Integer amount) {
		super();
		this.pay_Slip_Id = pay_Slip_Id;
		this.borrower = borrower;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}


	public String getPay_Slip_Id() {
		return pay_Slip_Id;
	}


	public String getBorrower() {
		return borrower;
	}


	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public Asset_List getAsset_Lists() {
		return asset_Lists;
	}


	public void setAsset_Lists(Asset_List asset_Lists) {
		this.asset_Lists = asset_Lists;
	}


	public Assets getAssets() {
		return assets;
	}


	public void setAssets(Assets assets) {
		this.assets = assets;
	}


	public void setPay_Slip_Id(String pay_Slip_Id) {
		this.pay_Slip_Id = pay_Slip_Id;
	}


	




}
