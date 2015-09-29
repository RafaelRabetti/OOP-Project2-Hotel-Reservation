
public class Reservation {

	private String customerName;
	private String roomNumber;
	
	public Reservation(String customerName, String roomNumber){
		this.customerName = customerName;
		this.roomNumber = roomNumber;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
	
