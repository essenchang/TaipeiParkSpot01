package com.fishbowl.taipeiparkspot;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by essenchang on 2017/1/21.
 */

public class ParkSpotAdapter extends BaseAdapter {

    private static final String TAG = ParkSpotAdapter.class.getSimpleName();
    private Context context;
    private List<ParkSpotItemDTO> parkSpotItems;

    public ParkSpotAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ParkSpotItemDTO> items) {
        parkSpotItems = items;
        notifyDataSetChanged();
    }

    @NonNull
    private List<ParkSpotItemDTO> getItems() {
        if (parkSpotItems == null) {
            parkSpotItems = new ArrayList<>();
        }
        return parkSpotItems;
    }

    @Override
    public int getCount() {
        return getItems().size();
    }

    @Override
    public Object getItem(int position) {
        if (position < 0 || position + 1 > getCount()) {
            Log.e(TAG, "Can't get item " + position + ", items size is " + getCount());
            return null;
        }

        return getItems().get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.parkspot_item_view, null);
            holder = new ViewHolder(context, convertView);
            convertView.setTag(holder);
        }

        ParkSpotItemDTO data = (ParkSpotItemDTO) getItem(position);
        if (data == null) {
            return convertView;
        }

        // use viewHolder.
        holder = (ViewHolder) convertView.getTag();
        holder.setData(data);

        /*
        // didn't use viewHolder and butterknife.
        TextView txtParkName = (TextView) convertView.findViewById(R.id.tv_parkname);
        if (txtParkName != null) {
            txtParkName.setText(data.ParkName);
        }

        TextView txtSpotName = (TextView) convertView.findViewById(R.id.tv_spotname);
        if (txtSpotName != null) {
            txtSpotName.setText(data.Name);
        }

        ImageView ivImg = (ImageView) convertView.findViewById(R.id.iv_Img);
        if (ivImg != null) {
            Glide.with(context)
                    .load(data.Image)
                    .fitCenter()
                    .placeholder(R.drawable.download)
                    .crossFade()
                    .into(ivImg);
        }
        */


        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_parkname)
        TextView parkName;
        @BindView(R.id.tv_spotname)
        TextView spotName;
        @BindView(R.id.iv_Img)
        ImageView img;
        Context context;

        public ViewHolder(Context context, View view) {
            this.context = context;
            ButterKnife.bind(this, view);
        }

        public void setData(ParkSpotItemDTO data) {
            parkName.setText(data.ParkName);
            spotName.setText(data.Name);
            Glide.with(context)
                    .load(data.Image)
                    .fitCenter()
                    .placeholder(R.drawable.download)
                    .crossFade()
                    .into(img);
        }
    }
}
