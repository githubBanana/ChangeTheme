package com.xs.changetheme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-07-14 16:05
 * @email Xs.lin@foxmail.com
 */
public class ColorListAdapter extends BaseAdapter {
    private static final String TAG = "ColorListAdapter";

    private List<Integer> mList;
    private Context mContext;

    public ColorListAdapter(Context context) {
        this.mContext = context;
        mList = new ArrayList<>();
    }

    public boolean addAll(Collection<Integer> collection) {
        mList.clear();
        if (mList.addAll(collection)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder mVh = null;
        if (view == null) {
            mVh = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_color_layout,null);
            mVh.mIvColor = (ImageView) view.findViewById(R.id.iv_color);
            mVh.mIvDone = (ImageView) view.findViewById(R.id.iv_done);
            view.setTag(mVh);
        } else {
            mVh = (ViewHolder) view.getTag();
        }

        mVh.mIvColor.setImageResource(mList.get(i));
        mVh.mIvDone.setVisibility(View.INVISIBLE);

        return view;
    }

    class ViewHolder {
        ImageView mIvColor;
        ImageView mIvDone;
    }
}
