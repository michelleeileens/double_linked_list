import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_TestStudent {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Car> sortedLinkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	public double p=55.32, q=64.54, r=23.78, s=67.85, t=58.65;
		
	public String s1="Carrie";
	public String s2="Grey";
	public String s3="William";
	public String s4="Toni";
	public String s5="Joan";
	public String s6="Maya";
		
		
	public Car a=new Car("Ford", "F150", 2005);
	public Car b=new Car("Jeep", "Renegade", 2005);
	public Car c=new Car("Honda", "Civic", 2005);
	public Car d=new Car("Subaru", "Outback", 2005);
	public Car e=new Car("Chevrolet", "Silverado", 2005);
	public Car f=new Car("Chrysler", "PTCruiser", 2005);
	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorCar = new CarComparator();
		sortedLinkedCar = new SortedDoubleLinkedList<Car>(comparatorCar);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorCar = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedCar = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd(s1);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedDouble.addToFront(p);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedDouble.add(p);
		sortedLinkedDouble.add(t);
		sortedLinkedDouble.add(r);
		sortedLinkedDouble.add(q);
		ListIterator<Double> iteratorD = sortedLinkedDouble.iterator();
		assertEquals(true, iteratorD.hasNext());
		assertEquals(r, iteratorD.next(),.0);
		assertEquals(p, iteratorD.next(),.0);
		assertEquals(t, iteratorD.next(),.0);
		assertEquals(true, iteratorD.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add(s1);
		sortedLinkedString.add(s4);
		sortedLinkedString.add(s2);
		sortedLinkedString.add(s6);
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(s1, iterator.next());
		assertEquals(s2, iterator.next());
		assertEquals(s6, iterator.next());
		assertEquals(s4, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(s4, iterator.previous());
		assertEquals(s6, iterator.previous());
		assertEquals(s2, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulCarPrevious() {
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(d);
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(d, iterator.previous());
		assertEquals(b, iterator.previous());
		assertEquals(c, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(r);
		sortedLinkedDouble.add(t);
		sortedLinkedDouble.add(s);
		sortedLinkedDouble.add(p);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(r, iterator.next(),.0);
		assertEquals(p, iterator.next(),.0);
		assertEquals(t, iterator.next(),.0);
		assertEquals(true, iterator.hasNext());	
	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(t);
		sortedLinkedDouble.add(s);
		sortedLinkedDouble.add(r);
		sortedLinkedDouble.add(q);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(r, iterator.next(),.0);
		assertEquals(t, iterator.next(),.0);
		assertEquals(q, iterator.next(),.0);
		assertEquals(true, iterator.hasPrevious());
		assertEquals(q, iterator.previous(),.0);
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedString.add(s4);
		sortedLinkedString.add(s1);
		sortedLinkedString.add(s5);
		sortedLinkedString.add(s3);
		
		ListIterator<String> iteratorS = sortedLinkedString.iterator();
		
		assertEquals(true, iteratorS.hasNext());
		assertEquals(s1 ,iteratorS.next());
		assertEquals(s5, iteratorS.next());
		assertEquals(s4, iteratorS.next());
		assertEquals(true, iteratorS.hasNext());
		assertEquals(s3, iteratorS.next());
		try{
			//no more elements in list
			iteratorS.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedString.add(s3);
		sortedLinkedString.add(s1);
		
		ListIterator<String> iteratorS = sortedLinkedString.iterator();
		
		try{
			iteratorS.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddDouble() {
		sortedLinkedDouble.add(p);
		sortedLinkedDouble.add(t);
		sortedLinkedDouble.add(q);
		assertEquals(p, sortedLinkedDouble.getFirst(),.0);
		assertEquals(q, sortedLinkedDouble.getLast(),.0);
		sortedLinkedDouble.add(r);
		sortedLinkedDouble.add(s);
		assertEquals(r, sortedLinkedDouble.getFirst(),.0);
		assertEquals(s, sortedLinkedDouble.getLast(),.0);
		assertEquals(s,sortedLinkedDouble.retrieveLastElement(),.0);
		assertEquals(q, sortedLinkedDouble.getLast(),.0);
	}

	@Test
	public void testRemoveFirstString() {
		sortedLinkedString.add(s5);
		sortedLinkedString.add(s2);
		assertEquals(s2, sortedLinkedString.getFirst());
		assertEquals(s5, sortedLinkedString.getLast());
		sortedLinkedString.add(s1);
		assertEquals(s1, sortedLinkedString.getFirst());
		sortedLinkedString.remove(s1, comparator);
		assertEquals(s2, sortedLinkedString.getFirst());
	}
	
	@Test
	public void testRemoveEndCar() {
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(f);
		assertEquals(f, sortedLinkedCar.getFirst());
		assertEquals(b, sortedLinkedCar.getLast());
		sortedLinkedCar.add(d);
		assertEquals(d, sortedLinkedCar.getLast());
		sortedLinkedCar.remove(d, comparatorCar);
		assertEquals(b, sortedLinkedCar.getLast());
	}

	@Test
	public void testRemoveMiddleCar() {
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(f);
		assertEquals(f, sortedLinkedCar.getFirst());
		assertEquals(c, sortedLinkedCar.getLast());
		sortedLinkedCar.add(e);
		assertEquals(e, sortedLinkedCar.getFirst());
		assertEquals(c, sortedLinkedCar.getLast());

		sortedLinkedCar.remove(f, comparatorCar);
		assertEquals(e, sortedLinkedCar.getFirst());
		assertEquals(c, sortedLinkedCar.getLast());
		assertEquals(2,sortedLinkedCar.getSize());
	}

	private class StringComparator implements Comparator<String>
	{
		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
	}
	
	private class DoubleComparator implements Comparator<Double>
	{
		@Override
		public int compare(Double arg0, Double arg1) {
			return arg0.compareTo(arg1);
		}
	}
	
	private class CarComparator implements Comparator<Car>
	{
		@Override
		public int compare(Car arg0, Car arg1) {
			return arg0.getMake().compareTo(arg1.getMake());
		}		
	}
	
	private class Car{
		String make;
		String model;
		int year;
		
		public Car(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}