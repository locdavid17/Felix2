package assets.entities;

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
@Table(name = "Asset_List")
public class Asset_List {

		@Id
		@Column(name = "AssetID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer assetID;
		@Column(name = "AssetName")
		private String assetName;
		@Column(name = "image")
		private String image;
		@Column(name = "Description")
		private String description;
		@Column(name = "Quantity")
		private Integer quantity;
		@Column(name = "status")
		private Boolean status;
		
		@ManyToOne
		@JoinColumn(name = "DepartmentID" ,referencedColumnName = "DepartmentID")
		private Department depart;
		
		@ManyToOne
		@JoinColumn(name = "LocationID" ,referencedColumnName = "LocationID")
		private Location location;
		
		@OneToMany(mappedBy = "asetList")
		private Set<Assets> listAssets;
		
		@OneToMany(mappedBy = "asset_List")
		private Set<Handover> listHandovers;
		
		@OneToMany(mappedBy = "asset_Lists")
		private Set<Pay_Slip> listPay_Slips;
		
		
	public Asset_List() {
		// TODO Auto-generated constructor stub
	}

	public Asset_List(Integer assetID, String assetName, String image, String description, Integer quantity,
			Boolean status) {
		super();
		this.assetID = assetID;
		this.assetName = assetName;
		this.image = image;
		this.description = description;
		this.quantity = quantity;
		this.status = status;
	}

	public Integer getAssetID() {
		return assetID;
	}

	public void setAssetID(Integer assetID) {
		this.assetID = assetID;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Department getDepart() {
		return depart;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<Assets> getListAssets() {
		return listAssets;
	}

	public void setListAssets(Set<Assets> listAssets) {
		this.listAssets = listAssets;
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
