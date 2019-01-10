package com.sonoma;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sonoma.model.Range;
import com.sonoma.service.RangeOverLap;
import com.sonoma.service.impl.RangeOverLapImpl;

/**
 * @author brijbhushanaggarwal This is test class for testing different scenario
 *         of RangeOverLap
 */
public class RangeOverLapTest {

    Logger logger = LoggerFactory.getLogger(RangeOverLapTest.class);

    RangeOverLap rangeOverLap;

    @Test
    public void rangeOverLapTestWithSingleDigit() {
        logger.info("--------------------------rangeOverLapTestWithSingleDigit------------------------");
        rangeOverLap = new RangeOverLapImpl();
        List<Range> rangeList = new ArrayList<Range>();
        rangeList.add(new Range(8, 9));
        rangeList.add(new Range(4, 5));
        rangeList.add(new Range(5, 6));
        rangeList.add(new Range(1, 2));
        rangeList.add(new Range(2, 3));
        rangeList.add(new Range(3, 4));
        for (Range range : rangeList) {
            logger.info("Input start range: " + range.getStart() + " end range " + range.getEnd());
        }
        rangeList = rangeOverLap.getRange(rangeList);
        List<Range> expectedList = new ArrayList<Range>();
        expectedList.add(new Range(1, 6));
        expectedList.add(new Range(8, 9));
        for (Range range : rangeList) {
            logger.info("Output start range: " + range.getStart() + " end range " + range.getEnd());
        }
        for (Range range : expectedList) {
            logger.info("Expected start range: " + range.getStart() + " end range " + range.getEnd());
        }
        assertEquals(expectedList, rangeList);
        logger.info("--------------------------rangeOverLapTestWithSingleDigit------------------------");
    }

    @Test
    public void rangeOverLapTestWithZip() {
        logger.info("--------------------------rangeOverLapTestWithZip------------------------");
        rangeOverLap = new RangeOverLapImpl();
        List<Range> rangeList = new ArrayList<Range>();
        rangeList.add(new Range(49679, 52015));
        rangeList.add(new Range(49800, 50000));
        rangeList.add(new Range(51500, 53479));
        rangeList.add(new Range(45012, 46937));
        rangeList.add(new Range(54012, 59607));
        rangeList.add(new Range(45500, 45590));
        rangeList.add(new Range(45999, 47900));
        rangeList.add(new Range(44000, 45000));
        rangeList.add(new Range(43012, 45950));
        for (Range range : rangeList) {
            logger.info("Input start range: " + range.getStart() + " end range " + range.getEnd());
        }
        rangeList = rangeOverLap.getRange(rangeList);
        List<Range> expectedList = new ArrayList<Range>();
        expectedList.add(new Range(43012, 47900));
        expectedList.add(new Range(49679, 53479));
        expectedList.add(new Range(54012, 59607));
        for (Range range : rangeList) {
            logger.info("Output start range: " + range.getStart() + " end range " + range.getEnd());
        }
        for (Range range : expectedList) {
            logger.info("Expected start range: " + range.getStart() + " end range " + range.getEnd());
        }
        assertEquals(expectedList, rangeList);
        logger.info("--------------------------rangeOverLapTestWithZip------------------------");
    }

    @Test
    public void rangeOverLapTestWithSortedZip() {
        logger.info("--------------------------rangeOverLapTestWithSortedZip------------------------");
        rangeOverLap = new RangeOverLapImpl();
        List<Range> rangeList = new ArrayList<Range>();
        rangeList.add(new Range(43012, 45950));
        rangeList.add(new Range(44000, 45000));
        rangeList.add(new Range(45012, 46937));
        rangeList.add(new Range(45500, 45590));
        rangeList.add(new Range(45999, 47900));
        rangeList.add(new Range(49679, 52015));
        rangeList.add(new Range(49800, 50000));
        rangeList.add(new Range(51500, 53479));
        rangeList.add(new Range(54012, 59607));

        for (Range range : rangeList) {
            logger.info("Input start range: " + range.getStart() + " end range " + range.getEnd());
        }
        rangeList = rangeOverLap.getRange(rangeList);
        List<Range> expectedList = new ArrayList<Range>();
        expectedList.add(new Range(43012, 47900));
        expectedList.add(new Range(49679, 53479));
        expectedList.add(new Range(54012, 59607));
        for (Range range : rangeList) {
            logger.info("Output start range: " + range.getStart() + " end range " + range.getEnd());
        }
        for (Range range : expectedList) {
            logger.info("Expected start range: " + range.getStart() + " end range " + range.getEnd());
        }
        assertEquals(expectedList, rangeList);
        logger.info("--------------------------rangeOverLapTestWithSortedZip------------------------");
    }

    @Test
    public void rangeOverLapTestWithAdjacentZip() {
        logger.info("--------------------------rangeOverLapTestWithAdjacentZip------------------------");
        rangeOverLap = new RangeOverLapImpl();
        List<Range> rangeList = new ArrayList<Range>();
        rangeList.add(new Range(43012, 43999));
        rangeList.add(new Range(44000, 45000));
        rangeList.add(new Range(45001, 46937));
        rangeList.add(new Range(54012, 59607));

        for (Range range : rangeList) {
            logger.info("Input start range: " + range.getStart() + " end range " + range.getEnd());
        }
        rangeList = rangeOverLap.getRange(rangeList);
        List<Range> expectedList = new ArrayList<Range>();
        expectedList.add(new Range(43012, 46937));
        expectedList.add(new Range(54012, 59607));
        for (Range range : rangeList) {
            logger.info("Output start range: " + range.getStart() + " end range " + range.getEnd());
        }
        for (Range range : expectedList) {
            logger.info("Expected start range: " + range.getStart() + " end range " + range.getEnd());
        }
        assertEquals(expectedList, rangeList);
        logger.info("--------------------------rangeOverLapTestWithAdjacentZip------------------------");
    }

    @Test
    public void emptyTest() {
        logger.info("--------------------------emptyTest------------------------");
        rangeOverLap = new RangeOverLapImpl();
        List<Range> rangeList = new ArrayList<Range>();
        rangeList = rangeOverLap.getRange(rangeList);
        List<Range> expectedList = new ArrayList<Range>();
        logger.info("Range should be retuned as empty result");
        assertEquals(expectedList, rangeList);
        logger.info("--------------------------empty test------------------------");
    }

    @Test
    public void nullTest() {
        logger.info("--------------------------null test------------------------");
        rangeOverLap = new RangeOverLapImpl();
        List<Range> rangeList = null;
        rangeList = rangeOverLap.getRange(rangeList);
        logger.info("Range should be retuned as null");
        assertEquals(null, rangeList);
        logger.info("--------------------------null test------------------------");
    }

}
