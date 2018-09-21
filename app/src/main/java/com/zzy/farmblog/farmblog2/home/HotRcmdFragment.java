package com.zzy.farmblog.farmblog2.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzy.farmblog.farmblog2.R;

/**
 * Created by zhuzhengyi on 2018/9/21.
 */

public class HotRcmdFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hot_rcmd_layout, container, false);
    }
}
