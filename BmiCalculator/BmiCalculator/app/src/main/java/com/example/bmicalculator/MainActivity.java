package com.example.bmicalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.GetChars;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    View Main;
    Switch DarkMode_SW;
    TextView Ghad_LBL, Vazn_LBL, AppName_LBL;
    EditText Ghad_TXT, Vazn_TXT;
    Button Sum_BTN;
    String BmiStatus , Dark = "True";
    double BmiResult , Vazn;
    int Ghad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        Toast.makeText(this , "~ Developed by AGC007 ~" , Toast.LENGTH_LONG).show();

        //------ Var Set ------//

        Main = findViewById(R.id.main);
        DarkMode_SW = findViewById(R.id.DarkMode_SW);
        Ghad_LBL = findViewById(R.id.Ghad_LBL);
        Vazn_LBL = findViewById(R.id.Vazn_LBL);
        AppName_LBL = findViewById(R.id.AppName_LBL);
        Ghad_TXT = findViewById(R.id.Ghad_TXT);
        Vazn_TXT = findViewById(R.id.Vazn_TXT);
        Sum_BTN = findViewById(R.id.Sum_BTN);

        //------ Var Set ------//

        //------- Dark and light (on-off) -------//

        DarkMode_SW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DarkMode_SW.isChecked())
                {
                    Dark = "True";
                    DarkMode_SW.setText("Dark Mode");
                    Main.setBackgroundColor(Color.parseColor("#222831"));
                    Ghad_LBL.setTextColor(Color.parseColor("#00ADB5"));
                    Vazn_LBL.setTextColor(Color.parseColor("#00ADB5"));
                    AppName_LBL.setTextColor(Color.parseColor("#00ADB5"));
                    Ghad_TXT.setTextColor(Color.parseColor("#EEEEEE"));
                    Vazn_TXT.setTextColor(Color.parseColor("#EEEEEE"));
                    Sum_BTN.setBackgroundColor(Color.parseColor("#00ADB5"));
                }
                else {
                    Dark = "False";
                    DarkMode_SW.setText("Light Mode");
                    DarkMode_SW.setTextColor(Color.parseColor("#408080"));
                    Main.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Ghad_LBL.setTextColor(Color.parseColor("#408080"));;
                    Vazn_LBL.setTextColor(Color.parseColor("#408080"));
                    AppName_LBL.setTextColor(Color.parseColor("#408080"));
                    Ghad_TXT.setTextColor(Color.parseColor("#222831"));
                    Vazn_TXT.setTextColor(Color.parseColor("#222831"));
                    Sum_BTN.setBackgroundColor(Color.parseColor("#408080"));
                }
            }
        });

        //------- Dark and light (on-off) -------//

        //------- Sum App (BTN_Click)  -------//

        Sum_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!Vazn_TXT.getText().toString().equals("") && !Vazn_TXT.getText().toString().equals(""))
                {
                    Vazn = Double.parseDouble(String.valueOf(Vazn_TXT.getText()));
                    Ghad = Integer.parseInt(String.valueOf(Ghad_TXT.getText()));

                BmiResult = Vazn / (Ghad * Ghad);

                if (BmiResult < 0.00185 ){
                    BmiStatus = "کمبود وزن";
                }
                else if(BmiResult > 0.00185 && BmiResult <= 0.0025){
                    BmiStatus = "وزن سلامت" ;
                }
                else if(BmiResult > 0.0025 && BmiResult <= 0.0030){
                    BmiStatus = "اضافه وزن";
                }
                else if(BmiResult > 0.0030 && BmiResult <= 0.0035){
                    BmiStatus = "چاق ( درجه یک )";
                }
                else if(BmiResult > 0.0035 && BmiResult <= 0.0040){
                    BmiStatus = "چاق ( درجه دو )";
                }
                else if( BmiResult > 0.0040){
                    BmiStatus = "چاق ( مرگبار )";
                }

                String BmiResultSub1 = String.valueOf(BmiResult).substring(4, 6);
                String BmiResultSub2 = String.valueOf(BmiResult).substring(6, 7);
                String BmiResultSub = BmiResultSub1 + "," + BmiResultSub2;

                //------- SendData  -------//

                String[] DataList = {String.valueOf(Vazn), String.valueOf(Ghad) , BmiResultSub , BmiStatus , Dark};
                Intent SendToNext = new Intent(MainActivity.this , activity_next.class);
                SendToNext.putExtra("Data" ,DataList);
                startActivity(SendToNext);

                //------- SendData  -------//
                }
                else {
                    Toast.makeText(MainActivity.this , "لطفا مقادیر را وارد کنید." , Toast.LENGTH_LONG).show();
                }
            }


        });

        //------- Sum App (BTN_Click)  -------//

    }
}



