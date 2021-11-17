import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class MXBean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
		for(GarbageCollectorMXBean garbage: list)
		{
			System.out.println("Name: " + garbage.getName()); 
			System.out.println("Number of collections: " +garbage.getCollectionCount());
			System.out.println("Collection time: " + garbage.getCollectionTime() +"ms");
			System.out.println("Pool names: " );
			
			for(String name: garbage.getMemoryPoolNames())
			{
				System.out.println("\t" + name);
			}
			
			System.out.println();
			
		}
	}

}
