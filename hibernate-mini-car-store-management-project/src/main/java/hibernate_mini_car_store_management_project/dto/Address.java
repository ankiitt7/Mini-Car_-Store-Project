package hibernate_mini_car_store_management_project.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	
		@Id
		private  int adressId;
		private String cityName;
		@Override
		public String toString() {
			return "Address [adressId=" + adressId + ", cityName=" + cityName + ", streetNumber=" + streetNumber
					+ ", flatNumber=" + flatNumber + ", townNumber=" + townNumber + "]";
		}
		private String streetNumber;
		private  String flatNumber;
		private String townNumber;
		public int getAdressId() {
			return adressId;
		}
		public void setAdressId(int adressId) {
			this.adressId = adressId;
		}
		public String getCityName() {
			return cityName;
		}
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
		public String getStreetNumber() {
			return streetNumber;
		}
		public void setStreetNumber(String streetNumber) {
			this.streetNumber = streetNumber;
		}
		public String getFlatNumber() {
			return flatNumber;
		}
		public void setFlatNumber(String flatNumber) {
			this.flatNumber = flatNumber;
		}
		public String getTownNumber() {
			return townNumber;
		}
		public void setTownNumber(String townNumber) {
			this.townNumber = townNumber;
		}
		
}
