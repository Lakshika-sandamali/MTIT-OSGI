package lec_cafeteriapublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class LEC_CafeteriaPublisherActivator implements BundleActivator {

	private static BundleContext context;
	
	ServiceRegistration<?> CafeteriaRegistration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Cafeteria Start");
		
		LEC_CafeteriaService CafetariaService = new LEC_CafeteriaServiceIml();
						
		CafeteriaRegistration = bundleContext.registerService(
		LEC_CafeteriaService.class.getName(), CafetariaService, null);
		
		LEC_CafeteriaPublisherActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Cafeteria  Stop");
		CafeteriaRegistration.unregister();	
	
		
	}

}
