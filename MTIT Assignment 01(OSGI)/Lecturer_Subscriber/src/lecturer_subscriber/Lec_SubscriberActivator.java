package lecturer_subscriber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import lec_cafeteriapublisher.LEC_CafeteriaService;
import lec_cafeteriapublisher.LEC_CafeteriaServiceIml;
import lec_vehicleparkingpublisher.LEC_VehicleParkingService;
import lec_vehicleparkingpublisher.LEC_VehicleParkingServiceIml;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Lec_SubscriberActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	ServiceReference<?> VehicleParkingreference;
	ServiceReference<?> Cafeteriareference;

	public void start(BundleContext bundleContext) throws Exception {
		Lec_SubscriberActivator.context = bundleContext;
		
		System.out.println("Lecturer Subscriber started ");
		
		try {
			
			while(true) {
				
				System.out.println("\n---- Welcome to the Channcellor Service ----");
				
				//Enter Passcode
				System.out.println("Enter Your Lecturer Passcode: ");
				
				BufferedReader passcode_in = new BufferedReader(new InputStreamReader(System.in));
				String passcode=passcode_in.readLine();
				
				System.out.println("\n\n------Please select the service------");

				System.out.println("\n1) Vehicle Parking Servcie");
				System.out.println("2) Cafeteria Service");
				
				
				//Service Selecting
				System.out.println("\nEnter the selected Service : ");
				
				BufferedReader service_in = new BufferedReader(new InputStreamReader(System.in));
				int service =Integer.parseInt(service_in.readLine());
				
				if(service == 0) {
					break;
				}
				
				else if(service == 1) {
					
					System.out.println("\n* Welcome to the Vehicle Parking Service -- Check Preffered Parking slot availability) *");
					System.out.println("\nEnter a blank line to exit");
					String slot= "";

					BufferedReader sl = new BufferedReader(new InputStreamReader(System.in));


					while(true) {

					System.out.println("\nSearch for available parking slots here :");
					slot = sl.readLine();

					VehicleParkingreference = context.getServiceReference(LEC_VehicleParkingServiceIml.class.getName());
					LEC_VehicleParkingService vehicleService= (LEC_VehicleParkingService)context.getService(VehicleParkingreference);

					//Exiting the loop if user entered a bank line

					if(slot.length() == 0)
					{
						break;
					}

					//If there is no book then display no
					else if(vehicleService == null)
					{
						System.out.println("\n Sorry Service is currently unavailable..\n");
						//break;
					}

					else if(vehicleService.LEC_VehicleParkingService(slot))
					{
						System.out.println("\nThe slot is available now...");
						//break;

					}

					else {

						System.out.println("\nSorry ..The slot is not available now...");
					//break;
						}
					}
					
				}
				
				else if(service == 2) {
					
					System.out.println("\n* Welcome to the Cafeteria Service *");
					System.out.println("\nEnter a blank line to exit");
					String food= "";

					

					while(true) {

					System.out.println("\nSearch for food here :");
					BufferedReader fl = new BufferedReader(new InputStreamReader(System.in));

					food = fl .readLine();

					Cafeteriareference = context.getServiceReference(LEC_CafeteriaServiceIml.class.getName());
					LEC_CafeteriaService CafeteriaService= (LEC_CafeteriaService)context.getService(Cafeteriareference);

					//Exiting the loop if user entered a bank line

					if(food.length() == 0)
					{
						break;
					}

					//If there is no book then display no
					else if(CafeteriaService == null)
					{
						System.out.println("\n Sorry Service is currently unavailable..\n");
						//break;
					}

					else if(CafeteriaService.LEC_CafeteriaService(food))
					{
						System.out.println("\nThe food is available in the cafeteria ...");
						//break;

					}

					else {

					System.out.println("\nSorry ..The food is not available in the cafeteria ...");
					//break;
						}
					}
					
				}
				
				else {
					System.out.println("Error !!");
				}
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Lec_SubscriberActivator.context = null;
		System.out.println("Lecturer Subscriber stopped !!");
	}

}
