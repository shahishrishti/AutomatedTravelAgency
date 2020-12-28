package com.cgtravelagency.controllertest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cgtravelagency.controller.RouteController;
import com.cgtravelagency.json.Route;

class RouteControllerTest {

	private static Logger logger;
	private static RestTemplate restTemplate;
	
	@BeforeAll
	public static void setUp() {
		logger = LogManager.getLogger(RouteControllerTest.class.getName());
		restTemplate = new RestTemplate();
	}

	RouteController routeController=new RouteController();
	
	@Test
	void testgetRouteByValidSource()
	{
		logger.info("[START] Test to get Route By Valid Source.");
		ResponseEntity<Route[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgata/route/Mumbai", Route[].class);
		assertNotNull(responseEntity);
		logger.info("[END] Test to get Route By valid Source");
	}
	
	@Test()
	void testgetRouteByBlankSource() {
		
		logger.info("[START] Test to get Route by Blank Source");
		Exception exception = assertThrows(NullPointerException.class, () -> {
			routeController.getRouteBySource("");
		});
		logger.info("[END] Test to get Route by Blank Source");
		
	}
	
	
	@Test
	void testgetRouteByValidDestination()
	{
		logger.info("[START] Test to get Route By Valid Destination.");
		ResponseEntity<Route[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgata/route/Pune", Route[].class);
		assertNotNull(responseEntity);
		logger.info("[END] Test to get Route By valid Destination");
	}
	
	@Test()
	void testgetRouteByBlankDestination() {
		
		logger.info("[START] Test to get Route by Blank Destination");
		Exception exception = assertThrows(NullPointerException.class, () -> {
			routeController.getRouteByDestination("");
		});
		logger.info("[END] Test to get Route by Blank Destination");
		
	}
	
	@Test
	void testgetRouteByValidDistance()
	{
		logger.info("[START] Test to get Route By Valid Distance.");
		ResponseEntity<Route[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgata/route/46.9", Route[].class);
		assertNotNull(responseEntity);
		logger.info("[END] Test to get Route By valid Source");
	}
	
	
	
//	@Test
//	void testgetRouteByValidSourceAndDestination()
//	{
//		logger.info("[START] Test to get Route By Valid Source And Destination.");
//		ResponseEntity<Route[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/cgata/route/Mumbai/Pune", Route[].class);
//		assertNotNull(responseEntity);
//		logger.info("[END] Test to get Route By valid Source And Destination");
//	}
	
	@Test()
	void testgetRouteByBlankSourceAndDestination() {
		
		logger.info("[START] Test to get Route by Blank Source And Destination");
		Exception exception = assertThrows(NullPointerException.class, () -> {
			routeController.getRouteBySourceAndDestination("","");
		});
		logger.info("[END] Test to get Route by Blank Source And Destination");
		
	}
	
	@Test
	void testcreateRoute() {
		logger.info("[START] Test to Add Route ");
		Route route=new Route("Mumbai","Pune",200.6);
		restTemplate.postForObject("http://localhost:9090/cgata/route/add", route,Route.class);
		logger.info("[END] Test to Add Route ");
		
	}

}
