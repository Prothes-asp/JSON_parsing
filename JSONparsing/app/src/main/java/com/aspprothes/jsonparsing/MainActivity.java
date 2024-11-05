package com.aspprothes.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.mursaat.extendedtextview.AnimatedGradientTextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText firstName,lastName,eMails,phnNo,nidNo,passwords;
    private AppCompatButton btn,btnreset;
    private LottieAnimationView animationView;
    private AnimatedGradientTextView title;
    private String url = "https://prothes-asp.github.io/JSON_parsing/j1.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.sky));
        this.getWindow().setNavigationBarColor(getResources().getColor(R.color.sky));
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        eMails = findViewById(R.id.eMails);
        phnNo = findViewById(R.id.phnNo);
        nidNo = findViewById(R.id.nidNo);
        passwords = findViewById(R.id.passwords);
        btn = findViewById(R.id.btn);
        btnreset = findViewById(R.id.btnreset);
        animationView = findViewById(R.id.animationView);
        title = findViewById(R.id.title);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationView.setVisibility(View.VISIBLE);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            title.setText("JSON Parsing");
                            animationView.setVisibility(View.GONE);
                            JSONObject jsonObject = new JSONObject(response);
                            String fname = jsonObject.getString("fname");
                            String lname = jsonObject.getString("lname");
                            String email = jsonObject.getString("email");
                            String phn = jsonObject.getString("phn");
                            String id = jsonObject.getString("id");
                            String password = jsonObject.getString("password");

                            Integer phn_no = Integer.parseInt(phn);
                            Integer nid_no = Integer.parseInt(id);

                            firstName.setText(""+fname);
                            lastName.setText(""+lname);
                            eMails.setText(""+email);
                            phnNo.setText(""+phn_no);
                            nidNo.setText(""+nid_no);
                            passwords.setText(""+password);

                            btn.setVisibility(View.GONE);
                            btnreset.setVisibility(View.VISIBLE);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        animationView.setVisibility(View.GONE);
                    }
                });

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(stringRequest);

            }
        });



        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("JSON Clear");
                firstName.setText(null);
                lastName.setText(null);
                eMails.setText(null);
                phnNo.setText(null);
                nidNo.setText(null);
                passwords.setText(null);
                btn.setVisibility(View.VISIBLE);
                btnreset.setVisibility(View.GONE);
            }
        });

    }
}