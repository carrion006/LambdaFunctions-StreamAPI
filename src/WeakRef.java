import java.lang.ref.WeakReference;

public class WeakRef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person person = new Person();
		WeakReference<Person> wr = new WeakReference<Person>(person);
		
		Person p1 = wr.get();
		System.out.println(p1);

		p1=null;
		person=null;
		
		Person p2 = wr.get();
		System.out.println(p2);
		
		p2=null;
		System.gc();
		
		Person p3 = wr.get();
		System.out.println(p3);
	}

}

class Person{
	
}
