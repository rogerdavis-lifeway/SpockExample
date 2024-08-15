package com.sample.domain

import spock.lang.Specification
import com.fasterxml.jackson.databind.ObjectMapper;

class LegacyAddressTest extends Specification {

    def "test Address marshalling"() {

        ObjectMapper objectMapper = new ObjectMapper();

        given:
        LegacyAddress address = new LegacyAddress()
        address.setId("1234")
        address.setLine1("123 Main St")
        address.setLine2("Suite 200")
        address.setCity("Williamsport")
        address.setCountrySubdivision("TN")
        address.setPostalCode("38487")

        String json = objectMapper.writeValueAsString(address)
        LegacyAddress unmarshalled = objectMapper.readValue(json, LegacyAddress.class)
        expect:
        unmarshalled.id == address.id
        unmarshalled.line1 == address.line1
        unmarshalled.line2 == address.line2
        unmarshalled.city == address.city
        unmarshalled.countrySubdivision == address.countrySubdivision
        unmarshalled.postalCode == address.postalCode
    }

}
