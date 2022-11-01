package com.endava.jackson;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.endava.google.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JacksonExample {
    public static final Logger LOGGER = LogManager.getLogger(JacksonExample.class);

    public static void main(String[] args) throws JsonProcessingException {
        Payment p = new Payment();
        p.setAmount(150.5);
        p.setCurrency("EUR");
        p.setCardNumber("1234000012340000");
        p.setCustomerName("Danny DeVitto");

        ObjectMapper  objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(p);
        LOGGER.info(json);

        Payment dP = objectMapper.readValue(json, Payment.class);
        LOGGER.info(dP.equals(p));
    }
}
