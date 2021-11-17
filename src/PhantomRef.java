import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class PhantomRef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReferenceQueue<Person3> queue = new ReferenceQueue<Person3>();
		ArrayList<FinalizePerson> list = new ArrayList<FinalizePerson>();
		ArrayList<Person3> people = new ArrayList<Person3>();
		
		for(int i=0; i< 10; i++) {
			Person3 p = new Person3();
			people.add(p);
			list.add(new FinalizePerson(p, queue));
		}
		
		people = null;
		System.gc();
		
		for(PhantomReference<Person3> ref : list)
		{
			System.out.println(ref.isEnqueued());
		}
		
		Reference<? extends Person3> referenceFromQueue;
		while((referenceFromQueue = queue.poll()) != null) {
			((FinalizePerson) referenceFromQueue).cleanup();
		}
		
	}

}


class FinalizePerson extends PhantomReference<Person3>
{

	public FinalizePerson(Person3 referent, ReferenceQueue<? super Person3> q) {
		super(referent, q);
		// TODO Auto-generated constructor stub
	}
	 
	public void cleanup() {
		System.out.println("Person is finalizing resources");
	}
	
}

class Person3 {
	
}