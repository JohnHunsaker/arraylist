
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Application class to allow the user to implement database of NationalParks.
 */
public class ParkProgram {
	
	public static void main(String[] args) throws ParseException{
		int choice = 0;

		while (choice != 4) {
			System.out.println("Main Menu: ");
			System.out.println("1. Add parks to database");
			System.out.println("2. Show collection");
			System.out.println("3. Remove parks");
			System.out.println("4. Quit");

			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			
			ArrayList array = new ArrayList();
			String input = "";

			switch (choice) {
				
				case 1:
					System.out.println("Please enter a national park "
					 + "(one per line) in the following way: ");
					System.out.println("Park Name, Area, Visitors, "
					 + "Creation Date(YYYY-MM-DD), Location, Latitude, "
					 + "Longitude.");
					System.out.println("Type \"done\" when there are"
					 + " no more parks to be added.");
					while (true) {
						Scanner scn = new Scanner(System.in);
						input = scn.nextLine();
						if (input.equals("done")) {
							break;
						}

						SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");
						String splitter[];
						splitter = input.split(", ");

						String name = splitter[0];
						double area = Double.parseDouble(splitter[1]);
						int visitors = Integer.parseInt(splitter[2]);
						Date creationDate = dates.parse(splitter[3]);
						String location = splitter[4];
						float latitude = Float.parseFloat(splitter[5]);
						float longitude = Float.parseFloat(splitter[6]);

						array.addFirst(new NationalPark(name, area, visitors,
						 creationDate, location, latitude, longitude));
					}
					break;
					
				case 2:
					System.out.println("These are the parks in your database: ");
					for (int i = 0; i < array.getCount(); i++) {
						System.out.println(array.get(i));
					}
					break;
					
				case 3:
					System.out.println("These are the parks in your database: ");
					for (int i = 0; i < array.getCount(); i++) {
						System.out.print("" + i + 1 + ".  ");
						System.out.println(array.get(i));
					}
					while (true) {
						System.out.println("Please enter the number of the park"
						 + "you want to remove, or type \"finished\" to return "
						 + "to main menu.: ");
					   Scanner scnn = new Scanner(System.in);
					   String numberRemove = scnn.nextLine();
						if (numberRemove.equals("finished")) {
							break;
						}
						int numRem = Integer.parseInt(numberRemove);
					   array.removeAt(numRem - 1);
						System.out.println("Park number " + numRem + "has "
						 + "been removed.");
					}
					break;
					
				case 4:
					System.out.println("You have now exited the program. Bye!");
					System.exit(0);
				default:
					System.out.println("Please enter a number i.e. \"2\"");
					break;
			}
		}
	}
}