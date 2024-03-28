package com.example.sit305task21p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    private Spinner spinnerConversionType;
    private Spinner spinnerSourceUnit;
    private Spinner spinnerDestinationUnit;
    private EditText editTextValue;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        spinnerConversionType = findViewById(R.id.spinner_conversion_type);
        spinnerSourceUnit = findViewById(R.id.spinner_source_unit);
        spinnerDestinationUnit = findViewById(R.id.spinner_destination_unit);
        editTextValue = findViewById(R.id.edit_text_value);
        buttonConvert = findViewById(R.id.button_convert);
        textViewResult = findViewById(R.id.text_view_result);

        // Set up spinner for conversion type
        ArrayAdapter<CharSequence> adapterConversionType = ArrayAdapter.createFromResource(this,
                R.array.conversion_types, android.R.layout.simple_spinner_item);
        adapterConversionType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConversionType.setAdapter(adapterConversionType);

        // Set listener for conversion type spinner
        spinnerConversionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get selected conversion type
                String conversionType = parent.getItemAtPosition(position).toString();

                // Update source and destination unit spinners
                updateUnitSpinners(conversionType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Set listener for conversion button
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
    }

    private void updateUnitSpinners(String conversionType) {
        String[] sourceUnitsArray;
        String[] destinationUnitsArray;

        // Update source and destination units based on conversion type
        switch (conversionType) {
            case "Temperature":
                sourceUnitsArray = getResources().getStringArray(R.array.source_units_temperature);
                destinationUnitsArray = getResources().getStringArray(R.array.destination_units_temperature);
                break;
            case "Weight":
                sourceUnitsArray = getResources().getStringArray(R.array.source_units_weight);
                destinationUnitsArray = getResources().getStringArray(R.array.destination_units_weight);
                break;
            case "Length":
            default:
                sourceUnitsArray = getResources().getStringArray(R.array.source_units_length);
                destinationUnitsArray = getResources().getStringArray(R.array.destination_units_length);
                break;
        }

        // Update source unit spinner
        ArrayAdapter<String> sourceUnitAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sourceUnitsArray);
        sourceUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSourceUnit.setAdapter(sourceUnitAdapter);

        // Update destination unit spinner
        ArrayAdapter<String> destinationUnitAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, destinationUnitsArray);
        destinationUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDestinationUnit.setAdapter(destinationUnitAdapter);
    }

    private void performConversion() {
        String conversionType = spinnerConversionType.getSelectedItem().toString();
        String sourceUnit = spinnerSourceUnit.getSelectedItem().toString();
        String destinationUnit = spinnerDestinationUnit.getSelectedItem().toString();
        double value = Double.parseDouble(editTextValue.getText().toString());

        double result;
        Log.i("BBBBB" , getString(R.string.weight));
        if (conversionType.equals(getString(R.string.length))) {
            result = UnitConverter.convertLength(value, sourceUnit, destinationUnit);

        }

        else if (conversionType.equals(getString(R.string.weight))) {
            result = UnitConverter.convertWeight(value, sourceUnit, destinationUnit);
            Log.i("AAA" , "A");
        } else {
            result = UnitConverter.convertTemperature(value, sourceUnit, destinationUnit);
        }

        textViewResult.setText(String.valueOf(result));
    }
}