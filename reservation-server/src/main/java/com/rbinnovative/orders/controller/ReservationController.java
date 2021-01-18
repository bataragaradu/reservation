package com.rbinnovative.orders.controller;

import com.rb.innovative.client.ApiException;
import com.rb.innovative.client.model.Order;
import com.rbinnovative.orders.exception.ReservationException;
import com.rbinnovative.orders.service.ReservationProcessorImpl;
import com.rbinnovative.orders.utils.Constants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = Constants.RESERVATION_ENDPOINT)
public class ReservationController {

	private final Logger logger = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private ReservationProcessorImpl reservationProcessor;

	/**
	 * Support for GET /orders endpoint
	 * @return the id of created orders
	 */
	@ApiOperation(value = "POST orders ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Save a new order"),
			@ApiResponse(code = 400, message = " order already exists with that key could not be found")})
	@RequestMapping(value ="/{toolId}", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> fetchToolAvailableDates(@Valid @RequestBody Order reservationRequest) throws ReservationException, ApiException {

		logger.info("GET all orders");
		List<Order> ordersDTOs = reservationProcessor.processAllQuery();
		logger.info("GET all orders response {}", ordersDTOs);
		return ResponseEntity.ok().body(ordersDTOs);
	}

	/**
	 * Support for POST /orders endpoint
	 * @return the id of created orders
	 */
	@ApiOperation(value = "POST orders ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Save a new order"),
			@ApiResponse(code = 400, message = " order already exists with that key could not be found")})
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createReservation(@Valid @RequestBody Order reservationRequest) throws ReservationException, ApiException {

		logger.info("Save a new reservation {}", reservationRequest);
		Integer reservationId = reservationProcessor.createReservation(reservationRequest);
		logger.info("POST successfully saved reservation with id {}", reservationId);
		return ResponseEntity.ok().body(reservationId.toString());
	}

//		/**
//	 * Support for DELETE /reservation endpoint
//	 * @return the id of deleted reservation
//	 */
//	@ApiOperation(value = "DELETE reservation ")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Remove a reservation"),
//			@ApiResponse(code = 400, message = " reservation with that id could not be found")})
//	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> deleteReservation(@PathVariable Integer id) throws ReservationException {
//
//		logger.info("Remove a reservation with id {}", id);
//		reservationProcessor.removeReservation(id);
//		logger.info("DELETE  response sent with no body");
//		return ResponseEntity.ok().body(StringUtils.EMPTY);
//	}
}
