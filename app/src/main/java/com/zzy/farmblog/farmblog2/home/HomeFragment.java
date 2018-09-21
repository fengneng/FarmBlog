package com.zzy.farmblog.farmblog2.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.zzy.farmblog.farmblog2.MessageActivity;
import com.zzy.farmblog.farmblog2.R;

/**
 * Created by zhuzhengyi on 2018/9/20.
 */

public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private String titles[]={"热门", "版块"};   //模拟的数据

    private TabLayout tabLayout;

    private ImageButton messageBtn;


    private HotRcmdFragment hotRcmdFragment;
    private ChannelFragment channelFragment;
    private Fragment[] fragments;


    private HomeAdapter homeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_layout, container, false);


        //初始化
        viewPager = (ViewPager) view.findViewById(R.id.home_viewpager);



        tabLayout = (TabLayout)view.findViewById(R.id.home_tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        messageBtn = (ImageButton)view.findViewById(R.id.message_btn);
        messageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);

            }
        });


        //左滑

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.home_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        hotRcmdFragment = new HotRcmdFragment();
        channelFragment = new ChannelFragment();
        fragments = new Fragment[]{hotRcmdFragment, channelFragment};
        homeAdapter = new HomeAdapter(getChildFragmentManager());

        viewPager.setAdapter(homeAdapter);

        return view;
    }

    private class HomeAdapter extends FragmentPagerAdapter {
        public HomeAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
