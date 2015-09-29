
public class Room {
	
	public enum SizeOfBed{
		QUEENSIZE, KINGSIZE;
	}
	
	private String number;
	private boolean availability;
	private SizeOfBed sizeOfBed;
	
	
	public Room(String number, boolean bool, SizeOfBed sizeOfBed){
		this.number = number;
		this.availability = bool ;
		this.sizeOfBed = sizeOfBed;
	}
	
	public String ToString(){
		return "Hotel Rooms: " + sizeOfBed;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean getAvailability() {
		return availability;
	}
	
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public SizeOfBed getSizeOfBed() {
		return sizeOfBed;
	}

	public void setSizeOfBed(SizeOfBed sizeOfBed) {
		this.sizeOfBed = sizeOfBed;
	}

	

}
