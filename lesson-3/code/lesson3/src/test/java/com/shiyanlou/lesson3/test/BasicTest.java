package com.shiyanlou.lesson3.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BasicTest {

	@Test
	public void test0() throws Exception {
		System.out.println("testing0...");
	}
	
	@Test
	public void test1() {
		System.out.println("testing1...");
	}
	
	@Test(timeout=2000)
	public void testTimeout() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		System.out.println("testTimeout...");
	}
	
	@Test(expected=NullPointerException.class)
	public void testException() {
		System.out.println("testException...");
		throw new NullPointerException();
	}
	
	@Ignore
	public void ignore() {
		System.out.println("ignore...");
	}
	
	@Before
	public void setUp() {
		System.out.println("before...");
	}
	
	@After
	public void tearDown() {
		System.out.println("after...");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass...");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("@AfterClass...");
	}
}
