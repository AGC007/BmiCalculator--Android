package com.example.bmicalculator;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_next extends AppCompatActivity {

    Button Share_BTN;
    TextView Ghad_Result_LBL, Vazn_Result_LBL, BMI_Result_LBL , Status_Result_LBL , l1 ,l2 , l3 ,l4 ,l5;
    View MainNext;
    String ShareData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_next_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //------ Var Set ------//

        MainNext = findViewById(R.id.main2);
        Ghad_Result_LBL = findViewById(R.id.Ghad_Result_LBL);
        Vazn_Result_LBL = findViewById(R.id.Vazn_Result_LBL);
        BMI_Result_LBL = findViewById(R.id.BMI_Result_LBL);
        Status_Result_LBL = findViewById(R.id.Status_Result_LBL);
        Share_BTN = findViewById(R.id.Share_BTN);
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);

        //------ Var Set ------//

        //------- DataExport -------//

        String[] GetData =  getIntent().getStringArrayExtra("Data");
        String Vazn = GetData[0];
        String Ghad = GetData[1];
        String BmiResult = GetData[2];
        String BmiStatus = GetData[3];

        Vazn_Result_LBL.setText(Vazn);
        Ghad_Result_LBL.setText(Ghad);
        BMI_Result_LBL.setText(BmiResult);
        Status_Result_LBL.setText(BmiStatus);

        ShareData = "قد : " + Ghad + "\n" +
                "وزن : " + Vazn + "\n" +
                "شاخص : " + BmiResult + "\n" +
                "وضیعت : " + BmiStatus;

        //Toast.makeText(MainNext.getContext(), ShareData , Toast.LENGTH_LONG).show();

        //------- DataExport -------//

        //----- Dark Mode CR -----//

        String Dark = GetData[4];

        if(Dark.equals("True"))
        {
            MainNext.setBackgroundColor(Color.parseColor("#222831"));
            Share_BTN.setBackgroundColor(Color.parseColor("#00ADB5"));
            l1.setTextColor(Color.parseColor("#00ADB5"));
            l2.setTextColor(Color.parseColor("#00ADB5"));
            l3.setTextColor(Color.parseColor("#00ADB5"));
            l4.setTextColor(Color.parseColor("#00ADB5"));
            l5.setTextColor(Color.parseColor("#00ADB5"));
            Ghad_Result_LBL.setTextColor(Color.parseColor("#EEEEEE"));
            Vazn_Result_LBL.setTextColor(Color.parseColor("#EEEEEE"));
            BMI_Result_LBL.setTextColor(Color.parseColor("#EEEEEE"));
            Status_Result_LBL.setTextColor(Color.parseColor("#EEEEEE"));
        }
        if(Dark.equals("False"))
        {
            MainNext.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Share_BTN.setBackgroundColor(Color.parseColor("#408080"));
            l1.setTextColor(Color.parseColor("#408080"));
            l2.setTextColor(Color.parseColor("#408080"));
            l3.setTextColor(Color.parseColor("#408080"));
            l4.setTextColor(Color.parseColor("#408080"));
            l5.setTextColor(Color.parseColor("#408080"));
            Ghad_Result_LBL.setTextColor(Color.parseColor("#222831"));
            Vazn_Result_LBL.setTextColor(Color.parseColor("#222831"));
            BMI_Result_LBL.setTextColor(Color.parseColor("#222831"));
            Status_Result_LBL.setTextColor(Color.parseColor("#222831"));

        }

        //----- Dark Mode CR -----//

        //----- Share BTN CLICK -----//

        Share_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, ShareData);
                startActivity(Intent.createChooser(intent, "در حال اشترک گذاری..."));
            }
        });

        //----- Share BTN CLICK -----//

    }
}