		package assets.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Handover")
public class Handover {
	@Id
	@Column(name = "HandoverID")
	private String handoverID;
	@Column(name = "Borrower")
	private String borrower;
	
	@Column(name = "PaymentDate")
	private Date paymentDate;
	@Column(name = "ReturnedDate")
	private Date returnedDate;
	
	@ManyToOne
	@JoinColumn(name = "AssetID",referencedColumnName = "AssetID")
	private Asset_List asset_List;
	
	
	@ManyToOne
	@JoinColumn(name = "AsetId" ,referencedColumnName = "AsetId")
	private Assets assets;
	
	public Handover() {
		// TODO Auto-generated constructor stub
	}

	public Handover(String handoverID, String borrower, Date paymentDate, Date returnedDate) {
		super();
		this.handoverID = handoverID;
		this.borrower = borrower;
		this.paymentDate = paymentDate;
		this.returnedDate = returnedDate;
	}

	public String getHandoverID() {
		return handoverID;
	}

	public void setHandoverID(String handoverID) {
		this.handoverID = handoverID;
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

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public Asset_List getAsset_List() {
		return asset_List;
	}

	public void setAsset_List(Asset_List asset_List) {
		this.asset_List = asset_List;
	}

	public Assets getAssets() {
		return assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	


	

}
