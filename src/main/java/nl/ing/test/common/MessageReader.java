package nl.ing.test.common;

import java.util.Locale;

import nl.ing.test.common.exception.BusinessServiceRuntimeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * This class is used to read the messages, error messages from the properties files This class
 * injects the MessageSource declared in Spring context file 
 *  
 * @author Muthu
 *
 */
@Component
public class MessageReader {

  @Autowired
  private MessageSource messageSource;

  /**
   * This method is used to read the locale specific message based on the message code
   * 
   * @param code - The Message code
   * @return message - The Message description
   */
  public String readMessage(String code) {
    String message;
    try {
      Locale locale = LocaleContextHolder.getLocale();
      message = messageSource.getMessage(code, null, locale);
    } catch (NoSuchMessageException nex) {
      throw new BusinessServiceRuntimeException(nex);
    }
    return message;
  }

}
