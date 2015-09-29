import java.util.Scanner;

public class Driver {
	
	static HotelDatabase hotelDatabase = new HotelDatabase();

	public static void main(String[] args) {
		populateHotelList();
		menu();
	}

	public static void menu(){
		int option = 0;

		do{
			System.out.println("1. List the hotels in the city");
			System.out.println("2. Get the # of available rooms in the city with queen-sized beds");
			System.out.println("3. Get the # of available rooms in the city with king-sized beds");
			System.out.println("4. Get the total # of available rooms in the city");
			System.out.println("5. Get the total # of rooms in the city (available or otherwise)");
			System.out.println("\nPlease enter a number for one of the options given above: ");

			Scanner scan = new Scanner(System.in);
			option = scan.nextInt();

		} while (option < 0 && option > 6);
		optionMenu(option);
	}

	public static void optionMenu(int option){

		if (option == 1){
			hotelMenu();
		}
		else if (option == 2){
			hotelDatabase.showQueenSizeAvailableRooms();
			menu();
		}
		else if (option == 3){
			hotelDatabase.showKingSizeAvailableRooms();
			menu();
		}
		else if (option ==4){
			hotelDatabase.showTotalAvailableRooms();
			menu();
		}
		else if (option == 5){
			hotelDatabase.showTotalRooms();
			menu();
		}
		else{
			System.out.println("Invalid option.");
			menu();
		}
	}

	public static void hotelMenu (){
		int option = 0;

		do{
			hotelDatabase.listHotel();
			System.out.println("1. Delete a Hotel");
			System.out.println("2. Add a Hotel");
			System.out.println("3. Show Hotel Info");
			System.out.println("4. View Reservation Menu");
			System.out.println("5. Return to Main Menu");

			Scanner scan = new Scanner(System.in);
			option = scan.nextInt();
			
		} while(option < 0 && option > 6);
		
		hotelOptionMenu(option);
	}

	public static void hotelOptionMenu(int option){
		switch(option){
		case 1: 
			String toBeRemoved = null;
			System.out.print("Enter the name of the hotel to be removed:");
			Scanner scan = new Scanner(System.in);
			toBeRemoved = scan.nextLine();
			hotelDatabase.removeHotel(toBeRemoved);
			hotelMenu();
			break;
		
		case 2:
			String toBeAdded, brief = null;
			System.out.print("Enter the name of the hotel to be added:");
			Scanner scan2 = new Scanner(System.in);
			toBeAdded = scan2.nextLine();
			brief = scan2.nextLine();
			Hotel hotel = new Hotel(toBeAdded, brief);
			hotelDatabase.addHotel(hotel);
			hotelMenu();
			break;
		
		case 3:
			String toBeShowed = null;
			System.out.print("Enter the name of the hotel to be showed:");
			Scanner scan3 = new Scanner(System.in);
			toBeShowed = scan3.nextLine();
			hotelDatabase.showHotelInfo(toBeShowed);
			hotelMenu();
			break;
			
		case 4:
			reservationMenu();
			break;
			
		case 5:
			menu();
			break;
			
		default:
			hotelOptionMenu(option);
		}
	}
	
	public static void reservationMenu(){
		int option = 0;
		do{
			hotelDatabase.listHotel();
			System.out.println("1. Get the # of available rooms in the hotel with queen-sized beds");
			System.out.println("2. Get the # of available rooms in the hotel with king-sized beds");
			System.out.println("3. Get the total # of available rooms in the hotel");
			System.out.println("4. Reserve Room ");
			System.out.println("5. Cancel Reservation");
			System.out.println("6. Modify Reservation");
			System.out.println("7. Back to Hotel Menu");
			System.out.println("8. Back to Main Menu");
			
			Scanner scan4 = new Scanner(System.in);
			option = scan4.nextInt();
			
		}while(option < 0 && option > 5);
		
		reservationOptionMenu(option);
	}
	
	public static void reservationOptionMenu(int option){
		switch (option){
		case 1:
			String hotelName3 = null;
			int aux = 0;
			System.out.print("Enter the hotel's name: ");
			Scanner scan8 = new Scanner (System.in);
			hotelName3 = scan8.nextLine();
			Hotel hotel4 = hotelDatabase.searchHotel(hotelName3);
			for (int i = 0; i < hotel4.getRooms().size(); i++){
				if (hotel4.getRooms().get(i).getAvailability() == true){
					if(hotel4.getRooms().get(i).getSizeOfBed() == Room.SizeOfBed.QUEENSIZE){
						aux++;
					}
				}
				
			}
			System.out.println(aux);
			reservationMenu();
			break;
			
		case 2:
			String hotelName4 = null;
			int aux1 = 0;
			System.out.print("Enter the hotel's name: ");
			Scanner scan9 = new Scanner (System.in);
			hotelName4 = scan9.nextLine();
			Hotel hotel5 = hotelDatabase.searchHotel(hotelName4);
			for (int i = 0; i < hotel5.getRooms().size(); i++){
				if (hotel5.getRooms().get(i).getAvailability() == true){
					if(hotel5.getRooms().get(i).getSizeOfBed() == Room.SizeOfBed.KINGSIZE){
						aux1++;
					}
				}
				
			}
			System.out.println(aux1);
			reservationMenu();
			break;
			
		case 3:
			String hotelName5 = null;
			int aux2 = 0;
			System.out.print("Enter the hotel's name: ");
			Scanner scan10 = new Scanner (System.in);
			hotelName5 = scan10.nextLine();
			Hotel hotel6 = hotelDatabase.searchHotel(hotelName5);
			for (int i = 0; i < hotel6.getRooms().size(); i++){
				if (hotel6.getRooms().get(i).getAvailability() == true){
					aux2++;
				}
				
			}
			System.out.println(aux2);
			reservationMenu();
			break;
		case 4:
			String hotelName, roomNumber, customerName = null;
			System.out.print("Enter the hotel's name: ");
			Scanner scan5 = new Scanner(System.in);
			hotelName = scan5.nextLine();
			hotelDatabase.showHotelInfo(hotelName);
			System.out.print("Enter the room number: ");
			roomNumber = scan5.nextLine();
			System.out.print("Enter your name: ");
			customerName = scan5.nextLine();
			
			Hotel hotel = hotelDatabase.searchHotel(hotelName);
			Reservation reservation = new Reservation(customerName, roomNumber);
			hotel.addReservation(reservation);
			
			reservationMenu();
			break;
			
		case 5:
			String hotelName1, customerName1 = null;
			System.out.print("Enter the hotel's name:");
			Scanner scan6 = new Scanner(System.in);
			hotelName1 = scan6.nextLine();
			hotelDatabase.showHotelInfo(hotelName1);
			System.out.print("Enter your name: ");
			customerName1 = scan6.nextLine();
			Hotel hotel1 = hotelDatabase.searchHotel(hotelName1);
			hotel1.removeReservation(customerName1);
			reservationMenu();
			break;
			
		case 6:
			int indexHotel, indexReservation, indexRoom;
			String hotelName2, roomNumber2, customerName2, oldRoomNumber = null;
			System.out.print("Enter the hotel's name: ");
			Scanner scan7 = new Scanner(System.in);
			hotelName2 = scan7.nextLine();
			hotelDatabase.showHotelInfo(hotelName2);
			System.out.print("Enter your name: ");
			customerName2 = scan7.nextLine();
			System.out.print("Enter the new room number: ");
			roomNumber2 = scan7.nextLine();
			
			Hotel hotel2 = hotelDatabase.searchHotel(hotelName2);
			indexReservation = hotel2.searchReservationBackIndex(customerName2);
			oldRoomNumber = hotel2.getReservations().get(indexReservation).getRoomNumber();
			indexRoom = hotel2.searchRoomBackIndex(oldRoomNumber);
			indexHotel = hotelDatabase.searchHotelBackIndex(hotelName2);
			if (hotel2.getReservations().get(indexReservation).getCustomerName().equals(customerName2)){
				
				hotel2.getRooms().get(indexRoom).setAvailability(true);
				hotel2.getReservations().get(indexReservation).setRoomNumber(roomNumber2);
				hotel2.getRooms().get(hotel2.searchRoomBackIndex(roomNumber2)).setAvailability(false); // index do novo room.
			}
			reservationMenu();
			break;
			
		case 7:
			hotelMenu();
			break;
			
		case 8:
			menu();
			break;
		}
	}
	
	public static void populateHotelList(){
		hotelDatabase.addHotel(new Hotel("Holliday Inn", "Very good, five stars!"));
		hotelDatabase.addHotel(new Hotel("Days Inn", "Not bad, three stars!"));
	}
}

