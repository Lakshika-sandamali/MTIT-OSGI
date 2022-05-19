package lec_vehicleparkingpublisher;

public class LEC_VehicleParkingServiceIml implements LEC_VehicleParkingService{

	String[] Parking_Slots = {
			"slot1", "slot2", "slot3", "slot4",
			"slot5", "slot6", "slot7", "slot8",
			"slot9", "slot10", "slot11", "slot12",
			"slot13", "slot14", "slot15", "slot16",
			"slot17", "slot18", "slot19", "slot20",
	};
	
	@Override
	public boolean LEC_VehicleParkingService(String slot) {
		// TODO Auto-generated method stub
		slot = slot.toLowerCase();
		
		for(int i=0; i<Parking_Slots.length; i++)
		{
			if(Parking_Slots[i].equals(slot))
			{
				return true;
			}
		}
		
		return false;
	}

}
