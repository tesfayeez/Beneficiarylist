package com.example.benficiary;

import android.content.Context;
import android.util.Log;

import com.example.benficiary.Model.Beneficiary;
import com.example.benficiary.Model.BeneficiaryAddress;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for loading and parsing JSON data related to beneficiaries from the application's assets.
 * This class provides static methods to read a JSON file, parse it, and convert it into a list of Beneficiary objects.
 */
public class JsonUtils {
    private static final String TAG = JsonUtils.class.getSimpleName();

    public static List<Beneficiary> loadBeneficiariesFromAssets(Context context) {
        List<Beneficiary> beneficiaryList = new ArrayList<>();
        try {
            Log.d(TAG, "Opening Beneficiaries.json file.");
            InputStream inputStream = context.getAssets().open("Beneficiaries.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, "UTF-8");
            Log.d(TAG, "JSON file read successfully. Parsing JSON.");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject obj = jsonArray.getJSONObject(i);
                Beneficiary beneficiary = new Beneficiary();
                beneficiary.setFirstName(obj.optString("firstName",""));
                beneficiary.setLastName(obj.optString("lastName",""));
                beneficiary.setMiddleName(obj.optString("middleName",""));
                beneficiary.setDesignationCode(obj.optString("designationCode",""));
                beneficiary.setDateOfBirth(obj.optString("dateOfBirth",""));
                beneficiary.setBeneType(obj.optString("beneType",""));
                beneficiary.setSocialSecurityNumber(obj.optString("socialSecurityNumber",""));

                JSONObject addressObj = obj.optJSONObject("beneficiaryAddress");

                if (addressObj != null) {

                    BeneficiaryAddress beneficiaryAddress = new BeneficiaryAddress();
                    beneficiaryAddress.setFirstLineMailing(addressObj.optString("firstLineMailing",""));
                    beneficiaryAddress.setSecondLineMailing(obj.optString("secondLineMailing", ""));
                    beneficiaryAddress.setCity(addressObj.optString("city",""));
                    beneficiaryAddress.setZipCode(addressObj.optString("zipCode",""));
                    beneficiaryAddress.setStateCode(addressObj.optString("stateCode",""));
                    beneficiaryAddress.setCountry(addressObj.optString("country",""));
                    beneficiary.setBeneficiaryAddress(beneficiaryAddress);
                }
                Log.d(TAG, "Added beneficiary: " + beneficiary.toString());
                beneficiaryList.add(beneficiary);
            }
            Log.d(TAG, "Beneficiaries loaded and converted successfully.");
            return beneficiaryList;
        } catch (Exception e) {
            Log.e(TAG, "Error loading or parsing Beneficiaries.json", e);
            return null;
        }
    }
}
