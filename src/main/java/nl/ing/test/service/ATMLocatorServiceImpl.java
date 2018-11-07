package nl.ing.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.ing.test.vo.ATMDetail;

import org.springframework.stereotype.Service;

@Service
public class ATMLocatorServiceImpl implements ATMLocatorService {

  /**
   * This method is used to provide list of ATM details based on the given city
   * 
   * @param city - City name
   * @return list - List of ATM
   */
  public List<ATMDetail> getATMDetailsByCity(String city) {
    // In real world this should invoke external service or Data Access to retrieve the data
    return getATMDetails(city);
  }



  /**
   * This method is used return all ATM details
   * 
   * @return details - List of ATMDetail
   */
  public List<ATMDetail> getAllATMDetails() {
    Map<String, List<ATMDetail>> atmMap = populateATMDetails();
    List<ATMDetail> atmList = new ArrayList<ATMDetail>();
    for (Map.Entry<String, List<ATMDetail>> entry : atmMap.entrySet()) {
      atmList.addAll(atmMap.get(entry.getKey()));
    }
    return atmList;
  }

  /**
   * This method is used to hard code all the ATM names and return the list based on the given city
   * name
   * 
   * @param city
   * @return
   */
  private List<ATMDetail> getATMDetails(String city) {

    Map<String, List<ATMDetail>> atmMap = populateATMDetails();
    List<ATMDetail> atmList = new ArrayList<ATMDetail>();
    
    if ("amsterdam".equalsIgnoreCase(city)) {
      atmList.addAll(atmMap.get("amsterdam"));
    } else if ("amstelveen".equalsIgnoreCase(city)) {
      atmList.addAll(atmMap.get("amstelveen"));
    } else if ("others".equalsIgnoreCase(city)){
      atmList.addAll(atmMap.get("others"));
    } 
    return atmList;
  }

  /**
   * This method populates dummy data
   * 
   * @return
   */
  private Map<String, List<ATMDetail>> populateATMDetails () {
    Map<String, List<ATMDetail>> atmMap = new HashMap<String, List<ATMDetail>>();
    List<ATMDetail> atmList1 = new ArrayList<ATMDetail>();
    List<ATMDetail> atmList2 = new ArrayList<ATMDetail>();
    List<ATMDetail> atmList3 = new ArrayList<ATMDetail>();
    ATMDetail atm1 = new ATMDetail();
    atm1.setId(1);
    atm1.setAtmCode("ATM_1");
    atm1.setCity("Amsterdam");
    atm1.setLocation("Amsterdam Centrum");
    atm1.setPostCode("1111 XX");
    
    ATMDetail atm11 = new ATMDetail();
    atm11.setId(11);
    atm11.setAtmCode("ATM_11");
    atm11.setCity("Amsterdam");
    atm11.setLocation("Diemen");
    atm11.setPostCode("1112 XR");

    atmList1.add(atm1);
    atmList1.add(atm11);
    atmMap.put("amsterdam", atmList1);
    
    ATMDetail atm2 = new ATMDetail();
    atm2.setId(2);
    atm2.setAtmCode("ATM_2");
    atm2.setCity("Amstelveen");
    atm2.setLocation("Amstelveen Centrum");
    atm2.setPostCode("1111 XR");
    
    ATMDetail atm22 = new ATMDetail();
    atm22.setId(22);
    atm22.setAtmCode("ATM_22");
    atm22.setCity("Amstelveen");
    atm22.setLocation("Amstelveen Ulinstede");
    atm22.setPostCode("1081 CM");

    atmList2.add(atm2);
    atmList2.add(atm22);
    atmMap.put("amstelveen", atmList2);

    
    ATMDetail atm3 = new ATMDetail();
    atm3.setId(3);
    atm3.setAtmCode("ATM_3");
    atm3.setCity("Hoofdarp");
    atm3.setLocation("Hoofdarp Centrum");
    atm3.setPostCode("1111 XR");
    
    ATMDetail atm33 = new ATMDetail();
    atm33.setId(33);
    atm33.setAtmCode("ATM_33");
    atm33.setCity("Oss");
    atm33.setLocation("OSS Centrum");
    atm33.setPostCode("1211 MC");

    atmList3.add(atm3);
    atmList3.add(atm33);
    atmMap.put("others", atmList3);

    return atmMap;
  }
  

}
