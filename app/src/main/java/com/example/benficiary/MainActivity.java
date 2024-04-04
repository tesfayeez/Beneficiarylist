package com.example.benficiary;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benficiary.View.BeneficiaryAdapter;
import com.example.benficiary.ViewModel.BeneficiaryViewModel;

import java.util.ArrayList;
/**
 * MainActivity serves as the entry point for the application, hosting the primary user interface.
 * This activity is responsible for setting up and displaying a RecyclerView that lists beneficiaries.
 * It utilizes BeneficiaryViewModel to fetch and observe beneficiary data, updating the UI accordingly.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private BeneficiaryViewModel viewModel;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a LinearLayout as a container
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setOrientation(LinearLayout.VERTICAL);

        // init the RecyclerView
        recyclerView = new RecyclerView(this);
        recyclerView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BeneficiaryAdapter adapter = new BeneficiaryAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        layout.addView(recyclerView);

        setContentView(layout);

        // Init ViewModel
        viewModel = new ViewModelProvider(this).get(BeneficiaryViewModel.class);

        // Observe the ViewModel's liveData for beneficiaries
        viewModel.getBeneficiaries().observe(this, beneficiaries -> {
            Log.i(TAG, beneficiaries.toString());
            adapter.setBeneficiaries(beneficiaries);
        });
        viewModel.loadBeneficiaries(getApplicationContext());
    }
}

