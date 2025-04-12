package com.example.ticketvault;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double costPerTicket = 89.99;
    int numTickets;
    double totalCost;
    String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final EditText tickets = (EditText) findViewById(R.id.tvTickets);
        final Spinner group = (Spinner) findViewById(R.id.spGroup);
        Button cost = (Button) findViewById(R.id.btCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView) findViewById(R.id.tvResult));
            @Override
            public void onClick(View view) {
                numTickets = Integer.parseInt(tickets.getText().toString());
                totalCost = numTickets * costPerTicket;
                DecimalFormat currency = new DecimalFormat("R###,###.##");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Cost for " + numTickets + " tickets to see " + groupChoice + " is " + currency.format(totalCost));
            }
        });
    }
}