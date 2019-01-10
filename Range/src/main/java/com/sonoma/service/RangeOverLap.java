package com.sonoma.service;

import java.util.List;

import com.sonoma.model.Range;

/**
 * @author brijbhushanaggarwal This is an interface for getting range for the
 *         specified Range list
 */
public interface RangeOverLap {

    public List<Range> getRange(List<Range> rangeList);

}
