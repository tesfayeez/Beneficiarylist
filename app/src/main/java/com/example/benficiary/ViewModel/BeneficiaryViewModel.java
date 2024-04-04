package com.example.benficiary.ViewModel;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.benficiary.JsonUtils;
import com.example.benficiary.Model.Beneficiary;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * ViewModel responsible for loading and providing a list of beneficiaries.
 * It interacts with the JsonUtils class to load beneficiary data from the applications assets.
 */
public class BeneficiaryViewModel extends ViewModel {
    private static final String TAG = BeneficiaryViewModel.class.getSimpleName();
    private MutableLiveData<List<Beneficiary>> beneficiaries;
    public LiveData<List<Beneficiary>> getBeneficiaries() {
        if (beneficiaries == null) {
            beneficiaries = new MutableLiveData<>();
        }
        return beneficiaries;
    }

    public void loadBeneficiaries(Context context) {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<Beneficiary> beneficiaryList = JsonUtils.loadBeneficiariesFromAssets(context);
            new Handler(Looper.getMainLooper()).post(() -> {
                Log.d(TAG, "Loaded successfully");
                beneficiaries.setValue(beneficiaryList);
            });
        });
    }
}
