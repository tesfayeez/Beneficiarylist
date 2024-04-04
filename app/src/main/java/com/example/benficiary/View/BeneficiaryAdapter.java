package com.example.benficiary.View;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import android.graphics.Color;
import android.widget.LinearLayout;

import com.example.benficiary.MainActivity;
import com.example.benficiary.Model.BeneficiaryAddress;
import com.example.benficiary.Model.Beneficiary;


/**
 * An adapter for displaying a list of beneficiaries in a RecyclerView. Each item in the list
 * represents a beneficiary's basic information and can be expanded to reveal additional details such as designation, SSN, DOB, and address.
 * Users can tap on an item to expand or collapse its details.
 */
public class BeneficiaryAdapter extends RecyclerView.Adapter<BeneficiaryAdapter.ViewHolder> {

    private static final String TAG = BeneficiaryAdapter.class.getSimpleName();

    private List<Beneficiary> beneficiaries;

    public BeneficiaryAdapter(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }
    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        //Main Layout
        LinearLayout mainLayout = new LinearLayout(context);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(30, 20, 30, 20);
        mainLayout.setLayoutParams(layoutParams);
        mainLayout.setBackgroundColor(Color.WHITE);
        mainLayout.setPadding(30, 30, 30, 30);
        mainLayout.setElevation(10);


        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        mainLayout.addView(frameLayout);
        // First Name , Middle Name and Last Name TextView
        TextView nameTextView = new TextView(context);
        FrameLayout.LayoutParams nameLayoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        nameLayoutParams.gravity = Gravity.START | Gravity.CENTER_VERTICAL;
        nameTextView.setLayoutParams(nameLayoutParams);
        nameTextView.setTextSize(18);
        nameTextView.setTypeface(null, Typeface.BOLD);
        frameLayout.addView(nameTextView);

        // Expand/Collapse Icon
        ImageView expandIcon = new ImageView(context);
        FrameLayout.LayoutParams iconLayoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        iconLayoutParams.gravity = Gravity.END | Gravity.CENTER_VERTICAL;
        expandIcon.setLayoutParams(iconLayoutParams);
        expandIcon.setImageResource(android.R.drawable.arrow_down_float);
        frameLayout.addView(expandIcon);

        // BeneType and Designation TextView
        TextView detailsTextView = new TextView(context);
        detailsTextView.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        detailsTextView.setTextSize(14);
        mainLayout.addView(detailsTextView);

        //Date of Birth TextVew
        TextView dateOfBirthTextView = new TextView(context);
        dateOfBirthTextView.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        dateOfBirthTextView.setVisibility(View.GONE);
        mainLayout.addView(dateOfBirthTextView);

        //SSN Container
        LinearLayout ssnContainer = new LinearLayout(context);
        ssnContainer.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        ssnContainer.setOrientation(LinearLayout.HORIZONTAL);
        ssnContainer.setVisibility(View.GONE);

        TextView ssnTextView = new TextView(context);

        LinearLayout.LayoutParams ssnTextViewParams = new LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1.0f
        );
        ssnTextView.setLayoutParams(ssnTextViewParams);
        ssnTextView.setTextSize(14);

        ImageView ssnToggleIcon = new ImageView(context);
        LinearLayout.LayoutParams ssnToggleIconParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        ssnToggleIcon.setLayoutParams(ssnToggleIconParams);

        ssnToggleIcon.setImageResource(android.R.drawable.ic_menu_view);
        ssnContainer.addView(ssnTextView);
        ssnContainer.addView(ssnToggleIcon);
        mainLayout.addView(ssnContainer);
        //Address Text View
        TextView addressTextView = new TextView(context);
        addressTextView.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        addressTextView.setTextSize(14);
        addressTextView.setVisibility(View.GONE);
        mainLayout.addView(addressTextView);


        // OnClick Listener for expanding and collapsing
        mainLayout.setOnClickListener(view -> {
            boolean isExpanded = (boolean) view.getTag();
            ssnContainer.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
            dateOfBirthTextView.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
            ssnToggleIcon.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
            addressTextView.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
            expandIcon.setImageResource(isExpanded ? android.R.drawable.arrow_down_float : android.R.drawable.arrow_up_float); // Change icon
            view.setTag(!isExpanded);
        });

        mainLayout.setTag(false);

        return new ViewHolder(mainLayout, nameTextView, detailsTextView, ssnTextView, dateOfBirthTextView,addressTextView, expandIcon,ssnToggleIcon);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Beneficiary beneficiary = beneficiaries.get(position);

        holder.nameTextView.setText(String.format("%s %s %s", beneficiary.getFirstName(),beneficiary.getMiddleName(), beneficiary.getLastName()));
        String designation = beneficiary.getDesignation();
        holder.detailsTextView.setText(String.format("%s - %s", beneficiary.getBeneType(), designation));
        String ssnPlaceholder = "SSN: ***-**-****";
        holder.ssnTextView.setText(ssnPlaceholder);
        holder.ssnToggleIcon.setTag(false);

        // Set OnClickListener for ssnToggleIcon icon
        holder.ssnToggleIcon.setOnClickListener(v -> {
            boolean isSsnVisible = (boolean) v.getTag();
            if (isSsnVisible) {
                holder.ssnTextView.setText(ssnPlaceholder);
                v.setTag(false);
            } else {
                holder.ssnTextView.setText("SSN: " + beneficiary.getSocialSecurityNumber());
                v.setTag(true);
            }
        });
        holder.dateOfBirthTextView.setText(
                String.format("DOB: %s", beneficiary.getDateOfBirth())
        );

        BeneficiaryAddress address = beneficiary.getBeneficiaryAddress();

        String fullAddress = String.format("Address:\n%s,%s,%s, %s %s, %s",
                address.getFirstLineMailing(),
                address.getSecondLineMailing(),
                address.getCity(),
                address.getStateCode(),
                address.getZipCode(),
                address.getCountry());

        fullAddress = fullAddress.replaceAll(",+", ",").replaceAll("(?m)^[ \t]*\r?\n", "");
        holder.addressTextView.setText(fullAddress);
    }

    @Override
    public int getItemCount() {
        return beneficiaries.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView,detailsTextView,dateOfBirthTextView,ssnTextView,addressTextView;
        ImageView expandIcon,ssnToggleIcon;
        ViewHolder(View itemView, TextView nameTextView, TextView detailsTextView,TextView ssnTextView, TextView dateOfBirthTextView, TextView addressTextView, ImageView expandIcon,ImageView ssnToggleIcon) {
            super(itemView);
            this.nameTextView = nameTextView;
            this.detailsTextView = detailsTextView;
            this.dateOfBirthTextView = dateOfBirthTextView;
            this.ssnTextView = ssnTextView;
            this.addressTextView = addressTextView;
            this.expandIcon = expandIcon;
            this.ssnToggleIcon =ssnToggleIcon;
        }
    }

}



