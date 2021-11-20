package com.example.co2reductionapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.co2reductionapp.backend.Backend;
import com.example.co2reductionapp.backend.User;

import java.util.List;

public class CreateActivityDialog extends DialogFragment {
    enum SelectedVehicle {
        Walk,
        Bike,
        Train
    }

    enum SelectedActivity {
        PlantTree,
        Commute
   }

    private SelectedVehicle _selectedVehicle = SelectedVehicle.Walk;
    private SelectedActivity _selectedActivity = SelectedActivity.PlantTree;
    private String _distanceTravelled = "";

    private ProfileFragment _profileFragment;

    public CreateActivityDialog(ProfileFragment profileFragment) {
        _profileFragment = profileFragment;
    }

    @Override
    public void onStart() {
        super.onStart();

        Spinner activitySpinner = (Spinner) getDialog().findViewById(R.id.activity_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.activities_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(adapter);

        activitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                _selectedActivity = SelectedActivity.values()[position];

                switch (position) {
                    case 0:
                        break;
                    case 1:
                        ViewGroup p = (ViewGroup) getDialog().findViewById(R.id.commute_options);
                        LayoutInflater li = LayoutInflater.from(getContext());
                        li.inflate(R.layout.commuter_options, p);

                        Spinner selectedVehicleSpinner = (Spinner) getDialog().findViewById(R.id.vehicle_spinner);
                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.vehicles_array, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        selectedVehicleSpinner.setAdapter(adapter);

                        selectedVehicleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                _selectedVehicle = SelectedVehicle.values()[position];
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {}
                        });

                        EditText distanceEditText = (EditText) getDialog().findViewById(R.id.distance_edit_text);
                        distanceEditText.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {}

                            @Override
                            public void afterTextChanged(Editable s) {
                                _distanceTravelled = s.toString();
                            }
                        });


                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(getLayoutInflater().inflate(R.layout.dialog_create, null))
                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        updateGems();

                        _profileFragment.updateValues();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        Dialog d = builder.create();
        return d;
    }

    private void updateGems() {
        List<User> users = Backend.getUsers(getResources());
        User me = users.get(0);
        String status = "";

        switch (_selectedActivity) {
            case PlantTree:
                double _tCO2Saved = 0.004666667;
                int _kgCO2Saved = (int)(_tCO2Saved * 1000.0);

                me.setBlueGems(me.getBlueGems() + 500);
                me.setGreenGems(me.getGreenGems() + 91);

                status =
                        "You planted a tree! \uD83C\uDF33\n" +
                        "You save the equivalent of " + _kgCO2Saved + "kg of CO2 per year!\n" +
                        "You've earned 91 green and 500 blue gems for that!";
                showDialog(status);

                break;
            case Commute:
                double distanceTravelled = 0.0;
                try {
                    distanceTravelled = Double.parseDouble(_distanceTravelled);
                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(), _distanceTravelled + " is not a number!", Toast.LENGTH_LONG).show();
                    return;
                }

                double baseline = 0.000135;
                double tCO2perUnit = 0.0;

                if (_selectedVehicle == SelectedVehicle.Train) {
                    tCO2perUnit = 0.000035;
                }
                double tCO2Saved = (baseline - tCO2perUnit) * distanceTravelled;
                int kgCO2Saved = (int)(tCO2Saved * 1000.0);
                double reference = 0.108380173;

                int blueGems = 10;
                int greenGems = (int)(tCO2Saved / reference * 2100);

                status =
                        "You made your commute without the car! \uD83D\uDEB6 \uD83D\uDEB2 \uD83D\uDE86\n" +
                        "By using a " + _selectedVehicle.toString().toLowerCase() + " instead, you saved the equivalent of " + kgCO2Saved + " kg of CO2!\n" +
                        "You get " + greenGems + " green gems and 10 blue gems for that!";

                showDialog(status);

                me.setBlueGems(me.getBlueGems() + greenGems);
                me.setGreenGems(me.getGreenGems() + blueGems);

                break;
        }
    }

    private void showDialog(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setMessage(text);
        builder.show();
    }
}
