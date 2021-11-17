import java.util.Date;
import java.util.WeakHashMap;

public class WeakHashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WeakHashMap<Person1, PersonMetaData> weakHashMap = new WeakHashMap<Person1, PersonMetaData>();
		Person1 sam = new Person1();
		weakHashMap.put(sam, new PersonMetaData());
		
		PersonMetaData p = weakHashMap.get(sam);
		
		System.out.println(p);
		
		sam = null;
		System.gc();
		
		if(weakHashMap.containsKey(p))
			System.out.println("Still contains Key");
		else
			System.out.println("Key has gone");		
		
	}

}


class PersonMetaData{
	
	Date date;
	
	PersonMetaData(){
		date = new Date();
	}

	@Override
	public String toString() {
		return "PersonMetaData [date=" + date + "]";
	}	
	
}
final class Person1 {
	
}

