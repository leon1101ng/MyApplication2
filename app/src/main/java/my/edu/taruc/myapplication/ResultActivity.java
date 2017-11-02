package my.edu.taruc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView Monthpayment,Status1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //To receive data from another Activity
        Intent intent = getIntent(); //Asking "who called me?"
        double payment = intent.getDoubleExtra(MainActivity.MONTHLY_PAYMENT, 0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);

        //TODO: Display the outputs
        Monthpayment = (TextView)findViewById(R.id.Monthpayment);
        Status1 = (TextView)findViewById(R.id.status);
        Monthpayment.setText(""+payment);
        Status1.setText("" +status);


    }

    public void closeActivity(View view){
        //Terminate the  current activity
        finish();

    }
}
