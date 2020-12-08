package com.capg.travelagency.presentation;

import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.capg.travelagency.exceptions.InvalidDriverDataException;

public class DriverControllerTest {
	
	private static DriverController driverController;
	private static Logger logger;
	
	@BeforeClass
	public static void setUp() {
		logger = LogManager.getLogger(DriverControllerTest.class.getName());
		driverController = new DriverController();
	}
	
	@Test(expected = InvalidDriverDataException.class)
	public void testAddDriverInvalidDriverId() {
		logger.info("[start] testAddDriverInvalidDriverId()");
//		try {
//			driverController.addDriver(-1);
//			throw new InvalidDriverDataException("Driver id cannot be negative or zero.");
//		} catch(InvalidDriverDataException invalidDriverDataException) {
//			logger.error("Driver id cannot be negative or zero.");
//		}
		logger.info("[end] testAddDriverInvalidDriverId()");
	}
	
	@Test
	public void testAddDriverValidDriverId() throws InvalidDriverDataException {
		logger.info("[start] testAddDriverValidDriverId()");
//		assertNotNull("Item Found", driverController.addDriver(1, "Ayan", ...));
		logger.info("[end] testAddDriverValidDriverId()");
	}
	
	
	
	@Test(expected = InvalidDriverDataException.class)
	public void testAddDriverInvalidDriverName() throws InvalidDriverDataException {
		logger.info("[start] testAddDriverInvalidDriverName()");
//		try {
//			driverController.addDriver(null);
//			throw new InvalidDriverDataException("Driver Name cannot be null.");
//		} catch(InvalidDriverDataException invalidDriverDataException) {
//			logger.error("Driver name cannot be null");
//		}
		logger.info("[end] testAddDriverInvalidDriverName()");
	}
	
	@Test
	public void testAddDriverValidDriverName() throws InvalidDriverDataException {
		logger.info("[start] testAddDriverValidDriverName()");
//		assertNotNull("Item Found", driverController.addDriver(1, "ayan", ...));
		logger.info("[end] testAddDriverValidDriverName()");
	}
	
	@Test(expected = InvalidDriverDataException.class)
	public void testAddDriverInvalidDriverAddress() throws InvalidDriverDataException {
		logger.info("[start] testAddDriverInvalidDriverAddress()");
//		try {
//	 		driverController.addDriverByAddress(null);
//			throw new InvalidDriverDataException("Driver address cannot be null.");
//		} catch(InvalidDriverDataException invalidDriverDataException) {
//			logger.error("Driver address cannot be null..");
//		}
		logger.info("[end] testAddDriverInvalidDriverAddress()");
	}
	
	@Test
	public void testAddDriverValidDriverAddress() throws InvalidDriverDataException {
		logger.info("[start] testAddDriverValidDriverAddress()");
//		assertNotNull("Item Found", driverController.addDriver(1, "Ayan", ...));
		logger.info("[end] testAddDriverValidDriverAddress()");
	}
	
	
	@Test(expected = InvalidDriverDataException.class)
	public void testAddDriverInvalidContactNo() {
		logger.info("[start] testAddDriverInvalidMobileNo()");
//		try {
//			driverController.addDriver(-1);
//			throw new InvalidDriverDataException("Mobile no. cannot be negative or zero.");
//		} catch(InvalidDriverDataException invalidDriverDataException) {
//			logger.error("Mobile no. cannot be negative or zero.");
//		}
		logger.info("[end] testAddDriverInvalidContactNo()");
	}
	
	@Test
	public void testAddDriverValidMobileNo() throws InvalidDriverDataException {
		logger.info("[start] testAddDriverValidContactNo()");
//		assertNotNull("Item Found", driverController.addDriver(1, "ayan", ...));
		logger.info("[end] testAddDriverValidContactNo()");
	}
	
	@Test(expected = InvalidDriverDataException.class)
	public void testAddDriverInvalidLicenceNo() {
		logger.info("[start] testAddDriverInvalidLicenceNo()");
//		try {
//			driverController.addDriverByLicenceNo(-1);
//			throw new InvalidDriverDataException("License No. cannot be negative or zero.");
//		} catch(InvalidDriverDataException invalidDriverDataException) {
//			logger.error("License no. cannot be negative or zero.");
//		}
		logger.info("[end] testAddDriverInvalidLicenceNo()");
	}
	
	@Test
	public void testAddDriverLicenceNo() throws InvalidDriverDataException {
		logger.info("[start] testAddDriverLicenceNo()");
//		assertNotNull("Item Found", driverController.addDriver(1, "ayan", ...));
		logger.info("[end] testAddDriverLicenceNo()");
	}
}
