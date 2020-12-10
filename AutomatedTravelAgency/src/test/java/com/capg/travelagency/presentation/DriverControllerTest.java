package com.capg.travelagency.presentation;



import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.travelagency.dto.Driver;
import com.capg.travelagency.exceptions.InvalidDriverDataException;

public class DriverControllerTest {

	private static Logger logger;
	private static DriverController driverController;
	
	@BeforeClass
	public static void setUp() {
		logger = LogManager.getLogger(DriverControllerTest.class.getName());
		driverController = new DriverController();
	}
	
	  @Test(expected = InvalidDriverDataException.class)
	public void testDeleteDriverInvalidDriverId() throws InvalidDriverDataException {
		logger.info("[start] testdeleteDriverInvalidDriverId()");
		driverController.deleteDriver(-5);
		logger.info("[end] testDeleteDriverInvalidDriverId()");
	}  
	
	@Test
	public void testDeleteDriverValidDriverId() throws  InvalidDriverDataException{
		logger.info("[start] testDeleteDriverValidDriverId()");
		assertNotNull("Valid Driver", driverController.deleteDriver(50));
		logger.info("[end] testDeleteDriverValidDriverId()");
	}
	
	  @Test
	public void testModifyDriverValidDriverName() throws InvalidDriverDataException {
		logger.info("[start] testModifyDriverValidDriverName()");
		Driver driver = new Driver(5, "Ramesh", "Pune", 9945201667l, "MH1420130083421");
		driverController.modifyDriver(driver);
	    logger.info("[end] testModifyDriverValidDriverName()");
	}  
		
		@Test(expected = InvalidDriverDataException.class)
		public void testModifyDriverInvalidDriverName() throws InvalidDriverDataException {
			logger.info("[start] testModifyDriverInvalidDriverName()");
			Driver driver = new Driver(5, null, "Pune", 9945201667l, "MH1420130083421");
			driverController.modifyDriver(driver);
			logger.info("[end] testModifyDriverInvalidDriverName()");
		}

		
		@Test
		public void testModifyDriverValidDriverAddress() throws InvalidDriverDataException {
			logger.info("[start] testModifyDriverValidDriverAddress()");
			 Driver driver = new Driver(5, "Ramesh ", "Pune", 9945201667l, "MH1420130083421");
			 driverController.modifyDriver(driver);
			logger.info("[end] testModifyDriverValidDriverAddress()");
		}
		
		@Test(expected = InvalidDriverDataException.class)
		public void testModifyDriverInvalidDriverAddress() throws InvalidDriverDataException {
			logger.info("[start] testModifyDriverInvalidDriverAddress()");
            Driver driver = new Driver(5, "Ramesh", null, 9945201667l, "MH1420130083421");
		    driverController.modifyDriver(driver);
			logger.info("[end] testModifyDriverInvalidDriverAddress()");
		} 

		
	
		@Test
		public void testModifyDriverValidContactNo() throws InvalidDriverDataException {
			logger.info("[start] testModifyDriverValidContactNo()");
			 Driver driver = new Driver(5, "Ramesh ", "Pune", 9945201667l, "MH1420130083421");
			 driverController.modifyDriver(driver);
			logger.info("[end] testModifyDriverValidContactNo()");
		}
		
		@Test(expected = InvalidDriverDataException.class)
		public void testModifyDriverInvalidContactNo() throws InvalidDriverDataException {
			logger.info("[start] testModifyDriverInvalidContactNo()");
			 Driver driver = new Driver(5, "Ramesh", "Pune",0, "MH1420130083421");
				driverController.modifyDriver(driver);
			logger.info("[end] testModifyDriverInvalidContactNo()");
		}  


		
		
		@Test
		public void testModifyDriverValidLicenceNo() throws InvalidDriverDataException {
			logger.info("[start] testModifyDriverLicenceNo()");
			 Driver driver = new Driver(5, "Ramesh ", "Pune", 9945201667l, "MH1420130083421");
			 driverController.modifyDriver(driver);
			logger.info("[end] testModifyDriverLicenceNo()");
		} 
		
		@Test(expected = InvalidDriverDataException.class)
		public void testModifyDriverInvalidLicenceNo() throws InvalidDriverDataException {
			logger.info("[start] testModifyDriverInvalidLicenceNo()");
			 Driver driver = new Driver(5, "Ramesh", "Pune ", 9945201667l, null);
				driverController.modifyDriver(driver);
			logger.info("[end] testModifyDriverInvalidLicenceNo()");
		}  
		@Test(expected = InvalidDriverDataException.class)
		public void testAddDriverInvalidDriverName() throws InvalidDriverDataException {
			logger.info("[start] testAddDriverInvalidDriverName()");
			Driver addedDriver=new Driver(null,"shivaji nagar",7412589630L,"DH786");
			driverController.addDriver(addedDriver);
			logger.error("Driver name cannot be null");
			logger.info("[end] testAddDriverInvalidDriverName()");
		}
		
		
		@Test
		public void testAddDriverValidDriverName() throws InvalidDriverDataException {
			logger.info("[start] testAddDriverValidDriverName()");
			Driver addedDriver=new Driver("ayan","shivaji nagar",7412589630L,"DH786");
			assertNotNull("Driver Adding",driverController.addDriver(addedDriver));
			logger.info("[end] testAddDriverValidDriverName()");
		}
		
		@Test(expected = InvalidDriverDataException.class)
		public void testAddDriverInvalidDriverAddress() throws InvalidDriverDataException {
			logger.info("[start] testAddDriverInvalidDriverAddress()");
			Driver addedDriver=new Driver("sai",null,7412589630L,"DH786");
			driverController.addDriver(addedDriver);
			logger.error("Driver address cannot be null");
			logger.info("[end] testAddDriverInvalidDriverAddress()");
		}
		
		@Test
		public void testAddDriverValidDriverAddress() throws InvalidDriverDataException {
			logger.info("[start] testAddDriverValidDriverAddress()");
			Driver addedDriver=new Driver("ayan","shivaji nagar",7412589630L,"DH786");
			assertNotNull("Driver Adding", driverController.addDriver(addedDriver));
			logger.info("[end] testAddDriverValidDriverAddress()");
		}
		
		
		@Test(expected = InvalidDriverDataException.class)
		public void testAddDriverInvalidContactNo() throws InvalidDriverDataException {
			logger.info("[start] testAddDriverInvalidMobileNo()");
			Driver addedDriver=new Driver("sai","shivaji nagar pune",0,"DH786");
			driverController.addDriver(addedDriver);
			logger.error("License number cannot be null");
					logger.info("[end] testAddDriverInvalidContactNo()");
		}
		
		@Test
		public void testAddDriverValidMobileNo() throws InvalidDriverDataException {
			logger.info("[start] testAddDriverValidContactNo()");
			Driver addedDriver=new Driver("ayan","shivaji nagar",7412589630L,"DH786");
			assertNotNull("Item Found", driverController.addDriver(addedDriver));
			logger.info("[end] testAddDriverValidContactNo()");
		}
		
		@Test(expected = InvalidDriverDataException.class)
		public void testAddDriverInvalidLicenceNo() throws InvalidDriverDataException {
			logger.info("[start] testAddDriverInvalidLicenceNo()");
			Driver addedDriver=new Driver("Sai","shivaji nagar",7412589630L,null);
			driverController.addDriver(addedDriver);
			logger.error("Driver name cannot be null");
			logger.info("[end] testAddDriverInvalidLicenceNo()");
	}
		
		@Test
		public void testAddDriverLicenceNo() throws InvalidDriverDataException {
			logger.info("[start] testAddDriverLicenceNo()");
			Driver addedDriver=new Driver("ayan","shivaji nagar",7412589630L,"DH786");
			assertNotNull("Driver Adding", driverController.addDriver(addedDriver));
			logger.info("[end] testAddDriverLicenceNo()");
		}
		
		@Test(expected = InvalidDriverDataException.class)
		public void testViewDriverInvalidDriverId() throws InvalidDriverDataException {
			logger.info("[start] testViewDriverInvalidDriverId()");
			driverController.viewDriverById(-1);
			logger.info("[end] testViewDriverInvalidDriverId()");
		}
		
		@Test
		public void testAddDriverValidDriverId() throws InvalidDriverDataException {
			logger.info("[start] testAddDriverValidDriverId()");
			assertNotNull("Driver details are", driverController.viewDriverById( 14));
			logger.info("[end] testAddDriverValidDriverId()");
		}

}  

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	