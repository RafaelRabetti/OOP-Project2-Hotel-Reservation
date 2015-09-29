import java.util.ArrayList;

public class HotelDatabase {

	private ArrayList <Hotel> hotels;

	public HotelDatabase(){
		hotels = new ArrayList <Hotel>();
	}
	
	/**
	 *Method that return the total of the rooms list either available or not 
	 * @return total of rooms
	 */
	public int totalOfRooms(){
		int result = 0;
		for (int i = 0 ; i < hotels.size(); i++){
			result += hotels.get(i).getRooms().size();
		}
		return result;
	}

	public ArrayList<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}
	
    /**
     * method that adds a hotel to the list
     * @param hotel
     */
	public void addHotel(Hotel hotel){
		hotels.add(hotel);
	}
	
	/**
	 * method that removes a hotel from the list by its name
	 * @param name
	 */
	public void removeHotel(String name){
		Hotel hotel = searchHotel(name);
		hotels.remove(hotel);
		Hotel.setAvailableRoomsKing(Hotel.getAvailableRoomsKing()-2);
		Hotel.setAvailableRoomsQueen(Hotel.getAvailableRoomsQueen()-2);
	}

	/**
	 * method that searches for a hotel in the list
	 * @param name
	 * @return the hotel
	 */
	public Hotel searchHotel(String name){
		for(int i = 0; i < hotels.size(); i++){

			if (hotels.get(i).getName().equals(name)){
				return hotels.get(i);
			}
		}
		return null;
	}
	
	/**
	 * method that searches for a hotel in the list
	 * @param name
	 * @return the index of the hotel on the list
	 */
	public int searchHotelBackIndex(String name){
		for(int i = 0; i < hotels.size(); i++){

			if (hotels.get(i).getName().equals(name)){
				return i;
			}
		}
		return 0;
	}

	/**
	 * prints the list of hotels
	 */
	public void listHotel(){
		for(int i = 0; i < hotels.size(); i++){
			System.out.println(hotels.get(i).getName());
		}
	}

	/**
	 * Show the hotels information and its rooms and reservations
	 * @param name
	 */
	public void showHotelInfo(String name){
		Hotel hotel = searchHotel(name);
		System.out.println("Hotel: " + hotel.getName() + "\nDescription: " 
				+ hotel.getBrief());
		System.out.println( "\nHotel Rooms: ");
		hotel.listRoom();
		System.out.println("\n-----------");
		hotel.listReservation();
		System.out.println("\n-----------");
	}
	
	public void showKingSizeAvailableRooms(){
		System.out.println(Hotel.getAvailableRoomsKing());
	}

	public void showQueenSizeAvailableRooms(){
		System.out.println(Hotel.getAvailableRoomsQueen());
	}

	public void showTotalAvailableRooms(){
		System.out.println(Hotel.getTotalAvailableRooms());
	}
	
	public void showTotalRooms(){
		System.out.println(totalOfRooms());
	}

}