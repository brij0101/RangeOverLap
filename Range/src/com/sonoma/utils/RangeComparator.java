package com.sonoma.utils;

import java.util.Comparator;

import com.sonoma.model.Range;

/**
 * @author brijbhushanaggarwal
 *this util class is used to sort the range in ascending order based on start range
 */
public class RangeComparator implements Comparator<Range>{

	@Override
	public int compare(Range o1, Range o2) {
		return o1.getStart()-o2.getStart();
	}

}
