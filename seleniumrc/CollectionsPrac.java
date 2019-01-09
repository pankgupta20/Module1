import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionsPrac {

	public static void main(String[] args) {
		int i[] = {12,34,56,2,90,9};
		
		List<int[]> ll = Arrays.asList(i);
		
		Iterator<int[]> itr = ll.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		Collections.rotate(ll, 2);
		
		Iterator<int[]> itr1 = ll.iterator();
		while(itr1.hasNext()){
			System.out.println(itr1.next());
		}
	}
}



