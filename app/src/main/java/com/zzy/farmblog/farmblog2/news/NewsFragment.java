package com.zzy.farmblog.farmblog2.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzy.farmblog.farmblog2.MainActivity;
import com.zzy.farmblog.farmblog2.R;

/**
 * Created by zhuzhengyi on 2018/9/20.
 */

public class NewsFragment extends Fragment {

    private ViewPager viewPager;
    private String datas[]={"关注", "图片"};   //模拟的数据

    private TabLayout tabLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.news_layout, container, false);


        //初始化
        viewPager = (ViewPager) view.findViewById(R.id.news_viewpager);

        //给viewpager设置适配器
        viewPager.setAdapter(new VpAdapter());

        tabLayout = (TabLayout)view.findViewById(R.id.news_tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }


    /**
     * viewPager的PagerAdapter适配器
     */
    private class VpAdapter extends PagerAdapter {
        /**
         * 返回viewpager要显示几页
         */
        @Override
        public int getCount() {
            return datas.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return datas[position];
        }

        /**
         * 该函数用来判断instantiateItem(ViewGroup, int)
         * 函数所返回来的Key与一个页面视图是否是代表的同一个视图(即它俩是否是对应的，对应的表示同一个View)
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            //几乎是固定的写法,
            return view==object;
        }

        /**
         * 返回要显示的view,即要显示的视图
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_vp,null);
            //在这里可以做相应的操作
            TextView tv= (TextView) view.findViewById(R.id.tv);
            //数据填充
            tv.setText(datas[position]);

            container.addView(view);    //这一步很重要
            return view;
        }

        /**
         * 销毁条目
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
