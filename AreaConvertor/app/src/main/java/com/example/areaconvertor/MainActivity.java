package com.example.areaconvertor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    String result;
    double input2;
    double calculatedFinalArea;
    double inputEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the input EditText to a variable of class EditText
        EditText editText = (EditText) findViewById(R.id.edit_text);


        // Convert the EditText class to double as we require it to solve calculations.
        inputEditText = Double.parseDouble(editText.getText().toString());
        Log.v("MainActivity", "converted to double");


        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.add("Acre");
        wordsList.add("Ares");
        wordsList.add("Hectare");
        wordsList.add("SquareKiloMeter");
        wordsList.add("SquareMeter");
        wordsList.add("SquareFoot");
        wordsList.add("Cent");

        // Create ArrayAdapter for a String and assign  to a variable
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, wordsList);
        // Assign the dropdown resource to be followed
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // create the spinner variable associated with the View
        Spinner inputSpinner = (Spinner) findViewById(R.id.input_spinner);
        // Let the spinner utilise the created adapter
        inputSpinner.setAdapter(dataAdapter);
        // CreateOnItemSelecteListener to customise work for every item
        inputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String selectedItem = parent.getItemAtPosition(position).toString();
                if (position == 0) {
                    input2 = inputEditText * 4046.86;
                    Log.v("Value acre input2", String.valueOf(input2));

                } else if (position == 1) {
                    input2 = inputEditText * 100;
                } else if (position == 2) {
                    input2 = inputEditText * 10000;
                } else if (position == 3) {
                    input2 = inputEditText * 1000000;
                } else if (position == 4) {
                    input2 = inputEditText;
                } else if (position == 5) {
                    input2 = inputEditText * 0.092903;
                } else if (position == 6) {
                    input2 = inputEditText * 40.47;
                }

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Do the same with the outputAdapter.
        Spinner outputSpinner = (Spinner) findViewById(R.id.output_spinner);
        outputSpinner.setAdapter(dataAdapter);
        outputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        calculatedFinalArea = calculateAcre(input2);
                        Log.v("calculated acre", String.valueOf(input2));
                        break;
                    case 1:
                        calculatedFinalArea = calculateAres(input2);
                        break;
                    case 2:
                        calculatedFinalArea = calculateHectare(input2);
                        break;
                    case 3:
                        calculatedFinalArea = calculateSquarekilometer(input2);
                        break;
                    case 4:
                        calculatedFinalArea = calculateSquaremeter(input2);
                        break;
                    case 5:
                        calculatedFinalArea = calculateSquarefoot(input2);
                        break;
                    case 6:
                        calculatedFinalArea = calculateCent(input2);
                        break;

                }

                result = Double.toString(calculatedFinalArea);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display();
            }
        });
    }

    private void display() {
        TextView outputTextView = (TextView) findViewById(R.id.output_text_view);
        result = Double.toString(calculatedFinalArea);
        outputTextView.setText(result);
    }

    // Following methods Calculates the respective values using input2 as input.
    // THey should be called by the spinner 2.

    private double calculateAcre(double inputAcre) {
        //Assign the global variable unifiedSquaremeter to the local variable to give as input for calc

        // return the converted acre value to the method double
        Log.v("MainActivity", "spinner2 acre");
        return inputAcre / 4046.86;

    }

    private double calculateAres(double inputAres) {
        //Assign the global variable unifiedSquaremeter to the local variable to give as input for calc

        // return the converted ares value to the method double
        Log.v("MainActivity", "spinner2 ares");
        return inputAres / 100;

    }

    private double calculateHectare(double inputHectare) {
        //Assign the global variable unifiedSquaremeter to the local variable to give as input for calc

        // return the converted hectare value to the method double
        Log.v("MainActivity", "spinner2 hectare");
        return inputHectare / 10000;

    }

    private double calculateSquarekilometer(double inputSquareKiloMeter) {
        //Assign the global variable unifiedSquaremeter to the local variable to give as input for calc
        /*this.inputEditText = inputEditText;*/
        // return the converted acre value to the method double
        Log.v("MainActivity", "spinner2 sq k.m");
        return inputSquareKiloMeter / 1000000;

    }

    private double calculateSquaremeter(double inputSquareMeter) {
        //Assign the global variable unifiedSquaremeter to the local variable to give as input for calc
        //       this.inputEditText = inputEditText;
        // return the converted acre value to the method double
        Log.v("MainActivity", "spinner2 sq.m");
        return inputSquareMeter;

    }

    private double calculateSquarefoot(double inputSquareFoot) {
        //Assign the global variable unifiedSquaremeter to the local variable to give as input for calc

        // return the converted acre value to the method double
        Log.v("MainActivity", "spinner2 sq.f");
        return inputSquareFoot / 0.092903;

    }

    private double calculateCent(double inputCent) {
        //Assign the global variable unifiedSquaremeter to the local variable to give as input for calc

        // return the converted acre value to the method double
        Log.v("MainActivity", "spinner2 cent");
        return inputCent / 40.47;

    }

}