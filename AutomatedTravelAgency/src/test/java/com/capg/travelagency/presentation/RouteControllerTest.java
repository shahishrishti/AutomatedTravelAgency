package com.capg.travelagency.presentation;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.travelagency.dto.Route;
import com.capg.travelagency.exceptions.InvalidRouteDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;

public class RouteControllerTest {
	private static Logger logger;
	private static RouteController routeController;
	
	@BeforeClass
	public static void setUp() {
		logger = LogManager.getLogger(RouteControllerTest.class.getName());
		routeController = new RouteController();
	}

	@Test
	public void testAddRouteValidSource() throws InvalidVehicleDataException, InvalidRouteDataException{
		
		logger.info("[start] testAddRouteValidSource()");
		Route route = new Route("Pune","Mumbai", 250, 4, 8);
		assertNotNull("Route added",routeController.addRoute(route));
		logger.info("[end] testAddRouteValidSource()");//..........pass
	}
	
	@Test(expected = InvalidRouteDataException.class)
	public void testAddRouteInValidSource() throws InvalidVehicleDataException, InvalidRouteDataException  {
		logger.info("[start] testAddRouteInValidSource()");
		Route route = new Route(null,"Mumbai",250,4, 9);
        routeController.addRoute(route);
        logger.error("Source cannot be null.");
		logger.info("[End] testAddRouteInValidSource()");//.......Fail
		
	}
	
	@Test
	public void testAddRouteValidDestination() throws InvalidVehicleDataException, InvalidRouteDataException{
		
		logger.info("[start] testAddRouteValidDestination()");
		Route route = new Route("Mumbai","Pune", 250, 4, 10);
		assertNotNull("Route added",routeController.addRoute(route));
		logger.info("[end] testAddRouteValidDestination()");//..........pass
	}
	
	@Test(expected = InvalidRouteDataException.class)
	public void testAddRouteInValidDestination() throws InvalidVehicleDataException, InvalidRouteDataException  {
		logger.info("[start] testAddRouteInValidDestination()");
		Route route = new Route("Pune",null,250,4, 8);
        routeController.addRoute(route);
        logger.error("Destination cannot be null.");
		logger.info("[End] testAddRouteInValidDestination()");//.......Fail
		
	}
	
	@Test
	public void testAddRouteValidDistance() throws InvalidVehicleDataException, InvalidRouteDataException{
		
		logger.info("[start] testAddRouteValidDistance()");
		Route route = new Route("Mumbai","Delhi", 1250, 4, 9);
		assertNotNull("Route added",routeController.addRoute(route));
		logger.info("[end] testAddRouteValidDistance()");//..........pass
	}
	
	@Test(expected = InvalidRouteDataException.class)
	public void testAddRouteInValidDistance() throws InvalidVehicleDataException, InvalidRouteDataException  {
		logger.info("[start] testAddRouteInValidDistance()");
		Route route = new Route("Pune","Delhi",-1250,4, 10);
        routeController.addRoute(route);
        logger.error("Distance cannot be negative.");
		logger.info("[End] testAddRouteInValidDistance()");//.......Fail
		
	}
	
	@Test
	public void testAddRouteValidDuration() throws InvalidVehicleDataException, InvalidRouteDataException{
		
		logger.info("[start] testAddRouteValidDuration()");
		Route route = new Route("Mumbai","Delhi", 1250, 4, 8);
		assertNotNull("Route added",routeController.addRoute(route));
		logger.info("[end] testAddRouteValidDuration()");//..........pass
	}
	
	@Test(expected = InvalidRouteDataException.class)
	public void testAddRouteInValidDuration() throws InvalidVehicleDataException, InvalidRouteDataException  {
		logger.info("[start] testAddRouteInValidDuration()");
		Route route = new Route("Pune","Delhi",-1250,4, 9);
        routeController.addRoute(route);
        logger.error("Duration cannot be negative.");
		logger.info("[End] testAddRouteInValidDuration()");//.......Fail
		
	}
	@Test(expected = InvalidRouteDataException.class)
	public void testViewRouteInvalidRouteId() throws InvalidRouteDataException {
		logger.info("[start] testViewRouteInvalidRouteId()");
		routeController.viewRouteById(-1);
		logger.info("[end] testViewRouteInvalidRouteId()");
	}
	
	@Test
	public void testViewRouteValidRouteId() throws InvalidRouteDataException {
		logger.info("[start] testViewRouteValidRouteId()");
		assertNotNull("View Vehicle here ", routeController.viewRouteById(2));
		logger.info("[end] testViewRouteValidRouteId()");
	}


	@Test(expected = InvalidRouteDataException.class)
	public void testDeleteRouteInvalidRouteId() throws InvalidRouteDataException {
		logger.info("[start] testDeleteRouteInvalidRouteId()");
		routeController.deleteRoute(-11);
		logger.info("[end] testDeleteRouteInvalidRouteId()");
	}
	
	@Test
	public void testDeleteRouteValidRouteId() throws InvalidRouteDataException {
		logger.info("[start] testDeleteRouteValidRouteId()");
		assertNotNull("Route Found to be deleted", routeController.deleteRoute(62));
		logger.info("[end] testDeleteRouteValidRouteId()");
	}
	
	@Test(expected = InvalidRouteDataException.class)
	public void testModifyRouteInvalidRouteId() throws InvalidRouteDataException, InvalidVehicleDataException {
		logger.info("[start] testModifyRouteInvalidRouteId()");
		Route route=new Route(-11, "Bhopal", "Ujjain", 300, 03.50, 8);
		routeController.modifyRoute(route);
		logger.error("RouteId cannot be negative or zero");
		logger.info("[end] testModifyRouteInvalidRouteId()");
	}
	
	@Test
	public void testModifyRoutevalidRouteId() throws InvalidRouteDataException, InvalidVehicleDataException {
		logger.info("[start] testModifyRouteValidRouteId()");
		Route route=new Route(33, "Bhopal", "Indore", 300, 03.50, 8);
		assertNotNull("Route Found to be Updated", routeController.modifyRoute(route));
		logger.info("[end] testModifyRouteValidRouteId()");
	}
	
	
	@Test(expected = InvalidRouteDataException.class)
	public void testVehicleNoInvalidValue() throws InvalidVehicleDataException, InvalidRouteDataException {
		logger.info("[start] testVehicleNoInvalidValue()");
		Route route = new Route(33, "Bhopal", "Indore", 300, 03.50, -1);
		routeController.modifyRoute(route);
		logger.error("VehicleNo cannot be negative or zero");
		logger.info("[end] testVehicleNoInvalidValue()");
	}
	
	@Test
	public void testVehicleNoValidValue() throws InvalidVehicleDataException, InvalidRouteDataException {
		logger.info("[start] testVehicleNoValidValue()");
		Route route = new Route(33, "Bhopal", "Indore", 300, 03.50, 8);
		assertNotNull("Route Found to be Updated", routeController.modifyRoute(route));
		logger.info("[end] testSeatingCapacityValidValue()");
	}

	
	@Test(expected = InvalidRouteDataException.class)
	public void testModifyRouteInvalidSource() throws InvalidVehicleDataException, InvalidRouteDataException {
		logger.info("[start] testModifyRouteInvalidSource()");
		Route route = new Route(33, null, "Indore", 300, 03.50, 9);
		routeController.modifyRoute(route);
		logger.info("[end] testModifyRouteInvalidSource()");
	}
	
	@Test
	public void testModifyRouteValidSource() throws InvalidVehicleDataException, InvalidRouteDataException {
		logger.info("[start] testModifyRouteValidRouteId()");
		Route route=new Route(33, "Bhopal", "Indore", 300, 03.50, 10);
		assertNotNull("Route Found to be Updated", routeController.modifyRoute(route));
		logger.info("[end] testModifyRouteValidRouteId()");
	}
	
	@Test(expected = InvalidRouteDataException.class)
	public void testDistanceInvalidValue() throws InvalidVehicleDataException, InvalidRouteDataException {
		logger.info("[start] testDistanceInvalidValue()");
		Route route = new Route(33, "Bhopal", "Indore", -50, 03.50, 10);
		routeController.modifyRoute(route);
		logger.info("[end] testDistanceInvalidValue()");
	}
	
	@Test
	public void testDistanceValidValue() throws InvalidVehicleDataException, InvalidRouteDataException {
		logger.info("[start] testDistanceValidValue()");
		Route route = new Route(33, "Bhopal", "Indore", 300, 03.50, 8);
		assertNotNull("Route Found to be Updated", routeController.modifyRoute(route));
		logger.info("[end] testSeatingCapacityValidValue()");
	}

	@Test(expected = InvalidRouteDataException.class)
	public void testModifyRouteInvalidDestination() throws InvalidRouteDataException, InvalidVehicleDataException {
		logger.info("[start] testModifyRouteInvalidDestination()");
		Route route = new Route(33, "Pune", null, 350, 04.00, 8);
		routeController.modifyRoute(route);
		logger.info("[end] testModifyRouteInvalidDestination()");
	}
	
	@Test
	public void testModifyRouteValidDestination() throws InvalidVehicleDataException, InvalidRouteDataException {
		logger.info("[start] testModifyRouteValidRouteId()");
		Route route = new Route(33, "Pune", "Mumbai", 350, 04.00, 9);
		assertNotNull("Route Found to be Updated", routeController.modifyRoute(route));
		logger.info("[end] testModifyRouteValidRouteId()");
	}
	
	@Test(expected = InvalidRouteDataException.class)
	public void testDurationInvalidValue() throws InvalidVehicleDataException, InvalidRouteDataException {
		logger.info("[start] testDurationInvalidValue()");
		Route route = new Route(33, "Bhopal", "Indore", -300, 03.50, 9);
		routeController.modifyRoute(route);
		logger.info("[end] testDurationInvalidValue()");
	}
	
	@Test
	public void testDurationValidValue() throws InvalidVehicleDataException, InvalidRouteDataException {
		logger.info("[start] testDurationValidValue()");
		Route route = new Route(33, "Bhopal", "Indore", 300, 03.50, 9);
		assertNotNull("Route Found to be Updated", routeController.modifyRoute(route));
		logger.info("[end] testSeatingCapacityValidValue()");
	}
}
