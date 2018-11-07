package nl.ing.test.security;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import nl.ing.test.vo.ATMDetail;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application*.xml" })
public class TestBasicSecurity {

  @Autowired
  private RestTemplate restTemplate;
  
  @Test(expected = HttpClientErrorException.class)
  public final void whenInvokeUnAuthorized_thenNot200OK() {
    
    final ResponseEntity<ATMDetail[]> responseEntity =
        restTemplate.exchange("http://localhost:8080/testapp/api/locator/atms", HttpMethod.GET, null,
            ATMDetail[].class);
    //assertThat(responseEntity.getStatusCode().value(), not(equalTo(200)));
  }


  @Test
  public final void whenInvokeAlldetails_then200OK() {
    HttpEntity<String> request = new HttpEntity<String>(basicAuthHeaders());
    final ResponseEntity<ATMDetail[]> responseEntity =
        restTemplate.exchange("http://localhost:8080/testapp/api/locator/atms", HttpMethod.GET, request,
            ATMDetail[].class);
    assertThat(responseEntity.getStatusCode().value(), equalTo(200));
  }
  
  @Test
  public final void whenInvokeByCity_then200OK() {
    HttpEntity<String> request = new HttpEntity<String>(basicAuthHeaders());
    final ResponseEntity<ATMDetail[]> responseEntity =
        restTemplate.exchange("http://localhost:8080/testapp/api/locator/amsterdam/atms", HttpMethod.GET, request,
            ATMDetail[].class);
    assertThat(responseEntity.getStatusCode().value(), equalTo(200));
  }

  
  private HttpHeaders basicAuthHeaders() {
    String plainCreds = "test:test123";
    byte[] plainCredsBytes = plainCreds.getBytes();
    byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
    String base64Creds = new String(base64CredsBytes);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Basic " + base64Creds);
    return headers;
  }

}
