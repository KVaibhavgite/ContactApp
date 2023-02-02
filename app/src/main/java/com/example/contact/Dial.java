package com.example.contact;



import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.Manifest;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Dial extends Fragment {

    EditText newNumber;
    FloatingActionButton calldial;
    static  int Permission_CODE=100;

    String number;



    public Dial() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dial, container, false);


        newNumber = view.findViewById(R.id.editTextPhone);
        calldial = view.findViewById(R.id.floatingActionButton);

        if(ContextCompat.checkSelfPermission(requireActivity(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(requireActivity(),new String[]{android.Manifest.permission.CALL_PHONE}, Permission_CODE);
        }

        calldial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = newNumber.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+number));

                startActivity(intent);
            }
        });



        return view;
    }
}