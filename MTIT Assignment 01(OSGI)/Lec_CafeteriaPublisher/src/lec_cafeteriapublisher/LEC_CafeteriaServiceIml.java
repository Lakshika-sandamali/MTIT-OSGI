package lec_cafeteriapublisher;

public class LEC_CafeteriaServiceIml implements LEC_CafeteriaService{
	
	String[] Foods = {
			"food1", "food2", "food3", "food4",
			"food5", "food6", "food7", "food8",
	};

	@Override
	public boolean LEC_CafeteriaService(String cafeteria) {
		// TODO Auto-generated method stub
		
		cafeteria = cafeteria.toLowerCase();
		
		for(int i=0; i<Foods.length; i++)
		{
			if(Foods[i].equals(cafeteria))
			{
				return true;
			}
		}
		
		return false;
	}

}
