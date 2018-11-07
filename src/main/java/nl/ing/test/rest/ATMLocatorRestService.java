package nl.ing.test.rest;

import java.util.List;

import nl.ing.test.service.ATMLocatorService;
import nl.ing.test.vo.ATMDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This Rest Service is used to locate ATM Machines in all the cities in Netherlands
 * 
 * @author Muthu
 *
 */
@Controller
@RequestMapping(value = "/locator")
public class ATMLocatorRestService {

  @Autowired
  private ATMLocatorService locatorService;


  /**
   * This method is used to return all ATM details
   * 
   * @return list - The ATMDetails list
   */
  @RequestMapping(value = "/atms", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<ATMDetail>> viewAllATMDetails() {

    List<ATMDetail> atmList = locatorService.getAllATMDetails();
    if (atmList == null || atmList.isEmpty()) {
      return new ResponseEntity<List<ATMDetail>>(atmList, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<List<ATMDetail>>(atmList, HttpStatus.OK);
    }
  }


  /**
   * This method is used to return all ATM details based on the given city name
   * 
   * @param city - City Name
   * @return list - The ATMDetails list
   */
  @RequestMapping(value = "/{city}/atms", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<ATMDetail>> viewATMDetails(@PathVariable("city") String city) {

    List<ATMDetail> atmList = locatorService.getATMDetailsByCity(city);
    if (atmList == null || atmList.isEmpty()) {
      return new ResponseEntity<List<ATMDetail>>(atmList, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<List<ATMDetail>>(atmList, HttpStatus.OK);
    }
  }

}
