package com.cgtravelagency.controllertest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cgtravelagency.controller.VehicleController;
import com.cgtravelagency.json.Route;
import com.cgtravelagency.json.Vehicle;
import com.cgtravelagency.json.VehicleType;


class VehicleControllerTest {

	private static Logger logger;
	private static RestTemplate restTemplate;
	
	VehicleController vehicleController = new VehicleController();
	
	@BeforeAll
	public static void setUp() {
		logger = LogManager.getLogger(VehicleControllerTest.class.getName());
		restTemplate = new RestTemplate();
	}
	
	@Test
	void testDeleteByValidVehicleNo() {
		
		logger.info("[START] Test to Delete by Valid Vehicle No");
		restTemplate.delete("http://localhost:9090/cgata/vehicle/MH 01 AB 1234", Vehicle.class);
		logger.info("[END] Test to Delete by Valid Vehicle No");
		
	}
	
	@Test
	void testModifyByValidVehicleNo() {
		
		logger.info("[START] Test to Modify by Valid Vehicle No");
		Vehicle vehicle = new Vehicle("MH 01 AB 8192", "Swift", 90, new VehicleType(1l, "Car", 4), null);
		restTemplate.put("http://localhost:9090/cgata/vehicle/MH 01 AB 1234", vehicle, Vehicle.class);
		logger.info("[END] Test to Modify by Valid Vehicle No");
		
	}
	
	@Test
	void testAddVehicleWithValidVehicleNo()
	{
		logger.info("[START] Test to Add Vehicle with valid VehicleNo");
		Vehicle vehicle = new Vehicle("MH 01 AS 5555","Nissan", 500, new VehicleType(1l, "Car", 4), new Route(1l, "Mumbai","Pune",250));
		restTemplate.postForObject("http://localhost:9090/cgata/vehicle/add", vehicle, Vehicle.class);
		logger.info("[END] Test to Add Vehicle with  Valid Vehicle No");
   }
	
	/*@Test()
	void testAddBVehicleWithBlankVehicleNo() {
		
		logger.info("[START] Test to Add vehicle with blank Vehicle No");
		Exception exception = assertThrows(NullPointerException.class, () -> {
			vehicleController.deleteVehicle("");
		});
		logger.info("[END] Test to Add vehicle with Blank Vehicle No");
		
	}
	}*/
	
	@Test
	void testAddVehicleWithValidVehicleName()
	{
		logger.info("[START] Test to Add Vehicle with valid Vehicle Name");
		Vehicle vehicle = new Vehicle("MH 01 AS 3456","Jeep", 250, new VehicleType(2l, "Car", 4), new Route(2l, "Mumbai","Pune",250));
		restTemplate.postForObject("http://localhost:9090/cgata/vehicle/add", vehicle, Vehicle.class);
		logger.info("[END] Test to Add Vehicle with  Valid Vehicle Name");
	}
	
	@Test
	void testViewVehicleByValidVehicleNo()
	{
		logger.info("[START] Test to view vehicle with valid vehicle No.");
		restTemplate.getForObject("http://localhost:9090/cgata/vehicle/filters/MH 01 AB 1234", Vehicle.class);
		logger.info("[END] Test to view vehicle with Valid Vehicle No");
		
	}
	
	@Test
	void testViewVehicleByBlankVehicleNo()
	{
		logger.info("[START] Test to view vehicle with Blank vehicle No.");
		Exception exception = assertThrows(NullPointerException.class, () -> {
			vehicleController.getVehicleByNo("");
		});
		logger.info("[END] Test to view vehicle with Blank  Vehicle No");
	}
	
	@Test
	void testViewVehicleByValidVehicleName()
	{
		logger.info("[START] Test to view vehicle with valid vehicle Name.");
		ResponseEntity<Vehicle[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgata/vehicle/filter/Swift", Vehicle[].class);
		assertNotNull(responseEntity);
		logger.info("[END] Test to view vehicle with Valid Vehicle Name");
	}
		
	
	
	@Test
	void testViewVehicleByBlankVehicleName()
	{
		logger.info("[START] Test to view vehicle with Blank vehicle No.");
		Exception exception = assertThrows(NullPointerException.class, () -> {
			vehicleController.getVehicleByName("");
		});
		logger.info("[END] Test to view vehicle with Blank  Vehicle Name");
	}
	
	@Test
	void testViewVehicleByValidFare()
	{
		logger.info("[START] Test to view vehicle with valid fare.");
		ResponseEntity<Vehicle[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgata/vehicle/filtering/250", Vehicle[].class);
		assertNotNull(responseEntity);
		logger.info("[END] Test to view vehicle with Valid fare");
		
	}
	@Test
	void testViewVehicleByBlankFare()
	{
		logger.info("[START] Test to view vehicle with Blank Fare value");
		Exception exception = assertThrows(NullPointerException.class, () -> {
			vehicleController.getVehicleByFare(0);
		});
		logger.info("[END] Test to view vehicle with Blank Fare value");
	}
}
	
	
	
	

