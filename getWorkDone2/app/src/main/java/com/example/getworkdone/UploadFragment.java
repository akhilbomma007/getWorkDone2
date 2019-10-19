package com.example.getworkdone;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class UploadFragment extends Fragment {


    EditText u_college,u_deadline,u_field,u_pay,u_work;
    Button upload_btn;
    FirebaseDatabase database;
    DatabaseReference ref;
    Model user;

    public UploadFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_upload, container, false);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Global");

        u_college =  view.findViewById(R.id.U_college);
        u_deadline = view.findViewById(R.id.U_deadline);
        u_field = view.findViewById(R.id.U_field);
        u_pay = view.findViewById(R.id.U_pay);
        u_work = view.findViewById(R.id.U_work);
        upload_btn = view.findViewById(R.id.upload_btn);

        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(u_college.length()==0){
                    u_college.setError("Enter college");
                }
                else if(u_deadline.length()==0){
                    u_deadline.setError("Enter Deadline");
                }
                else if(u_field.length()==0){
                    u_field.setError("Enter Field");
                }
                else if(u_pay.length()==0){
                    u_pay.setError("Enter Pay");
                }
                else if(u_work.length()==0){
                    u_work.setError("Enter Work");
                }
                else{
                    addWork();
                    u_college.getText().clear();
                    u_deadline.getText().clear();
                    u_field.getText().clear();
                    u_pay.getText().clear();
                    u_work.getText().clear();
                }
            }
        });

        return view;
    }

    private void addWork() {
        user = new Model();
        getValues();
        String id = ref.push().getKey();
        ref.child(id).setValue(user);
        Toast.makeText(getActivity(),"work uploaded",Toast.LENGTH_SHORT).show();
    }

    private void getValues(){
        user.setCollege(u_college.getText().toString());
        user.setDeadline(u_deadline.getText().toString());
        user.setImage("https://upload.wikimedia.org/wikipedia/en/4/47/VNRVJIETLogo.png");
        user.setField(u_field.getText().toString());
        user.setPay(u_pay.getText().toString());
        user.setWork(u_work.getText().toString());
    }
}
