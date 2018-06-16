package com.fanwang.demo_doctor_community.dialog;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.custom.MenuItem;
import com.fanwang.demo_doctor_community.custom.TopRightMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edison on 2018/6/15.
 */

public class Dialog_xuanze {
    private TopRightMenu mTopRightMenu;

    public void ShowDialog(RelativeLayout layout, Activity activity) {
        mTopRightMenu = new TopRightMenu(activity);
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(R.mipmap.ic_launcher, "我的医生"));
        menuItems.add(new MenuItem(R.mipmap.ic_launcher, "按科室"));
        menuItems.add(new MenuItem(R.mipmap.ic_launcher, "搜医院"));
        mTopRightMenu
                .setHeight(380)     //默认高度480
                .setWidth(320)      //默认宽度wrap_content
                .showIcon(false)     //显示菜单图标，默认为true
                .dimBackground(true)           //背景变暗，默认为true
                .needAnimationStyle(true)   //显示动画，默认为true
                .setAnimationStyle(R.style.TRM_ANIM_STYLE)  //默认为R.style.TRM_ANIM_STYLE
                .addMenuList(menuItems)
                .setOnMenuItemClickListener(new TopRightMenu.OnMenuItemClickListener() {
                    @Override
                    public void onMenuItemClick(int position) {

                    }
                })
                .showAsDropDown(layout, -225, 0);
    }
}
