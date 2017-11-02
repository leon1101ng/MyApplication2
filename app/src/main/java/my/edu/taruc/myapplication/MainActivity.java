package my.edu.taruc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edt1,edt2,edt3,edt4,edt5;

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText)findViewById(R.id.price);
        edt2 = (EditText)findViewById(R.id.downpayment);
        edt3 = (EditText)findViewById(R.id.repayment);
        edt4 = (EditText)findViewById(R.id.interest);
        edt5 = (EditText)findViewById(R.id.salary);
           }

    public void calculateLoan(View view){
        double price = Double.parseDouble(edt1.getText().toString());
        double downpayment = Double.parseDouble(edt2.getText().toString());
        double repayment = Double.parseDouble(edt3.getText().toString());
        double interestrate = Double.parseDouble(edt4.getText().toString());
        double salary = Double.parseDouble(edt5.getText().toString());

        //TODO: Calculate monthly payment and determine the loan status
        double TotalInterest ;
        double TotalLoan ;
        double monthlyPayment =0;
        String status = "Approved";
        TotalInterest = (price - downpayment) * (interestrate/100) * (repayment/12);
        TotalLoan = (price - downpayment) + TotalInterest;
        monthlyPayment = TotalLoan/repayment;
        if (monthlyPayment > (0.3*salary)){
            status = "Reject";

        }
       //Create an Explicit intent
        Intent intent = new Intent(this, ResultActivity.class);
        //TODO : passing data using putExtra method
        //format : putExtra(TAG, value)
        intent.putExtra(MONTHLY_PAYMENT, monthlyPayment);
        intent.putExtra(LOAN_STATUS, status);
        startActivity(intent);
    }
}
