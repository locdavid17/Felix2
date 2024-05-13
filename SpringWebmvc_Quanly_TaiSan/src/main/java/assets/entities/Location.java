package assets.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Location")
public class Location {

		@Id
		@Column(name = "LocationID")
		private String locationID;
		@Column(name = "LocationName")
		private String locationName;
		@Column(name = "City")
		private String city;
		@Column(name = "Country")
		private String country;
		
		@OneToMany(mappedBy = "location")
		private Set<Asset_List> listAsset_Lists;
		
		public Location() {
			// TODO Auto-generated constructor stub
		}

		public Location(String locationID, String locationName, String city, String country) {
			super();
			this.locationID = locationID;
			this.locationName = locationName;
			this.city = city;
			this.country = country;
		}

		public String getLocationID() {
			return locationID;
		}

		public void setLocationID(String locationID) {
			this.locationID = locationID;
		}

		public String getLocationName() {
			return locationName;
		}

		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public Set<Asset_List> getListAsset_Lists() {
			return listAsset_Lists;
		}

		public void setListAsset_Lists(Set<Asset_List> listAsset_Lists) {
			this.listAsset_Lists = listAsset_Lists;
		}
		
}
