package uebung2;

public class SetIntersection {

	
	
	public static int countIntersectionUnsorted (int[] unsorted, int[] unsorted2 )
	{
		int countSame  =0;
		for(int value1 : unsorted)
		{
			for (int value2 : unsorted2)
			{
				if(value1 == value2)
				{
					countSame++;
					continue;
				}				
			}
		}
		return countSame;		
	}
	
	
	public static int countIntersectionOneInputOrdered(int[] unsorted, int[] sorted)
	{
		int count= 0;
		
		for(int value1 : unsorted)
		{			
			if(sorted[0] == value1)
			{
				count++;
				continue;
			}
			if(sorted[sorted.length-1] == value1)
			{
				count++;
				continue;
			}
			if(sorted[0] > value1)
			{
				continue;
			}
			if(sorted[sorted.length-1] < value1)
			{
				continue;
			}
			
			int lo =0 ;
			int hi = sorted.length-1;
			boolean found = false;			
			while(lo<=hi && !found){
				int middle = (lo+hi)/2;
				if(sorted[middle]==value1)
				{
					count ++;
					found = true;
					continue;
				}
				if(sorted[middle] > value1)
				{
					hi = middle +1;
					continue;
				}
				if(sorted[middle] < value1)
				{
					lo = middle +1;
					continue;
				}				
			}			
		}		
		return count;
	}	
	
}
