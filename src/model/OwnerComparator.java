package model;

import java.util.Comparator;

public class OwnerComparator implements Comparator<Owner> {
	
	@Override
	public int compare(Owner owner1, Owner owner2) {
		int comparator;
		String id1 = owner1.getId();
		String id2 = owner2.getId();
		
		if (id1.compareTo(id2) < 0) {
			comparator = -1;
		} else if (id1.compareTo(id2) > 0) {
			comparator = 1;
		} else {
				comparator = 0;
		}
		return comparator;
	}
}