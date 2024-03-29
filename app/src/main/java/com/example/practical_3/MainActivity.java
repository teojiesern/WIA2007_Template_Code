package com.example.practical_3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practical_3.utils.AlertDialogUtil;

public class MainActivity extends AppCompatActivity {
    private static final String[] BIRTHMONTHS = new String[]{"January", "February", "March", "April", "May"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // region Activity
        Button BtnGoToTemplateActivity = findViewById(R.id.BtnGoToTemplateActivity);
        BtnGoToTemplateActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityTemplate.class);
                // give params to the next activity
                intent.putExtra("username", "teo jie sern");
                intent.putExtra("password", "some secure password");
                startActivity(intent);
                // called to perform onDestroy(), very optional
                finish();
            }
        });

        // region RadioButton
        RadioGroup RGSubscription = findViewById(R.id.RGSubscription);
        RGSubscription.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                String message = "";
                // using switch case will break, known issue after a specific android version
                if (checkedId == R.id.RBMonthly) {
                    message = "Thank you for the monthly subscription. See you next month!";
                } else if (checkedId == R.id.RBAnnually) {
                    message = "Smart choice selecting annual subscription, special 30% discount codes for purchasing other product: DC1030.";
                } else if (checkedId == R.id.RBSkip) {
                    message = "Please come again next time!";
                }
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        // region Spinner
        // The choices you provide for the spinner can come from any source, but you must provide them through a SpinnerAdapter,
        // such as an ArrayAdapter if the choices are available in an array or a CursorAdapter if the choices are available
        // from a database query.
        Spinner planetSpinner = (Spinner) findViewById(R.id.planetSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        planetSpinner.setAdapter(adapter);
        // change the default spinner selection
        planetSpinner.setSelection(2);
        planetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(getApplicationContext(), parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // region autoCompleteTextView
        ArrayAdapter<String> ACTVadapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, BIRTHMONTHS);
        AutoCompleteTextView ACTVBirthMonth = (AutoCompleteTextView) findViewById(R.id.ACTVBirthMonth);
        ACTVBirthMonth.setAdapter(ACTVadapter);

        // region showAlertDialog
        Button BtnFragmentActivity = findViewById(R.id.BtnFragmentActivity);
        BtnFragmentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("main stopping");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("main being destroyed");
    }
}