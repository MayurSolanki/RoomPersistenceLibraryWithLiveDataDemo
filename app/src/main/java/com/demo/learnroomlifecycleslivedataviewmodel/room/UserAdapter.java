package com.demo.learnroomlifecycleslivedataviewmodel.room;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.learnroomlifecycleslivedataviewmodel.R;

import java.util.List;

/**
 * Created by gonzalo on 7/14/17
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ProductViewHolder> {

    private final List<UserDetail> list;

    public UserAdapter(List<UserDetail> list) {
        this.list = list;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public UserDetail getUserDetail(int position){


        return  list.get(position);
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {


        private TextView tvUserName;

        public ProductViewHolder(View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tv_user_name);
        }

        public void bind(UserDetail userDetail) {
            tvUserName.setText(userDetail.getUserName());

        }
    }
}
