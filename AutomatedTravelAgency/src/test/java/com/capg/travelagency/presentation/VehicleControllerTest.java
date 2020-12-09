package com.capg.travelagency.presentation;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.travelagency.dto.Vehicle;
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
		assertNotNull("Vehicle Found to be deleted", vehicleController.deleteVehicle(6));
		logger.info("[end] testDeleteVehicleValidVehicleNo()");
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testModifyVehicleInvalidVehicleNo() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleInvalidVehicleNo()");
		Vehicle modifiedVehicle = new Vehicle(-1, "Tata Kia", "Car", 20.5, 4, 1);
		vehicleController.modifyVehicle(modifiedVehicle);
		logger.error("VehicleNo cannot be negative or zero");
		logger.info("[end] testModifyVehicleInvalidVehicleNo()");
	}
	
	@Test
	public void testModifyVehicleValidVehicleNo() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleValidVehicleNo()");
		Vehicle modifiedVehicle = new Vehicle(7, "Tata Kia", "Bus", 20.5, 20, 1);
		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(modifiedVehicle));
		logger.info("[end] testModifyVehicleValidVehicleNo()");
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testModifyVehicleInvalidVehicleName() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleInvalidVehicleName()");
		Vehicle modifiedVehicle = new Vehicle(7, null, "Car", 20.5, 4, 1);
		vehicleController.modifyVehicle(modifiedVehicle);
		logger.info("[end] testModifyVehicleInvalidVehicleName()");
	}
	
	@Test
	public void testModifyVehicleValidVehicleName() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleValidVehicleNo()");
		Vehicle modifiedVehicle = new Vehicle(7, "Tata Kia", "Car", 20.5, 4, 1);
		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(modifiedVehicle));
		logger.info("[end] testModifyVehicleValidVehicleNo()");
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testSeatingCapacityInvalidValue() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testSeatingCapacityInvalidValue()");
		Vehicle modifiedVehicle = new Vehicle(7, "Hyundai Creta", "Car", 20.5, 5, 1);
		vehicleController.modifyVehicle(modifiedVehicle);
		logger.info("[end] testSeatingCapacityInvalidValue()");
	}
	
	@Test
	public void testSeatingCapacityValidValue() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testSeatingCapacityValidValue()");
		Vehicle modifiedVehicle = new Vehicle(8, "Hyundai Creta", "Car", 20.5, 3, 1);
		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(modifiedVehicle));
		logger.info("[end] testSeatingCapacityValidValue()");
	}

	@Test(expected = InvalidVehicleDataException.class)
	public void testModifyVehicleInvalidVehicleType() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleInvalidVehicleType()");
		Vehicle modifiedVehicle = new Vehicle(9, "Tata Altroz", null, 20.5, 4, 1);
		vehicleController.modifyVehicle(modifiedVehicle);
		logger.info("[end] testModifyVehicleInvalidVehicleType()");
	}
	
	@Test
	public void testModifyVehicleValidVehicleType() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleValidVehicleType()");
		Vehicle modifiedVehicle = new Vehicle(9, "Tata Altroz", "Bus", 20.5, 20, 1);
		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(modifiedVehicle));
		logger.info("[end] testModifyVehicleValidVehicleType()");
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testModifyVehicleInvalidFare() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleInvalidVehicleFare()");
		Vehicle modifiedVehicle = new Vehicle(7, "Tata Kia", "Car", -20.5, 4, 1);
		vehicleController.modifyVehicle(modifiedVehicle);
		logger.info("[end] testModifyVehicleInvalidVehicleFare()");
	}
	
	@Test
	public void testModifyVehicleValidFare() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleValidVehicleFare()");
		Vehicle modifiedVehicle = new Vehicle(7, "Tata Kia", "Car", 30.5, 4, 1);
		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(modifiedVehicle));
		logger.info("[end] testModifyVehicleValidVehicleFare()");
	}
	@Test
	public void testAddVehicleValidVehicleName() throws InvalidVehicleDataException, InvalidDriverDataException{
		
		logger.info("[start] testAddVehicleValidVehicleName()");
		Vehicle vehicle = new Vehicle("Volkswagen","Car", 500,3,1);
		assertNotNull("Vehicle added",vehicleController.addVehicle(vehicle));
		logger.info("[end] testAddVehicleValidVehicleName()");//..........pass
	}
	
	
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testAddVehicleInValidVehicleName() throws InvalidVehicleDataException, InvalidDriverDataException  {
		logger.info("[start] testAddVehicleInValidVehicleName()");
		Vehicle vehicle = new Vehicle(null,"Car",30,4 , 1);
        vehicleController.addVehicle(vehicle);
        logger.error("Vehicle name cannot be null.");
		logger.info("[End] testAddVehicleInValidVehicleName()");//.......Fail
		
	}
	
	
	@Test
	public void testAddVehicleValidVehicleType() throws InvalidVehicleDataException, InvalidDriverDataException{
		
		logger.info("[start] testAddVehicleValidVehicleType()");
		Vehicle vehicle = new Vehicle("Nissan","Car", 70,4,1);
		assertNotNull("Vehicle Adding",vehicleController.addVehicle(vehicle));
		logger.info("[end] testAddVehicleValidVehicleType()");//..........pass
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testAddVehicleInValidVehicleType() throws InvalidVehicleDataException, InvalidDriverDataException  {
		logger.info("[start] testAddVehicleInValidVehicleType()");
		Vehicle vehicle = new Vehicle("Swift",null, 3, 40 , 1);
        vehicleController.addVehicle(vehicle);
        logger.error("Vehicle type cannot be null");
		logger.info("[End] testAddVehicleInValidVehicleType()");//.......Fail
		
	}

	@Test
     public void testaddVehicleValidFare() throws InvalidVehicleDataException, InvalidDriverDataException{
		
		logger.info("[start] testaddVehicleValidFare()");
		Vehicle vehicle = new Vehicle("Force","Bus", 75,15,1);
		assertNotNull("Vehicle Adding",vehicleController.addVehicle(vehicle));
		logger.info("[end] testaddVehicleValidFare()");//..........pass
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testaddVehicleInvalidFare() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleInvalidVehicleFare()");
		Vehicle vehicle = new Vehicle("Tata Kia", "Car", -20.5, 4, 1);
		vehicleController.addVehicle(vehicle);
		logger.info("[end] testModifyVehicleInvalidVehicleFare()");//.......working
	}
	
	@Test(expected = InvalidVehicleDataException.class)
	public void testViewVehicleInvalidVehicleNo() throws InvalidVehicleDataException {
		logger.info("[start] testViewVehicleInvalidVehicleNo()");
		vehicleController.viewVehicleByNo(-1);
		logger.info("[end] testViewVehicleInvalidVehicleNo()");
	}
	
	@Test
	public void testViewVehicleValidVehicleNo() throws InvalidVehicleDataException {
		logger.info("[start] testViewVehicleValidVehicleNo()");
		assertNotNull("View Vehicle here ", vehicleController.viewVehicleByNo(4));
		logger.info("[end] testViewVehicleValidVehicleNo()");
	}
}
