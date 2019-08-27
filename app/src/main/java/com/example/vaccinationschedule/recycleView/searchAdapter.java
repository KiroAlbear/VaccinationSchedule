package com.example.vaccinationschedule.recycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.vaccinationschedule.Model.ChildEntity;
import com.example.vaccinationschedule.Model.SearchEntity;
import com.example.vaccinationschedule.R;

import java.util.ArrayList;
import java.util.List;

public class searchAdapter extends RecyclerView.Adapter<childViewHolder> {
    private Context context;
    private List<SearchEntity> childList;
    ArrayList<String> colorList = new ArrayList<String>() {
        {

            add("40FF33"); // green
            add("0E7EFF"); // blue
            add("AC0EFF");//purple

        }
    };
    private Integer selector = 0;

    public searchAdapter(Context context, List<SearchEntity> childList) {
        this.context = context;
        this.childList = childList;
    }

    @NonNull
    @Override
    public childViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_rom, parent, false);
        childViewHolder viewHolder = new childViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull childViewHolder holder, int position) {
        String name = childList.get(position).getFirstName();
        String firstLetter = String.valueOf(name.charAt(0)).toUpperCase();
        holder.name.setText(name);
        holder.surname.setText(childList.get(position).getLastName());
        holder.dataOfBirth.setText(childList.get(position).getULevalFormat() );
        holder.letterTextView.setText(firstLetter);

        if (selector == 0){
            holder.letterTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.circle_blue));
            selector++;
        }
        else if (selector == 1){
            holder.letterTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.circle_green));
            selector++;
        }
        else if (selector == 2){
            holder.letterTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.circle_purple));
            selector++;
        }else
            selector = 0;

    }

    @Override
    public int getItemCount() {
        return childList.size();
    }
}
