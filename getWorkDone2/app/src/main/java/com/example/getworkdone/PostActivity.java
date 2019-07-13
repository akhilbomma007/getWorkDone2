package com.example.getworkdone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostActivity extends AppCompatActivity {

    private String work,pay,deadline,field,college,image;
    private TextView  disp_work,disp_pay,disp_deadline,disp_field,disp_college;
    CircleImageView disp_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        work = getIntent().getExtras().get("work").toString();
        pay = getIntent().getExtras().get("pay").toString();
        deadline = getIntent().getExtras().get("deadline").toString();
        field = getIntent().getExtras().get("field").toString();
        college = getIntent().getExtras().get("college").toString();
        image = getIntent().getExtras().get("image").toString();

        initialize();
        setInfo();

    }

    private void initialize(){
        disp_work = findViewById(R.id.post_work);
        disp_college = findViewById(R.id.post_college);
        disp_field = findViewById(R.id.post_branch);
        disp_deadline = findViewById(R.id.post_deadline);
        disp_pay = findViewById(R.id.post_pay);
        disp_image = findViewById(R.id.postProPic);
    }

    private void setInfo(){
        disp_work.setText(work);
        disp_college.setText(college);
        disp_pay.setText(pay);
        disp_deadline.setText(deadline);
        disp_field.setText(field);
        Picasso.get().load(image).into(disp_image);
    }
}
