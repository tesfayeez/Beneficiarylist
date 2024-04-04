package com.example.benficiary.Model;

import android.util.Log;
/**
 * Represents the address of a beneficiary.
 * This class encapsulates details such as the mailing address, city, zip code, state code, and country
 * necessary for identifying a beneficiary's location. It supports handling both addresses that have a
 * second line and those that do not.
 *
 * Constructors:
 *  - BeneficiaryAddress(): Initializes a new instance of the BeneficiaryAddress class without setting any properties.
 *  - BeneficiaryAddress(String firstLineMailing, String secondLineMailing, String city, String zipCode, String stateCode, String country):
 *    Initializes a new instance with detailed information for each part of the address.
 *
 * Methods:
 *  - getFirstLineMailing(): Returns the first line of the mailing address.
 *  - setFirstLineMailing(String firstLineMailing): Sets the first line of the mailing address.
 *  - getSecondLineMailing(): Returns the second line of the mailing address, which may be null if not provided.
 *  - setSecondLineMailing(String secondLineMailing): Sets the second line of the mailing address.
 *  - getCity(): Returns the city part of the address.
 *  - setCity(String city): Sets the city part of the address.
 *  - getZipCode(): Returns the postal/zip code of the address.
 *  - setZipCode(String zipCode): Sets the postal/zip code of the address.
 *  - getStateCode(): Returns the state code of the address.
 *  - setStateCode(String stateCode): Sets the state code of the address.
 *  - getCountry(): Returns the country part of the address.
 *  - setCountry(String country): Sets the country part of the address.
 *
 */
public class BeneficiaryAddress {
    private String firstLineMailing;
    private String secondLineMailing;
    private String city;
    private String zipCode;
    private String stateCode;
    private String country;

    public BeneficiaryAddress(String firstLineMailing, String secondLineMailing, String city, String zipCode, String stateCode, String country) {
        this.firstLineMailing = firstLineMailing;
        this.secondLineMailing = secondLineMailing;
        this.city = city;
        this.zipCode = zipCode;
        this.stateCode = stateCode;
        this.country = country;
    }

    public BeneficiaryAddress(){}
    public String getFirstLineMailing() {
        return firstLineMailing;
    }

    public void setFirstLineMailing(String firstLineMailing) {
        this.firstLineMailing = firstLineMailing;
    }

    public String getSecondLineMailing() {
        return secondLineMailing;
    }

    public void setSecondLineMailing(String secondLineMailing) {
        this.secondLineMailing = secondLineMailing;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
