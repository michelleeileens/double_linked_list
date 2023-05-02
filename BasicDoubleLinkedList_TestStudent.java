import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedList_TestStudent {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Car> linkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	//order: r p t q s
	public double p=55.32, q=64.54, r=23.78, s=67.85, t=58.65;
	
	//order: s1 s2 s5 s6 s4 s3
	public String s1="Carrie";
	public String s2="Grey";
	public String s3="William";
	public String s4="Toni";
	public String s5="Joan";
	public String s6="Maya";
	
	
	public Car a=new Car("Ford", "F150", 2005);

	
	public ArrayList<Double> stringD;
	public ArrayList<String> stringS;
	

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
		linkedString.addToEnd("World");
		comparator = new StringComparator();
		stringS = new ArrayList<String>();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();
		stringD = new ArrayList<Double>();
		
		
		linkedCar= new BasicDoubleLinkedList<Car>();
		comparatorCar = new CarComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedCar = null;
		comparatorD = null;
		comparator = null;
		stringD=null;
		stringS=null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
		
		assertEquals(100.0, linkedDouble.getLast(),.00);
		linkedDouble.addToEnd(90.0);
		assertEquals(90.0, linkedDouble.getLast(),.00);
		
		
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
		
		assertEquals(15.0, linkedDouble.getFirst(),.00);
		linkedDouble.addToFront(s);
		assertEquals(s, linkedDouble.getFirst(),.00);
		
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		
		assertEquals(15.0, linkedDouble.getFirst(),.00);
		linkedDouble.addToFront(q);
		assertEquals(q, linkedDouble.getFirst(),.00);
		
		
	}

	@Test
	public void testGetLast() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		
		assertEquals(100.0, linkedDouble.getLast(),.00);
		linkedDouble.addToEnd(t);
		assertEquals(t, linkedDouble.getLast(),.00);
		
		
	}
	
	@Test
	public void testToArrayList()
	{
		linkedDouble.addToFront(s);
		linkedDouble.addToFront(r);
		stringD=linkedDouble.toArrayList();
		
		assertEquals(r,stringD.get(0),.00);
		assertEquals(s,stringD.get(1),.00);
		assertEquals(15.0,stringD.get(2),.00);
		assertEquals(100.0,stringD.get(3),.00);
		
		linkedString.addToFront(s1);
		linkedString.addToFront(s2);
		stringS=linkedString.toArrayList();
		
		assertEquals(s2,stringS.get(0));
		assertEquals(s1,stringS.get(1));
		assertEquals("Hello",stringS.get(2));
		assertEquals("World",stringS.get(3));
		
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront(s4);
		linkedString.addToEnd(s6);
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(s4, iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(s6, iterator.next());
		
		linkedDouble.addToFront(t);
		linkedDouble.addToEnd(s);
		ListIterator<Double> iteratorD = linkedDouble.iterator();
		assertEquals(true, iteratorD.hasNext());
		assertEquals(t, iteratorD.next(),.0);
		assertEquals(15.0, iteratorD.next(),.0);
		assertEquals(100.0, iteratorD.next(),.0);
		assertEquals(true, iteratorD.hasNext());
		assertEquals(s, iteratorD.next(),.0);
		
		
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedString.addToFront(s3);
		linkedString.addToEnd(s5);
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(s3, iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(s5, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(s5, iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
		assertEquals(s3, iterator.previous());
		
		linkedDouble.addToFront(p);
		linkedDouble.addToEnd(q);
		ListIterator<Double> iteratorD = linkedDouble.iterator();
		assertEquals(true, iteratorD.hasNext());
		assertEquals(p, iteratorD.next(),.0);
		assertEquals(15.0, iteratorD.next(),.0);
		assertEquals(100.0, iteratorD.next(),.0);
		assertEquals(q, iteratorD.next(),.0);
		assertEquals(true, iteratorD.hasPrevious());
		assertEquals(q, iteratorD.previous(),.0);
		assertEquals(100.0, iteratorD.previous(),.0);
		assertEquals(15.0, iteratorD.previous(),.0);
		assertEquals(p, iteratorD.previous(),.0);
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedDouble.addToFront(r);
		linkedDouble.addToEnd(q);
		ListIterator<Double> iteratorD = linkedDouble.iterator();		
		assertEquals(true, iteratorD.hasNext());
		assertEquals(r, iteratorD.next(),.0);
		assertEquals(15.0, iteratorD.next(),.0);
		assertEquals(100.0, iteratorD.next(),.0);
		assertEquals(true, iteratorD.hasNext());
		assertEquals(q, iteratorD.next(),.0);
		
		try{
			//no more elements in list
			iteratorD.next();
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
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedString.addToFront(s6);
		linkedString.addToEnd(s5);
		ListIterator<String> iterator = linkedString.iterator();		
		assertEquals(true, iterator.hasNext());
		assertEquals(s6, iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(s5, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(s5, iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
		assertEquals(s6, iterator.previous());
		
		try{
			//no more elements in list
			iterator.previous();
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
	public void testIteratorUnsupportedOperationException() {
		linkedDouble.addToFront(p);
		linkedDouble.addToEnd(s);
		ListIterator<Double> iteratorD = linkedDouble.iterator();		
		assertEquals(true, iteratorD.hasNext());
		assertEquals(p, iteratorD.next(),.0);
		assertEquals(15.0, iteratorD.next(),.0);
		assertEquals(100.0, iteratorD.next(),.0);
		assertEquals(true, iteratorD.hasNext());
		assertEquals(s, iteratorD.next(),.0);
		
		try{
			//remove is not supported for the iterator
			iteratorD.remove();
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
	public void testRemove() {
		// remove the first
		assertEquals(15.0, linkedDouble.getFirst(),.0);
		assertEquals(100.0, linkedDouble.getLast(),.0);
		linkedDouble.addToFront(q);
		assertEquals(q, linkedDouble.getFirst(),.0);
		linkedDouble.remove(q, comparatorD);
		assertEquals(15.0, linkedDouble.getFirst(),.0);
		
		//remove from the end of the list
		linkedDouble.addToEnd(t);
		assertEquals(t, linkedDouble.getLast(),.0);
		linkedDouble.remove(t, comparatorD);
		assertEquals(100.0, linkedDouble.getLast(),.0);
		
		//remove from middle of list
		linkedString.addToFront(s1);
		assertEquals(s1, linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		linkedString.remove("Hello", comparator);
		assertEquals(s1, linkedString.getFirst());
		assertEquals(2, linkedString.getSize());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(15.0, linkedDouble.getFirst(),.0);
		linkedDouble.addToFront(p);
		assertEquals(p, linkedDouble.getFirst(),.0);
		assertEquals(p, linkedDouble.retrieveFirstElement(),.0);
		assertEquals(15.0,linkedDouble.getFirst(),.0);
		assertEquals(15.0, linkedDouble.retrieveFirstElement(),.0);
		assertEquals(100.0,linkedDouble.getFirst(),.0);
		
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront(s4);
		assertEquals(s4, linkedString.getFirst());
		assertEquals(s4, linkedString.retrieveFirstElement());
		assertEquals("Hello",linkedString.getFirst());
		assertEquals("Hello", linkedString.retrieveFirstElement());
		assertEquals("World",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(100.0, linkedDouble.getLast(),.0);
		linkedDouble.addToEnd(r);
		assertEquals(r, linkedDouble.getLast(),.0);
		assertEquals(r, linkedDouble.retrieveLastElement(),.0);
		assertEquals(100.0,linkedDouble.getLast(),.0);
		
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd(s2);
		assertEquals(s2, linkedString.getLast());
		assertEquals(s2, linkedString.retrieveLastElement());
		assertEquals("World",linkedString.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
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