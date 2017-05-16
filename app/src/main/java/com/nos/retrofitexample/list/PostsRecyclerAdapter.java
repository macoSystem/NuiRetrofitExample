package com.nos.retrofitexample.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nos.retrofitexample.R;
import com.nos.retrofitexample.retrofit.api.jsonplaceholder.model.PostPOJO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saran on 16/5/2560.
 */

public class PostsRecyclerAdapter extends RecyclerView.Adapter<PostsRecyclerAdapter.ViewHolder> {

    private List<PostPOJO> mDatas = new ArrayList<>();

    public PostsRecyclerAdapter() {
    }

    public void replaceDatas(List<PostPOJO> datas) {
        mDatas.clear();
        notifyDataSetChanged();
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_posts, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mDatas.size() > position) {
            holder.bindData(mDatas.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvTitle, tvBody, tvUserId;

        public ViewHolder(View v) {
            super(v);
            findView(v);
        }

        private void findView(View v) {
            tvId = (TextView) v.findViewById(R.id.textview_posts_id);
            tvTitle = (TextView) v.findViewById(R.id.textview_posts_title);
            tvBody = (TextView) v.findViewById(R.id.textview_posts_body);
            tvUserId = (TextView) v.findViewById(R.id.textview_posts_user_id);
        }

        public void bindData(PostPOJO data) {
            if (null != data) {
                tvId.setText("ID : " + data.getId());
                tvTitle.setText(data.getTitle());
                tvBody.setText("Body : " + data.getBody());
                tvUserId.setText("UserId : " + data.getUserId());
            }
        }
    }
}
