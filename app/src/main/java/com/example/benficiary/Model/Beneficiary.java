package com.example.benficiary.Model;

import com.example.benficiary.Utils.Utils;

/**
 * Represents an individual beneficiary with detailed personal and contact information.
 * This class encapsulates information such as the beneficiary's name, designation code,
 * beneficiary type, social security number, date of birth, and mailing address.
 *
 * Constructors:
 *  - Beneficiary(): Initializes a new instance of the Beneficiary class without setting any fields.
 *  - Beneficiary(String firstName, String lastName, String middleName, String designationCode,
 *                String beneType, String socialSecurityNumber, String dateOfBirth,
 *                BeneficiaryAddress beneficiaryAddress): Initializes a new instance with detailed
 *                information about the beneficiary.
 *
 * Methods:
 *  - Getter and setter methods for firstName, lastName, middleName, designationCode, beneType,
 *    socialSecurityNumber, dateOfBirth, and beneficiaryAddress.
 *  - getDesignation(): Converts the designationCode ('P' for Primary, 'C' for Contingent, others to 'Unknown')
 *    to a more readable format.
 *  - getDateOfBirth(): Utilizes the Utils.convertDateFormat method to transform the stored
 *    dateOfBirth from "MMddyyyy" format to "MM/dd/yyyy".
 *  - toString(): Provides a string representation of the Beneficiary object, combining
 *    the first name, last name, beneficiary type, and designation.
 *
 * This class relies on the BeneficiaryAddress class to manage address details and
 * uses utility methods from the Utils class for date formatting.
 */
public class Beneficiary {
    private String firstName;
    private String lastName;
    private String middleName;
    private String designationCode;
    private String beneType;
    private String socialSecurityNumber;
    private String dateOfBirth;



    private BeneficiaryAddress beneficiaryAddress;

    public Beneficiary(String firstName, String lastName, String middleName,String designationCode, String beneType, String socialSecurityNumber, String dateOfBirth, BeneficiaryAddress beneficiaryAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.designationCode = designationCode;
        this.beneType = beneType;
        this.socialSecurityNumber = socialSecurityNumber;
        this.dateOfBirth = dateOfBirth;
        this.beneficiaryAddress = beneficiaryAddress;
    }
    public  Beneficiary(){}


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {return middleName;}

    public void setMiddleName(String middleName) {this.middleName = middleName;}
    public String getDesignation() {
        return "P".equalsIgnoreCase(designationCode) ? "Primary" : "C".equalsIgnoreCase(designationCode) ? "Contingent" : "Unknown";
    }

    public void setDesignationCode(String designationCode) {
        this.designationCode = designationCode;
    }

    public String getBeneType() {
        return beneType;
    }

    public void setBeneType(String beneType) {
        this.beneType = beneType;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getDateOfBirth() {
        return Utils.convertDateFormat(this.dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BeneficiaryAddress getBeneficiaryAddress() {
        return beneficiaryAddress;
    }

    public void setBeneficiaryAddress(BeneficiaryAddress beneficiaryAddress) {
        this.beneficiaryAddress = beneficiaryAddress;
    }
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " - " + getBeneType() + getDesignation();
    }

}
