package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sonoma.model.Range;
import com.sonoma.service.RangeOverLap;
import com.sonoma.service.impl.RangeOverLapImpl;


/**
 * @author brijbhushanaggarwal
 *This is test class for testing different scenario of RangeOverLap
 */
public class RangeOverLapTest {
	
	
	RangeOverLap rangeOverLap;
	
	@Test
	public void myTest(){
		System.out.println("--------------------------my test------------------------");  
		rangeOverLap=new RangeOverLapImpl();
		List<Range> rangeList= new ArrayList<Range>();
		rangeList.add(new Range(8,9));
		rangeList.add(new Range(4,5));
		rangeList.add(new Range(5,6));
		rangeList.add(new Range(1,2));
		rangeList.add(new Range(2,3));
		rangeList.add(new Range(3,4));
		for(Range range:rangeList) {
			System.out.println("Input start range: "+range.getStart()+" end range "+range.getEnd());
		}
		rangeList=rangeOverLap.getRange(rangeList);
		List<Range> expectedList=new ArrayList<Range>();
		expectedList.add(new Range(1,6));
		expectedList.add(new Range(8,9));
		for(Range range:rangeList) {
			System.out.println("Output start range: "+range.getStart()+" end range "+range.getEnd());
		}
		for(Range range:expectedList) {
			System.out.println("Expected start range: "+range.getStart()+" end range "+range.getEnd());
		}
		assertEquals(expectedList,rangeList);
		System.out.println("--------------------------my test------------------------");  
	}
	
	@Test
	public void myValidTest(){
		System.out.println("--------------------------my valid test------------------------");  
		rangeOverLap=new RangeOverLapImpl();
		List<Range> rangeList= new ArrayList<Range>();
		rangeList.add(new Range(49679, 52015));
		rangeList.add(new Range(49800, 50000));
		rangeList.add(new Range(51500, 53479));
		rangeList.add(new Range(45012, 46937));
		rangeList.add(new Range(54012, 59607));
		rangeList.add(new Range(45500, 45590));
		rangeList.add(new Range(45999, 47900));
		rangeList.add(new Range(44000, 45000));
		rangeList.add(new Range(43012, 45950));
		for(Range range:rangeList) {
			System.out.println("Input start range: "+range.getStart()+" end range "+range.getEnd());
		}
		rangeList=rangeOverLap.getRange(rangeList);
		List<Range> expectedList=new ArrayList<Range>();
		expectedList.add(new Range(43012, 47900));
		expectedList.add(new Range(49679, 53479));
		expectedList.add(new Range(54012, 59607));
		for(Range range:rangeList) {
			System.out.println("Output start range: "+range.getStart()+" end range "+range.getEnd());
		}
		for(Range range:expectedList) {
			System.out.println("Expected start range: "+range.getStart()+" end range "+range.getEnd());
		}
		assertEquals(expectedList,rangeList);
		System.out.println("--------------------------my valid test------------------------");  
	}
	
	@Test
	public void emptyTest() {
		System.out.println("--------------------------empty test------------------------");  
		rangeOverLap=new RangeOverLapImpl();
		List<Range> rangeList= new ArrayList<Range>();
		rangeList=rangeOverLap.getRange(rangeList);
		System.out.println("Range should be retuned as null");
		assertEquals(null,rangeList);
		System.out.println("--------------------------empty test------------------------");  
	}
	
	@Test
	public void nullTest() {
		System.out.println("--------------------------null test------------------------");  
		rangeOverLap=new RangeOverLapImpl();
		List<Range> rangeList= null;
		rangeList=rangeOverLap.getRange(rangeList);
		System.out.println("Range should be retuned as null");
		assertEquals(null,rangeList);
		System.out.println("--------------------------null test------------------------");  
	}

}
