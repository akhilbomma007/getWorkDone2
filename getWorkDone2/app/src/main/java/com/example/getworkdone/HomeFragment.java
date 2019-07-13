package com.example.getworkdone;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Global");
        databaseReference.keepSynced(true);

        //recycler view
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        //set its properties
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(databaseReference,Model.class)
                        .build();

        FirebaseRecyclerAdapter<Model,MyHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, MyHolder>
                (options)  {
            @Override
            protected void onBindViewHolder(@NonNull MyHolder holder, int position, @NonNull Model model) {
                Picasso.get().load(model.getImage()).into(holder.profilepic);
                holder.post_work.setText(model.getWork());
                holder.post_pay.setText(model.getPay());
                holder.post_field.setText(model.getField());
                holder.post_deadline.setText(model.getDeadline());
                holder.post_college.setText(model.getCollege());
            }

            @NonNull
            @Override
            public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model,viewGroup,false);
                MyHolder myHolder = new MyHolder(view);
                return myHolder;
            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();

    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        CircleImageView profilepic;
        TextView post_work,post_college,post_field,post_pay,post_deadline;
        public MyHolder(View itemView){
            super(itemView);
            post_work = itemView.findViewById(R.id.work);
            post_college = itemView.findViewById(R.id.college);
            post_field = itemView.findViewById(R.id.field);
            post_pay = itemView.findViewById(R.id.pay);
            post_deadline = itemView.findViewById(R.id.deadline);
            profilepic = itemView.findViewById(R.id.profilepic);

        }

    }

}
