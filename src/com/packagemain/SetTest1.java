package com.packagemain;

import static org.junit.Assert.*;


import org.junit.Test;

public class SetTest1 {

	@Test
	public void testEmptyCheck() {
		Set setObject = new Set();
		assertEquals(false, setObject.isExists(1));
	}
	
	@Test
	public void testSetNotEmpty() {
		Set setObject = new Set(new int[] {1,2,3});
		assertEquals(3,setObject.size());
	}
	

	@Test(expected=NullPointerException.class)
	public void testSetNull() {
		Set setObject = new Set(null);
		setObject.add(1);
	}
	
	@Test
	public void testSetConstructor() {
		Set setObject = new Set();
		assertEquals(0,setObject.size());
	}
	
	@Test
	public void testSetConstructor2() {
		Set setObject = new Set(new int[] {1,2,3});
		assertEquals(3,setObject.size());
	}
	
	@Test
	public void testAddValidSetData() {
		Set setObject = new Set(new int[] {1,2,3});
		assertEquals(true,setObject.add(4));
		assertEquals(4,setObject.size());
		setObject.delete(5);
		assertEquals(4,setObject.size());
		setObject.delete(3);
		assertEquals(3,setObject.size());
	}
	
	@Test
	public void testAddExistingTestData() {
		Set setObject = new Set(new int[] {1,2,3});
		assertFalse(setObject.add(3));
	}
	
	@Test
	public void testDeleteValidTestData() {
		Set setObject = new Set(new int[] {1,2,3});
		assertTrue(setObject.delete(3));
	}
	
	@Test
	public void testInvalidTestData() {
		Set setObject = new Set(new int[] {1,2,3});
		assertFalse(setObject.delete(4));
	}
	
	@Test
	public void testIsExist() {
		Set setObject = new Set(new int[] {1,2,3});
		assertTrue(setObject.isExists(3));
	}
	
	@Test
	public void testIsNotExist() {
		Set setObject = new Set(new int[] {1,2,3});
		assertFalse(setObject.isExists(4));
	}
	
	@Test
	public void tesCheckDeletion() {
		Set setObject = new Set(new int[] {1,2,3,0,0,0});
		assertTrue(setObject.delete(0));
		assertFalse(setObject.delete(0));
	}
	
	@Test
	public void edgeCasesScenario() {
		Set setObject = new Set(new int[]{ 1,2,3,4,5,6,7,8,9,0,0 } );
		assertTrue(setObject.isExists(1));
		assertTrue(setObject.isExists(0));
		assertTrue(setObject.isExists(7));
		assertTrue(setObject.isExists(8));
		assertTrue(setObject.isExists(4));
		setObject.add(11);
		assertTrue(setObject.isExists(11));
		assertFalse(setObject.isExists(11111111));
		setObject.delete(7);
		assertFalse(setObject.isExists(7));
		assertEquals(10, setObject.size() );
		assertTrue(setObject.toString().contains("5"));
		setObject.delete(0);
		assertFalse(setObject.toString().contains("0"));
		char [] charArray = setObject.toString().toCharArray();
		System.out.println(charArray);
		boolean flagForValue6 = false;
		boolean flagForValue1 = false;
		boolean flagForValue7 = false;
		boolean flagForValue8 = false;
		for(int i=0 ; i < charArray.length; i++) {
			if(charArray[i] == '6') {
				flagForValue6 = true;
			}
			if(charArray[i] == '1') {
				flagForValue1 = true;
			}
			if(charArray[i] == '7') {
				flagForValue7 = true;
			}
			if(charArray[i] == '8') {
				flagForValue8 = true;
			}
		}
		assertTrue(flagForValue6);
		assertTrue(flagForValue1);
		assertFalse(flagForValue7);
		assertTrue(flagForValue8);
	}
	

}
