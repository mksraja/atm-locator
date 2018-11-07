package nl.ing.test.service;

import java.util.List;

import nl.ing.test.vo.ATMDetail;

/**
 * This Service is used to provide business operations for ATM Locator
 * 
 * @author Muthu
 *
 */
public interface ATMLocatorService {
  
  /**
   * This method is used to provide list of ATM details based on the given city
   * 
   * @param city - City name
   * @return list - List of ATMDetailVO
   */
  public List<ATMDetail> getATMDetailsByCity(String city);
  
  /**
   * This method is used return all ATM details
   * 
   * @return details - List of ATMDetail
   */
  public List<ATMDetail> getAllATMDetails();

}
