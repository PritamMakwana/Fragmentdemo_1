package com.wallpy.fragmentdemo_1.ListTools;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.wallpy.fragmentdemo_1.R;

import java.util.List;

public class MYAdapter extends RecyclerView.Adapter<MYAdapter.ViewHolder> {

    private List<ListData> list;
    private Context mContext;
    private Cursor cursor;
    private String[] form;
    private int[] to;
    private  int i;

    public MYAdapter(List<ListData> list, Context mContext, Cursor cursor, String[] form, int[] to, int i) {
        this.list = list;
        this.mContext = mContext;
        this.cursor = cursor;
        this.form = form;
        this.to = to;
        this.i = i;
    }

    @NonNull
    @Override
    public MYAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itamview=layoutInflater.inflate(R.layout.list_itam,parent,false);
        ViewHolder holder=new ViewHolder(itamview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MYAdapter.ViewHolder holder, int position) {
        final ListData listData=list.get(position);
        holder.name.setText(listData.getName());
        holder.desc.setText(listData.getDesc());
//        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            //    Toast.makeText(mContext," list is ",Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,desc;
        ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_list);
            desc=itemView.findViewById(R.id.desc_list);
            constraintLayout=itemView.findViewById(R.id.list_item1);
        }
    }
}
