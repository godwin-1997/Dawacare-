package com.dawacare.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    LinearLayout mainLayout;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showLogin();
    }

    private TextView title(String text, int size) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextSize(size);
        t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        t.setGravity(Gravity.CENTER);
        t.setPadding(10, 20, 10, 20);
        return t;
    }

    private void showLogin() {

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER);
        mainLayout.setPadding(35, 30, 35, 30);

        TextView logo = title("DawaCare", 32);
        mainLayout.addView(logo);

        TextView subtitle = title(
                "Pharmacy Stock & Sales Management",
                16
        );
        mainLayout.addView(subtitle);

        username = new EditText(this);
        username.setHint("Username");
        mainLayout.addView(username);

        password = new EditText(this);
        password.setHint("Password");
        password.setInputType(129);
        mainLayout.addView(password);

        Button login = new Button(this);
        login.setText("LOGIN");

        mainLayout.addView(login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (user.equals("admin") && pass.equals("1234")) {
                    showDashboard("ADMIN");
                }
                else if (user.equals("staff") && pass.equals("1234")) {
                    showDashboard("STAFF");
                }
                else {
                    Toast.makeText(
                            MainActivity.this,
                            "Username au password sio sahihi",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

        setContentView(mainLayout);
    }

    private void showDashboard(String role) {

        mainLayout.removeAllViews();

        TextView header = title("DAWACARE", 28);
        mainLayout.addView(header);

        TextView welcome = title(
                "Dashboard - " + role,
                20
        );
        mainLayout.addView(welcome);

        Button sales = new Button(this);
        sales.setText("MAUZO");
        mainLayout.addView(sales);

        if (role.equals("ADMIN")) {

            Button stock = new Button(this);
            stock.setText("DAWA & STOCK");
            mainLayout.addView(stock);

            Button staff = new Button(this);
            staff.setText("WAFANYAKAZI");
            mainLayout.addView(staff);

            Button reports = new Button(this);
            reports.setText("RIPOTI");
            mainLayout.addView(reports);

            Button stockTaking = new Button(this);
            stockTaking.setText("STOCK TAKING");
            mainLayout.addView(stockTaking);
        }

        Button logout = new Button(this);
        logout.setText("LOG OUT");
        mainLayout.addView(logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogin();
            }
        });
    }
}
