import java.util.ArrayList;;

public class Hotel {

	private static int availableRoomsKing;
	private static int availableRoomsQueen;
	
	private String name;
	private String brief;
	private ArrayList<Room> rooms;
	private ArrayList<Reservation> reservations;
	
	public Hotel(){
		rooms = new ArrayList <Room>();
		reservations = new ArrayList<Reservation>();
		populateRooms();
		populateReservation();
	}
	
	public Hotel(String name){
		this.name = name;
		rooms = new ArrayList <Room>();
		reservations = new ArrayList<Reservation>();
		populateRooms();
		populateReservation();
	}
	
	public Hotel(String name, String brief){
		this.name = name;
		this.brief = brief;
		rooms = new ArrayList<Room>();
		reservations = new ArrayList<Reservation>();
		populateRooms();
		populateReservation();
	}
	
	/**
	 * populates reservation list with some items
	 */
	public void populateReservation(){
		this.reservations.add(new Reservation ("Billie Jean", "200"));
		this.reservations.add(new Reservation ("Neymar Jr", "500"));
		Room room = searchRoom("200");
		room.setAvailability(false);
		room = searchRoom("500");
		room.setAvailability(false);
		Hotel.availableRoomsKing -= 1;
		Hotel.availableRoomsQueen -= 1;
		
	}
	
	/**
	 * populates room list with some items
	 */
	public void populateRooms(){
		this.rooms.add(new Room("200",true,Room.SizeOfBed.QUEENSIZE));
		this.rooms.add(new Room("300",true,Room.SizeOfBed.QUEENSIZE));
		this.rooms.add(new Room("400",true,Room.SizeOfBed.KINGSIZE));
		this.rooms.add(new Room("500",true,Room.SizeOfBed.KINGSIZE));
	
		Hotel.availableRoomsKing += 2;
		Hotel.availableRoomsQueen += 2;
	}
	
	/**
	 * prints the room list
	 */
	public void listRoom(){
		for (int i =0; i < rooms.size(); i++){
			System.out.println("  Room:" + rooms.get(i).getNumber() + " / " + rooms.get(i).getSizeOfBed() 
					+ " / Availability:" + rooms.get(i).getAvailability());
		}
	}
	
	/**
	 * prints the reservation list
	 */
	public void listReservation(){
		for (int i = 0; i < reservations.size(); i++){
			System.out.println(" Reservation: " + reservations.get(i).getRoomNumber() + " / " 
					+ reservations.get(i).getCustomerName());
		}
	}
	
	/**
	 * searches for a Room by its name
	 * @param number
	 * @return a room object
	 */
	public Room searchRoom(String number){
		for(int i = 0; i < rooms.size(); i++){

			if (rooms.get(i).getNumber().equals(number)){
				return rooms.get(i);
			}
		}
		return null;
	}
	
	/**
	 * searches for a Room by its name
	 * @param number
	 * @return index of a Room
	 */
	public int searchRoomBackIndex(String number){
		for (int i = 0; i < rooms.size(); i++){
			
			if(rooms.get(i).getNumber().equals(number)){
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * searches a Reservation by its customer's name
	 * @param customerName
	 * @return Reservation object
	 */
	public Reservation searchReservation(String customerName){
		for (int i = 0; i < reservations.size(); i++){
			
			if (reservations.get(i).getCustomerName().equals(customerName)){
				return reservations.get(i);
			}
		}
		return null;
	}
	
	/**
	 * searches a Reservation by its customer's name
	 * @param customerName
	 * @return reservation's index
	 */
	public int searchReservationBackIndex(String customerName){
		for(int i = 0; i < reservations.size(); i++){

			if (reservations.get(i).getCustomerName().equals(customerName)){
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * removes a reservation from the list
	 * @param customerName
	 */
	public void removeReservation(String customerName){
		Reservation reservation = searchReservation(customerName);
		reservations.remove(reservation);
		Room room = searchRoom(reservation.getRoomNumber());
		room.setAvailability(true);
		if (reservation.getRoomNumber().equals("200") ||
				reservation.getRoomNumber().equals("300") ){
			availableRoomsQueen += 1;
		}
		else {
			availableRoomsKing += 1;
		}
	}
	
	/**
	 * adds a reservation to the list
	 * @param reservation
	 */
	public void addReservation(Reservation reservation){
		reservations.add(reservation);
		Room room = searchRoom(reservation.getRoomNumber());
		room.setAvailability(false);
		if (reservation.getRoomNumber().equals("200") || reservation.getRoomNumber().equals("300")){
			availableRoomsQueen -= 1;
		}
		else{
			availableRoomsKing -= 1;
		}
	}
	
	public static int getTotalAvailableRooms(){
		return availableRoomsKing + availableRoomsQueen;
	}
	
	public static int getAvailableRoomsKing() {
		return availableRoomsKing;
	}
	
	public static void setAvailableRoomsKing(int availableRoomsKing) {
		Hotel.availableRoomsKing = availableRoomsKing;
	}
	
	public static int getAvailableRoomsQueen() {
		return availableRoomsQueen;
	}
	
	public static void setAvailableRoomsQueen(int availableRoomsQueen) {
		Hotel.availableRoomsQueen = availableRoomsQueen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
}
