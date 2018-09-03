package co.example.takwa.info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView name;
    TextView pass;
    TextView gender;
    TextView countryshow;
    String receiveString, passString, spinnerCity, radiobuttonSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
        initShow();
    }


    private void initView() {
        name = (TextView) findViewById(R.id.ShowNameId);
        pass = (TextView) findViewById(R.id.showPassId);

        gender = (TextView) findViewById(R.id.showgenderId);
        countryshow = (TextView) findViewById(R.id.showCountryId);

    }

    private void initShow() {
        receiveString = getIntent().getExtras().getString("namae");
        name.setText(receiveString);
        passString = getIntent().getExtras().getString("pass");
        pass.setText(passString);
        spinnerCity = getIntent().getExtras().getString("city");
        countryshow.setText(spinnerCity);
        radiobuttonSex = getIntent().getExtras().getString("gen");
        gender.setText(radiobuttonSex);


    }


}
