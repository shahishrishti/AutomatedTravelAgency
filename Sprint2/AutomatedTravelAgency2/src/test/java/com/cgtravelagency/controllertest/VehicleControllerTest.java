package com.cgtravelagency.controllertest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.cgtravelagency.controller.VehicleController;
import com.cgtravelagency.json.Vehicle;
import com.cgtravelagency.json.VehicleType;

@SpringBootTest
class VehicleControllerTest {

	@Autowired
	private static VehicleController vehicleController;
	private static Logger logger;
	private static RestTemplate restTemplate;
	
	@BeforeAll
	public static void setUp() {
		logger = LogManager.getLogger(VehicleControllerTest.class.getName());
		restTemplate = new RestTemplate();
	}
	
	
	@Test
	void testDeleteByValidVehicleNo() {
		
		logger.info("[START] Test to Delete by Valid Vehicle No");
		restTemplate.delete("http://localhost:9090/cgata/vehicle/GJ 01 AF 8192", Vehicle.class);
		logger.info("[END] Test to Delete by Valid Vehicle No");
		
	}
	
	@Test()
	void testDeleteByBlankVehicleNo() {
		
		logger.info("[START] Test to Delete by Blank Vehicle No");
		Exception exception = assertThrows(NullPointerException.class, () -> {
			vehicleController.deleteVehicle("");
		});
		logger.info("[END] Test to Delete by Valid Vehicle No");
		
	}
	
	@Test
	void testModifyByValidVehicleNo() {
		
		logger.info("[START] Test to Modify by Valid Vehicle No");
		Vehicle vehicle = new Vehicle("MP 01 AF 8192", "Swift", 90, new VehicleType(1l, "Car", 4), null);
		restTemplate.put("http://localhost:9090/cgata/vehicle/MP 01 AF 8192", vehicle, Vehicle.class);
		logger.info("[END] Test to Modify by Valid Vehicle No");
		
	}

}
