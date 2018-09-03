package co.example.takwa.info;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button button;
    Spinner spinner;
    String input, inputpass, inputSpinner, countryRadio;
    RadioGroup radioGroup;
    RadioButton radioButton;


    String ab;


    String[] country = {"Bangladesh", "Japan", "Korea", "China"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editTextId);

        editText2 = (EditText) findViewById(R.id.editPassId);
        spinner = findViewById(R.id.spinnerId);
        button = (Button) findViewById(R.id.buttonId);
        radioGroup = findViewById(R.id.radioGroup);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });


        ArrayAdapter arrayAdapter = (new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, country));
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputSpinner = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void openActivity2() {

        Intent intent = new Intent(this, Main2Activity.class);

        int id = radioGroup.getCheckedRadioButtonId();
        if (id == -1) {
            Toast.makeText(this, "Please select a country", Toast.LENGTH_SHORT).show();
        } else {
            radioButton = findViewById(id);
            countryRadio = radioButton.getText().toString();

        }
        input = editText1.getText().toString();
        inputpass = editText2.getText().toString();

        intent.putExtra("namae", input);
        intent.putExtra("pass", inputpass);
        intent.putExtra("city", inputSpinner);
        intent.putExtra("gen", countryRadio);

        startActivity(intent);
        finish();
    }


}


