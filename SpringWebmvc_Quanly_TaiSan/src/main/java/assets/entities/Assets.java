package assets.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Assets")
public class Assets {

	@Id
	@Column(name = "AsetId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer asetId;
	@Column(name = "AsetName")
	
	private String asetName;
	@Column(name = "SerialNumber")

	private Integer serialNumber;
	@Column(name = "image")
	private String image;
	@Column(name = "PurchaseDate")
	
	private Date purchaseDate;
	@Column(name = "PurchaseCost")
	
	private Integer purchaseCost;
	@Column(name = "Condition")
	
	private Boolean condition;

	@ManyToOne
	@JoinColumn(name = "AssetID", referencedColumnName = "AssetID")
	private Asset_List asetList;

	@OneToMany(mappedBy = "assets")
	private Set<Handover> listHandovers;
	
	@OneToMany(mappedBy = "assets")
	private Set<Pay_Slip> listPay_Slips;
	
	public Assets() {
		// TODO Auto-generated constructor stub
	}


	public Assets(Integer asetId, String asetName, Integer serialNumber, String image, Date purchaseDate,
			Integer purchaseCost, Boolean condition) {
		super();
		this.asetId = asetId;
		this.asetName = asetName;
		this.serialNumber = serialNumber;
		this.image = image;
		this.purchaseDate = purchaseDate;
		this.purchaseCost = purchaseCost;
		this.condition = condition;
	}


	public Integer getAsetId() {
		return asetId;
	}


	public void setAsetId(Integer asetId) {
		this.asetId = asetId;
	}


	public String getAsetName() {
		return asetName;
	}


	public void setAsetName(String asetName) {
		this.asetName = asetName;
	}


	public Integer getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Integer getPurchaseCost() {
		return purchaseCost;
	}


	public void setPurchaseCost(Integer purchaseCost) {
		this.purchaseCost = purchaseCost;
	}


	public Boolean getCondition() {
		return condition;
	}


	public void setCondition(Boolean condition) {
		this.condition = condition;
	}


	public Asset_List getAsetList() {
		return asetList;
	}


	public void setAsetList(Asset_List asetList) {
		this.asetList = asetList;
	}


	public Set<Handover> getListHandovers() {
		return listHandovers;
	}


	public void setListHandovers(Set<Handover> listHandovers) {
		this.listHandovers = listHandovers;
	}


	public Set<Pay_Slip> getListPay_Slips() {
		return listPay_Slips;
	}


	public void setListPay_Slips(Set<Pay_Slip> listPay_Slips) {
		this.listPay_Slips = listPay_Slips;
	}





	

}
