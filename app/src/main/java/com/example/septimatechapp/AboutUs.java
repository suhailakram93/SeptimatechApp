package com.example.septimatechapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AboutUs extends basicMenu {


    TextView edtxt;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus_main);

        edtxt=findViewById(R.id.editText);
        button=findViewById(R.id.buttonL);

        edtxt.setText("Customers count on Septimatech to improve changeover efficiency and make " +
                "their  packaging lines and machines more productive. "+
                "\n" +
                "Our solutions help to simplify operations and improve ergonomics. By increasing" +
                " precision, accuracy, and repeatability, we remove " +
                "obstacles to optimum performance and replace them with faster, intuitive solutions and processes.\n" +
                "\n" +
                "Our business philosophy is simple: deliver the best possible customized solutions for each and every one of our clients. " +
                "With experience working on over 300 different types of packaging machines and lines, we are experts at overcoming the challenges " +
                "associated with maximizing changeover and container handling.\n" +
                "\n" +
                "We save our Customers time and money every day with:\n" +
                "\n" +
                "    Faster changeovers\n" +
                "    Repeatable changeover performance\n" +
                "    Higher SKU throughput\n" +
                "    Efficient use of skilled labour\n" +
                "    Increased machine and line uptime\n" +
                "    Improved container handling\n" +
                "\n" +
                "In a time-sensitive world where any change can threaten production, our Customers enjoy vastly improved performance for reliable, predictable results and value");
        String[] para=edtxt.getText().toString().split("\r\n\r\n");
        edtxt.setMovementMethod(new ScrollingMovementMethod());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent septi =new Intent(Intent.ACTION_VIEW, Uri.parse("https://septimatech.com/about/why-septimatech/"));
                startActivity(septi);
            }
        });

    }
}