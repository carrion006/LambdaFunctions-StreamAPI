import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.*;


public class RefQueue {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Person2 p = new Person2();
		final ReferenceQueue<Person2> referenceQueue = new ReferenceQueue<Person2>();
		PersonCleaner cleaner = new PersonCleaner();
		PersonWeakReference weakreference =  new PersonWeakReference(p, cleaner, referenceQueue);
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					PersonWeakReference  wr = (PersonWeakReference) referenceQueue.remove();
					wr.clean();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		} );
		
		p = null;
		System.gc();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press any key to continue");
		br.readLine();
		executorService.shutdown();
		
	}

}

final class Person2{
	
}

class PersonCleaner{

	public void clean() {
		// TODO Auto-generated method stub
		System.out.println("Cleaned");
		
	}
	
}

class PersonWeakReference extends WeakReference<Person2>
{
	PersonCleaner cleaner;
	public PersonWeakReference(Person2 referent, PersonCleaner cleaner, ReferenceQueue<? super Person2> q) {
		super(referent, q);
		// TODO Auto-generated constructor stub
		this.cleaner = cleaner;
	}
	
	public void clean() {
		cleaner.clean();
	}
	
}
