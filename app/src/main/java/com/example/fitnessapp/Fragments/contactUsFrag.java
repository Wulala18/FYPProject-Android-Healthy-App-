package com.example.fitnessapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fitnessapp.R;


public class contactUsFrag extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

        EditText mEditTextTo;
        EditText mEditTextSubject;
        EditText mEditTextMessage;

        mEditTextTo = view.findViewById(R.id.edit_text_to);
        mEditTextSubject = view.findViewById(R.id.edit_text_subject);
        mEditTextMessage = view.findViewById(R.id.edit_text_message);

        Button buttonSend = view.findViewById(R.id.button_send);
        buttonSend.setOnClickListener(v -> {

                String recipientList = mEditTextTo.getText().toString();
                String[] recipients = recipientList.split(",");
                String subject = mEditTextSubject.getText().toString();
                String message = mEditTextMessage.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                //to forward the data to others activity(Email)
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent, "Choose an email client"));




        });

        return view;
    }



}