package com.sonoma.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sonoma.model.Range;
import com.sonoma.service.RangeOverLap;
import com.sonoma.utils.RangeComparator;

/**
 * @author brijbhushanaggarwal This class implements RangeOverLap
 */
public class RangeOverLapImpl implements RangeOverLap {

    /*
     * (non-Javadoc)
     * 
     * @see com.sonoma.service.RangeOverLap#getRange(java.util.List) this method
     * accepts range list in any order and converts it in one list that does not
     * overlap
     */
    public List<Range> getRange(List<Range> rangeList) {

        if (rangeList == null || rangeList.isEmpty() || rangeList.size() == 1) {
            return rangeList;
        }
        List<Range> list = new ArrayList<Range>();
        if (!checkSorted(rangeList)) {
            // sort the range using the comparator
            Collections.sort(rangeList, new RangeComparator());

        }
        // get min and max
        int min = rangeList.get(0).getStart();
        int max = rangeList.get(0).getEnd();
        for (int i = 0; i < rangeList.size() - 1; i++) {
            // continue the range till the condition matches
            if ((max >= rangeList.get(i + 1).getStart()) || (max + 1) >= rangeList.get(i + 1).getStart()) {
                // set the max, from the current and next range
                if (max >= rangeList.get(i + 1).getEnd()) {
                    max = rangeList.get(i).getEnd();
                } else {
                    max = rangeList.get(i + 1).getEnd();
                }

            } else {
                // add the range that does not over lap
                Range r = new Range(min, max);
                list.add(r);
                // set the new min and max for next range
                min = rangeList.get(i + 1).getStart();
                max = rangeList.get(i + 1).getEnd();
            }
            // check for adding the last range
            if (i == rangeList.size() - 2) {
                Range r = new Range(min, max);
                list.add(r);
            }
        }
        return list;
    }

    /**
     * @param rangeList
     * @return this method returns true, if the list is already sorted, false if not
     *         sorted
     */
    private boolean checkSorted(List<Range> rangeList) {
        for (int i = 0; i < rangeList.size() - 1; i++) {
            if (!(rangeList.get(i).getStart() < rangeList.get(i + 1).getStart())) {
                return false;
            }
        }
        return true;
    }

}
