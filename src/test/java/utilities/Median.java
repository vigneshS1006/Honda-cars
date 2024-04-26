package utilities;

import java.util.Collections;
import java.util.List;

public class Median {
	
	public static double findMedian(List<Double> priceList) {
		
		Collections.sort(priceList);
		System.out.println(priceList);
		int size=priceList.size();
		
		if(size==0) {
			System.err.println("set is empty");
		}
		
		if(size % 2==0) {
			
			int middleIndex1=(size/2)-1;
			int middleIndex2=size/2;
			
		    return (priceList.get(middleIndex1)+ priceList.get(middleIndex2))/2.0;
		}
		
		else {
			int middleIndex=size/2;
			return priceList.get(middleIndex);
		}
	}

}
