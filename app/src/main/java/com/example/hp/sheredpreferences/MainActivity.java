package com.example.hp.sheredpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
    private CheckBox C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPref= getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        final EditText login=(EditText)findViewById(R.id.login);
        final EditText mdp=(EditText)findViewById(R.id.Mdp);
        Button submit=(Button)findViewById(R.id.submit);
        C=(CheckBox)findViewById(R.id.Remember_my_login_info);



        login.setText(sharedPref.getString("data_login",""));
        mdp.setText(sharedPref.getString("data_mdp",""));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor myEdit = sharedPref.edit();
                if(C.isChecked()) {
                    myEdit.putString("data_login", login.getText().toString());
                    myEdit.putString("data_mdp", mdp.getText().toString());
                    myEdit.commit();

                }else{

                    myEdit.putString("data_login", "");
                    myEdit.putString("data_mdp", "");
                    myEdit.commit();

                }

            }
        });


    }


}
