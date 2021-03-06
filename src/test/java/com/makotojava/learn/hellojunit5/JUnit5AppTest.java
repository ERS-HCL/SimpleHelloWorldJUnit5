package com.makotojava.learn.hellojunit5;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * JUnit 5 (with JUnitPlatform.class)
 * 
 * Class-level Exercises:
 * <ol>
 * <li>Enable Eclipse JUnit support for this test class using the
 * {@link org.junit.runner.RunWith @RunWith} and
 * {@link org.junit.platform.runner.JUnitPlatform JUnitPlatform} class.</li>
 * <li>Give the class a cool
 * {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the
 * JUnit test report.</li>
 * </ol>
 *
 */
@RunWith(JUnitPlatform.class)
@DisplayName("This test is executed in JUnit 5.")
public class JUnit5AppTest {

	private static Logger log = LoggerFactory.getLogger("JUnit5AppTest.class");
	// Create a JDK Logger here

	// Create a fixture for the class under test
	protected static App newApp;

	// Do something before ANY test is run in this class
	@BeforeAll
	public static void init() {
		log.info(
				"\n Called Before All single time before all test are executed");
	}

	// Do something after ALL tests in this class are run
	@AfterAll
	public static void done() {
		log.info(
				" \n Called After All single time After all test are executed");
	}

	@BeforeEach
	public void initMethod() {
		// set the instance
		log.info("Creating instance of App");
		newApp = new App();
	}

	// Do something after ALL tests method in this class are run
	@AfterEach
	public void doneAfterMethod() {
		log.info("Destroying the App");
		newApp = null;
	}

	// Create an instance of the test class before each @Test method is executed

	// Destroy reference to the instance of the test class after each @Test
	// method is executed

	// Disabled test
	@Test
	@Disabled
	@DisplayName("This test is diabled for now")
	void testNotRun() {
		log.info("This is a disabled test..Should not have been called");
	}

	/**
	 * testAdd() - Exercises:
	 * <ol>
	 * <li>Tell JUnit this method is a test method.</li>
	 * <li>Give it a cool display name for the test report.</li>
	 * <li>The reference to the class under test cannot be null. If it is, the
	 * test should fail.</li>
	 * <li>Create a group of three tests of the add methods with the following
	 * arrays of positive numbers:
	 * <ol>
	 * <li>1, 2, 3, 4</li>
	 * <li>20, 934, 110</li>
	 * <li>2, 4, 6</li>
	 * </ol>
	 * Ensure the actual sum matches the expected sum for each group of numbers.
	 * Make sure that all groups of numbers are tested (i.e., if one fails, it
	 * should not fail the test method). Hint: use
	 * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...)
	 * assertAll()}
	 * </ol>
	 */
	@Test
	@DisplayName("This is a test method for Addition")
	public void testAdd() {
		//
		// EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions.
		// Use the Javadoc View in Eclipse to see the
		// buttery smooth javadoc above.)
		//
		log.info("testAdd() is called");
		Assume.assumeTrue("Test not implemented!", newApp != null);
		// fail("Test not implemented!");
		Assert.assertNotNull(newApp);
		long[] smallNos = {1l, 2l, 3l, 4l};
		long[] midNs = {20l, 934l, 110l};
		long[] lastNos = {2l, 4l, 6l};

		assertAll("Assert All of these",
				() -> assertEquals(10, newApp.add(smallNos), "INCONCEIVABLE!"),
				() -> assertEquals(1064, newApp.add(midNs), "INCONCEIVABLE!"),
				() -> assertEquals(12, newApp.add(lastNos), "INCONCEIVABLE!"));

	}

	/**
	 * Class-level Exercises:
	 * <ol>
	 * <li>Make this class a nested test class (hint: use
	 * {@link org.junit.jupiter.api.Nested @Nested}).
	 * <li>Give the class a cool
	 * {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in
	 * the JUnit test report.</li>
	 * <li>Create an instance of the {@link com.makotojava.learn.hellojunit5.App
	 * App} class specifically for this nested class:
	 * <ul>
	 * <li>Set the <code>classUnderTest</code> variable in a method called
	 * <code>setUp()</code> that runs before the test method does (hint: use
	 * {@link org.junit.jupiter.api.BeforeEach @BeforeEach})</li>
	 * </ul>
	 * <li>Set the <code>classUnderTest</code> variable to null in a method
	 * called <code>tearDown()</code> that runs after the test method does
	 * (hint: use {@link org.junit.jupiter.api.BeforeEach @AfterEach})</li>
	 * </ol>
	 * 
	 */
	@Nested
	@DisplayName("This is a nested class of Junit5AppTest")
	class NegativeNumbersTest {

		@BeforeEach
		@DisplayName("Nested Before Each..")
		public void initMethod() {
			log.info("\n\n Nested BeforeEach is called And App is initialsed");
			newApp = new App();
		}

		@AfterEach
		@DisplayName("Nested After Each..")
		public void doneAfterMethod() {
			log.info("\n\n Nested After is called And App is initialsed");
			newApp = null;
		}

		/**
		 * testAdd() - Exercises:
		 * <ol>
		 * <li>Tell JUnit this method is a test method.</li>
		 * <li>Give it a cool display name for the test report.</li>
		 * <li>The reference to the class under test cannot be null. If it is,
		 * the test should fail.</li>
		 * <li>Create a group of three tests of the add methods with the
		 * following arrays of positive numbers:
		 * <ol>
		 * <li>-1, -2, -3, -4</li>
		 * <li>-20, -934, -110</li>
		 * <li>-2, -4, -6</li>
		 * </ol>
		 * Ensure the actual sum matches the expected sum for each group of
		 * numbers. Make sure that all groups of numbers are tested (i.e., if
		 * one fails, it should not fail the test method). Hint: use
		 * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...)
		 * assertAll()}
		 * </ol>
		 */
		@Test
		@DisplayName("Addition in Nested Class")
		public void testAdd() {
			//
			// EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for
			// instructions. Use the Javadoc View in Eclipse to see
			// the buttery smooth javadoc above.)
			//
			long[] smallNos = {1l, 2l, 3l, 4l};
			long[] midNs = {20l, 934l, 110l};
			long[] lastNos = {2l, 4l, 6l};
			assumingThat(newApp!= null,
					() -> assertAll("Assert All of these",
							() -> assertEquals(10, newApp.add(smallNos),
									"INCONCEIVABLE!"),
							() -> assertEquals(1064, newApp.add(midNs),
									"INCONCEIVABLE!"),
							() -> assertEquals(12, newApp.add(lastNos),
							"INCONCEIVABLE!")));

			// Execute this regardless
			// fail("Test not implemented!");
		}
	}

	/**
	 * Class-level Exercises:
	 * <ol>
	 * <li>Make this class a nested test class (hint: use
	 * {@link org.junit.jupiter.api.Nested @Nested}).
	 * <li>Give the class a cool
	 * {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in
	 * the JUnit test report.</li>
	 * </ol>
	 * 
	 */
	@Nested
	@DisplayName("PositiveAndNegativeNumbersTest")
	class PositiveAndNegativeNumbersTest {

		@BeforeEach
		@DisplayName("Nested Before Each..")
		public void initMethod() {
			log.info("\n\n Nested BeforeEach is called And App is initialsed");
			newApp = new App();
		}

		@AfterEach
		@DisplayName("Nested After Each..")
		public void doneAfterMethod() {
			log.info("\n\n Nested After is called And App is initialsed");
			newApp = null;
		}

		/**
		 * testAdd() - Exercises:
		 * <ol>
		 * <li>Tell JUnit this method is a test method.</li>
		 * <li>Give it a cool display name for the test report.</li>
		 * <li>The reference to the class under test cannot be null. If it is,
		 * the test should fail.</li>
		 * <li>Create a group of three tests of the add methods with the
		 * following arrays of positive numbers:
		 * <ol>
		 * <li>-1, 2, -3, 4</li>
		 * <li>-20, 934, -110</li>
		 * <li>-2, -4, 6</li>
		 * </ol>
		 * Ensure the actual sum matches the expected sum for each group of
		 * numbers. Make sure that all groups of numbers are tested (i.e., if
		 * one fails, it should not fail the test method). Hint: use
		 * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...)
		 * assertAll()}
		 * </ol>
		 */
		//@Test
		//@DisplayName("testAdd")
		public void testAdd() {
			//
			// EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for
			// instructions. Use the Javadoc View in Eclipse to see
			// the buttery smooth javadoc above.)
			//
			fail("Test not implemented!");
		}

		/**
		 * testAdd_OnlyOnFriday - Exercises:
		 * <ol>
		 * <li>Tell JUnit this method is a test method.</li>
		 * <li>Give it a cool display name for the test report.</li>
		 * <li>Use the JDK 8 Date/Time API to get the current local date/time,
		 * along with a simple Assumption (hint: use
		 * {@link org.junit.jupiter.api.Assumptions#assumeTrue(boolean)
		 * assumeTrue()}) that today is Friday (or any other day of the week of
		 * your choosing, just so you pick one), or the test is skipped.</li>
		 * <li>Pass the following numbers as operands to the
		 * {@link com.makotojava.learn.hellojunit5.App#add(long[]) add} method:
		 * 1, 2, 3, 4, 5</li>
		 * <li>Ensure the actual sum matches the expected sum.</li>
		 * </ol>
		 */
		@Test
		@DisplayName("Test Only ON FRiday")
		public void testAdd_OnlyOnFriday() {
			//
			// EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for
			// instructions. Use the Javadoc View in Eclipse to see
			// the buttery smooth javadoc above.)
			//
			 log.info("@testAdd_OnlyOnFriday: testAdd_OnlyOnFriday()");
			 LocalDateTime localTime = LocalDateTime.now();
			 System.out.println(localTime.getDayOfWeek());
			 assumeTrue(localTime.getDayOfWeek().getValue()==4);
			 	//execute only when the above condition is true
			 log.debug("@testAdd_OnlyOnFriday: testAdd_OnlyOnFriday(): assumeTrue is Passed");
			 long[] operand = {1,2,3,4,5};
			 assertEquals(15, newApp.add(operand));
			//fail("Test not implemented!");
		}

		/**
		 * testAdd_OnlyOnFriday_WithLambda - Exercises:
		 * <ol>
		 * <li>Tell JUnit this method is a test method.</li>
		 * <li>Give it a cool display name for the test report.</li>
		 * <li>Use the JDK 8 Date/Time API to get the current local date/time,
		 * along with a simple Assumption (hint: use
		 * {@link org.junit.jupiter.api.Assumptions#assumingThat(boolean, org.junit.jupiter.api.function.Executable)
		 * assumingThat()}) that today is Friday (or any other day of the week
		 * of your choosing, just so you pick one), or the test is skipped.</li>
		 * <li>Pass the following numbers as operands to the
		 * {@link com.makotojava.learn.hellojunit5.App#add(long[]) add} method:
		 * 1, 2, 3, 4, 5</li>
		 * <li>Ensure the actual sum matches the expected sum.</li>
		 * </ol>
		 */
		public void testAdd_OnlyOnFriday_WithLambda() {
			//
			// EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for
			// instructions. Use the Javadoc View in Eclipse to see
			// the buttery smooth javadoc above.)
			//
			fail("Test not implemented!");
		}

	}

	/**
	 * Class-level Exercises:
	 * <ol>
	 * <li>Make this class a nested test class (hint: use
	 * {@link org.junit.jupiter.api.Nested @Nested}).
	 * <li>Give the class a cool
	 * {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in
	 * the JUnit test report.</li>
	 * </ol>
	 * 
	 */
	@Nested
	@DisplayName("JUnit5AppSingleOperandTest")
	class JUnit5AppSingleOperandTest {

		/**
		 * testAdd_NumbersGt0() - Exercises:
		 * <ol>
		 * <li>Tell JUnit this method is a test method.</li>
		 * <li>Give it a cool display name for the test report.</li>
		 * <li>The reference to the class under test cannot be null. If it is,
		 * the test should fail.</li>
		 * <li>Create a group of two tests of the add methods with the following
		 * arrays of positive numbers:
		 * <ol>
		 * <li>1</li>
		 * <li>0</li>
		 * </ol>
		 * Ensure the actual sum matches the expected sum for each group of
		 * numbers. Make sure that all groups of numbers are tested (i.e., if
		 * one fails, it should not fail the test method). Hint: use
		 * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...)
		 * assertAll()}
		 * </ol>
		 */
		public void testAdd_NumbersGt0() {
			//
			// EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for
			// instructions. Use the Javadoc View in Eclipse to see
			// the buttery smooth javadoc above.)
			//
			fail("Test not implemented!");
		}

		/**
		 * testAdd_NumbersLt0() - Exercises:
		 * <ol>
		 * <li>Tell JUnit this method is a test method.</li>
		 * <li>Give it a cool display name for the test report.</li>
		 * <li>The reference to the class under test cannot be null. If it is,
		 * the test should fail.</li>
		 * <li>Create a group of two tests of the add methods with the following
		 * arrays of positive numbers:
		 * <ol>
		 * <li>-1</li>
		 * <li>-10</li>
		 * </ol>
		 * Ensure the actual sum matches the expected sum for each group of
		 * numbers. Make sure that all groups of numbers are tested (i.e., if
		 * one fails, it should not fail the test method). Hint: use
		 * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...)
		 * assertAll()}
		 * </ol>
		 */
		public void testAdd_NumbersLt0() {
			//
			// EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for
			// instructions. Use the Javadoc View in Eclipse to see
			// the buttery smooth javadoc above.)
			//
			fail("Test not implemented!");
		}
	}

	/**
	 * Class-level Exercises:
	 * <ol>
	 * <li>Make this class a nested test class (hint: use
	 * {@link org.junit.jupiter.api.Nested @Nested}).
	 * <li>Give the class a cool
	 * {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in
	 * the JUnit test report.</li>
	 * </ol>
	 * 
	 */
	@Nested
	@DisplayName("JUnit5AppZeroOperandsTest")
	class JUnit5AppZeroOperandsTest {

		/**
		 * testAdd_ZeroOperands_EmptyArgument() - Exercises:
		 * <ol>
		 * <li>Tell JUnit this method is a test method.</li>
		 * <li>Give it a cool display name for the test report.</li>
		 * <li>The reference to the class under test cannot be null. If it is,
		 * the test should fail.</li>
		 * <li>Pass an empty array as operands argument to the
		 * {@link com.makotojava.learn.hellojunit5.App#add(long[]) add} method.
		 * </li>
		 * <li>Ensure that an {@link java.lang.IllegalArgumentException
		 * IllegalArgumentException} is thrown (hint: use the
		 * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
		 * assertThrows()} method).</li>
		 * </ol>
		 */
		@Test
		@DisplayName("when zero operand passed")
		public void testAdd_ZeroOperands_EmptyArgument() {
			//
			// EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for
			// instructions. Use the Javadoc View in Eclipse to see
			// the buttery smooth javadoc above.)
			//
			newApp = new App();
			Assertions.assertThrows(NullPointerException.class, () -> newApp.add(null), "Illegal Argument have ben thrown");
			newApp = null;
		}

		/**
		 * testAdd_ZeroOperands_NullArgument() - Exercises:
		 * <ol>
		 * <li>Tell JUnit this method is a test method.</li>
		 * <li>Give it a cool display name for the test report.</li>
		 * <li>The reference to the class under test cannot be null. If it is,
		 * the test should fail.</li>
		 * <li>Pass an empty array as operands argument to the
		 * {@link com.makotojava.learn.hellojunit5.App#add(long[]) add} method.
		 * </li>
		 * <li>Ensure that an {@link java.lang.IllegalArgumentException
		 * IllegalArgumentException} is thrown (hint: use the
		 * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
		 * assertThrows()} method).</li>
		 * <li>The test should fail if the message in the exception is not
		 * "Operands argument cannot be null".</li>
		 * </ol>
		 */
		public void testAdd_ZeroOperands_NullArgument() {
			//
			// EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for
			// instructions. Use the Javadoc View in Eclipse to see
			// the buttery smooth javadoc above.)
			//
			fail("Test not implemented!");
		}

	}

}
