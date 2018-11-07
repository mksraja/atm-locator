package nl.ing.test.vo;

import java.io.Serializable;


/**
 * This class is used to represent ATM Machine details as Value Object
 * 
 * @author Muthu
 *
 */
public class ATMDetail implements Serializable {

  private Integer id;
  private String atmCode;
  private String location;
  private String city;
  private String postCode;


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getAtmCode() {
    return atmCode;
  }

  public void setAtmCode(String atmCode) {
    this.atmCode = atmCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


}
