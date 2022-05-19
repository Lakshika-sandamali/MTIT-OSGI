package lec_vehicleparkingpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class LEC_VehicleParkingService_Activator implements BundleActivator {

	private static BundleContext context;
	
	ServiceRegistration<?> VehicleParkingServiceReg;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Vehicle parking Publisher Start");
		
		LEC_VehicleParkingService VehiclePPublisherService = new LEC_VehicleParkingServiceIml();
				
		VehicleParkingServiceReg = bundleContext.registerService(
		LEC_VehicleParkingService.class.getName(), VehiclePPublisherService, null);
		
		LEC_VehicleParkingService_Activator.context = bundleContext;
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		LEC_VehicleParkingService_Activator.context = null;
		System.out.println("Vehicle Parking Publisher Stopped !!");
		VehicleParkingServiceReg.unregister();
	}

}
