package com.developer.dinhduy.swipelayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;

import java.util.List;

public class QAadapter extends RecyclerView.Adapter<QAadapter.hoder> {
    List<QA> list;
    Context context;

    public QAadapter(List<QA> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public QAadapter.hoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom,parent,false);

        return new hoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QAadapter.hoder holder, final int position) {
        final QA qa=list.get(position);
        holder.textView.setText(qa.getText());

        holder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener(){
            @Override
            public void onOpen(SwipeLayout layout) {
                super.onOpen(layout);
            }
        });
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delele item
                list.remove(position);
                notifyItemChanged(position);
                notifyItemRangeRemoved(position,list.size());
                // or use
               // notifyItemRangeChanged(position,list.size());

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class hoder extends RecyclerView.ViewHolder{
        private TextView textView;
        private Button button;
        private SwipeLayout swipeLayout;
        public hoder(View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.id_Text);
            button=(Button) itemView.findViewById(R.id.id_btn);
            swipeLayout=(SwipeLayout) itemView.findViewById(R.id.id_swipe);
        }
    }
}
