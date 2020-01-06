package application;

import java.util.Comparator;

public class Sorting implements Comparator<Images> {

	@Override
	public int compare(Images o1, Images o2) {
		if (o1 == null)
			return -1;
		if (o1.getRedLevel() > o2.getRedLevel())
			return -1;
		else if (o1.getRedLevel() < o2.getRedLevel())
			return 1;

		else
			return 0;

	}

}