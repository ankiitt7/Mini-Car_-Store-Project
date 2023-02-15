package hibernate_mini_car_store_management_project.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
		@Id
		private int carId;
		@Override
		public String toString() {
			return "Car [carId=" + carId + ", carName=" + carName + ", carColor=" + carColor + ", carPrice=" + carPrice
					+ ", carModel=" + carModel + "]";
		}
		private String carName;
		private String carColor;
		private double carPrice;
		private int carModel;
		public int getCarId() {
			return carId;
		}
		public void setCarId(int carId) {
			this.carId = carId;
		}
		public String getCarName() {
			return carName;
		}
		public void setCarName(String carName) {
			this.carName = carName;
		}
		public String getCarColor() {
			return carColor;
		}
		public void setCarColor(String carColor) {
			this.carColor = carColor;
		}
		public double getCarPrice() {
			return carPrice;
		}
		public void setCarPrice(double carPrice) {
			this.carPrice = carPrice;
		}
		public int getCarModel() {
			return carModel;
		}
		public void setCarModel(int carModel) {
			this.carModel = carModel;
		}
	
}
