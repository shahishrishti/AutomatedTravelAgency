package com.capg.travelagency.presentation;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;


public class VehicleControllerTest {

	private static Logger logger;
	private static VehicleController vehicleController;
	
	@BeforeClass
	public static void setUp() {
		logger = LogManager.getLogger(VehicleControllerTest.class.getName());
		vehicleController = new VehicleController();
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testDeleteVehicleInvalidVehicleNo() throws InvalidVehicleDataException {
		logger.info("[start] testDeleteVehicleInvalidVehicleNo()");
		vehicleController.deleteVehicle(-1);
		logger.info("[end] testDeleteVehicleInvalidVehicleNo()");
	}
	
	@Test
	public void testDeleteVehicleValidVehicleNo() throws InvalidVehicleDataException {
		logger.info("[start] testDeleteVehicleValidVehicleNo()");
		assertNotNull("Vehicle Found to be deleted", vehicleController.deleteVehicle(2));
		logger.info("[end] testDeleteVehicleValidVehicleNo()");
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testModifyVehicleInvalidVehicleNo() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleInvalidVehicleNo()");
		vehicleController.modifyVehicle(-1, "Tata Kia", "Car", 20.5, 4, 1);
		logger.error("VehicleNo cannot be negative or zero");
		logger.info("[end] testModifyVehicleInvalidVehicleNo()");
	}
	
	@Test
	public void testModifyVehicleValidVehicleNo() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleValidVehicleNo()");
		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(1, "Tata Kia", "Bus", 20.5, 20, 1));
		logger.info("[end] testModifyVehicleValidVehicleNo()");
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testModifyVehicleInvalidVehicleName() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleInvalidVehicleName()");
		vehicleController.modifyVehicle(1, null, "Car", 20.5, 4, 1);
		logger.info("[end] testModifyVehicleInvalidVehicleName()");
	}
	
	@Test
	public void testModifyVehicleValidVehicleName() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleValidVehicleNo()");
		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(1, "Tata Kia", "Car", 20.5, 4, 1));
		logger.info("[end] testModifyVehicleValidVehicleNo()");
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testSeatingCapacityInvalidValue() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testSeatingCapacityInvalidValue()");
		vehicleController.modifyVehicle(3, "Hyundai Creta", "Car", 20.5, 5, 1);
		logger.info("[end] testSeatingCapacityInvalidValue()");
	}
	
	@Test
	public void testSeatingCapacityValidValue() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testSeatingCapacityValidValue()");
		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(3, "Hyundai Creta", "Car", 20.5, 3, 1));
		logger.info("[end] testSeatingCapacityValidValue()");
	}

	@Test(expected = InvalidVehicleDataException.class)
	public void testModifyVehicleInvalidVehicleType() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleInvalidVehicleType()");
		vehicleController.modifyVehicle(4, "Tata Altroz", null, 20.5, 4, 1);
		logger.info("[end] testModifyVehicleInvalidVehicleType()");
	}
	
	@Test
	public void testModifyVehicleValidVehicleType() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleValidVehicleType()");
		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(4, "Tata Altroz", "Bus", 20.5, 20, 1));
		logger.info("[end] testModifyVehicleValidVehicleType()");
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testModifyVehicleInvalidFare() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleInvalidVehicleFare()");
		vehicleController.modifyVehicle(1, "Tata Kia", "Car", -20.5, 4, 1);
		logger.info("[end] testModifyVehicleInvalidVehicleFare()");
	}
	
	@Test
	public void testModifyVehicleValidFare() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleValidVehicleFare()");
		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(1, "Tata Kia", "Car", 30.5, 4, 1));
		logger.info("[end] testModifyVehicleValidVehicleFare()");
	}
}
