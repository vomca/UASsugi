package com.sugi.sugiarto.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sugi.sugiarto.EditActivity;
import com.sugi.sugiarto.MainActivity;
import com.sugi.sugiarto.Model.User;
import com.sugi.sugiarto.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    List<User> mUserList;

    public UserAdapter(List <User> userList) {
        mUserList = userList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText("Id = " + mUserList.get(position).getId());
        holder.mTextViewNama1.setText("First Name = " + mUserList.get(position).getNama1());
        holder.mTextViewNama2.setText("Last Name = " + mUserList.get(position).getNama2());
        holder.mTextViewEmail.setText("Last Name = " + mUserList.get(position).getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id", mUserList.get(position).getId());
                mIntent.putExtra("First Name", mUserList.get(position).getNama1());
                mIntent.putExtra("Last Name", mUserList.get(position).getNama2());
                mIntent.putExtra("Email", mUserList.get(position).getEmail());

                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mUserList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama1, mTextViewNama2,mTextViewEmail;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama1 = (TextView) itemView.findViewById(R.id.tvNama1);
            mTextViewNama2 = (TextView) itemView.findViewById(R.id.tvNama2);
            mTextViewEmail = (TextView) itemView.findViewById(R.id.tvEmail);
        }
    }
}
