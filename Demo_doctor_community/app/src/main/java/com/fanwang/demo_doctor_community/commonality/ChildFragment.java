package com.fanwang.demo_doctor_community.commonality;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.fanwang.demo_doctor_community.R;

//import com.google.gson.Gson;
//import com.lidroid.xutils.BitmapUtils;
//import com.lidroid.xutils.http.RequestParams;
//import com.work.day.R;
//import com.work.day.httphelp.BitmapHelp;
//import com.work.day.httphelp.GsonHelp;
//import com.work.day.httphelp.HttpHelp;


public abstract class ChildFragment extends Fragment implements View.OnClickListener{

	public Context context;
	public Resources resources;
	public Intent intent;
	public View view;
	public Boolean isShow=true;
//	public RequestParams params;
//	public Gson gson;
//	public BitmapUtils bitmapUtils;
//	public HttpHelp httpHelp;
	public String message=null;
	public String Time;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context=getActivity();
		resources=getActivity().getResources();
		//获取网络工具类
//		params=new RequestParams();
//		gson= GsonHelp.newInstance();
//		httpHelp =new HttpHelp(getActivity());
//		bitmapUtils= BitmapHelp.newInstance(context);
	}


	/**
	 * 功能说明:初始化组件
	 *
	 * @author 作者：jarvisT
	 * @date 创建日期：2015-1-22 下午11:59:03
	 */
	public abstract void initView(View view);

	/**
	 * 功能说明:为各个组件设置数据
	 *
	 * @author 作者：jarvisT
	 * @date 创建日期：2015-1-22 下午11:59:03
	 */
	public abstract void setData();

	/**
	 * 功能说明:请求网络数据
	 *
	 * @param isShow 是否显示正在加载的弹窗
	 * @author 作者：jarvisT
	 * @date 创建日期：2015-1-22 下午11:59:03
	 */
	public abstract void requestData(boolean isShow);


	/**
	 * 
	 * 功能说明：加入titlefragment到布局中
	 * </p>作者：ts
	 * 创建日期:2014-10-13
	 * 参数：
	 * @param fragment   需要加入的fragment
	 */
	final public void addTitleFragment(Fragment fragment) {
		FragmentTransaction ft = this.getChildFragmentManager().beginTransaction();
		ft.replace(R.id.title_fragment_content, fragment);
		ft.commitAllowingStateLoss();
	}

	/**
	 * 功能说明：加入某个fragment到布局中 
	 * </p>作者：ts 创建日期:2014-10-13 参数：
	 * 
	 * @param fragment
	 *            需要加入的fragment
	 * @param view_id
	 *            加入的控件id
	 */
	final public void addFragment(Fragment fragment, int view_id) {
		FragmentTransaction ft = this.getChildFragmentManager().beginTransaction();
		ft.add(view_id, fragment);
		ft.commitAllowingStateLoss();
	}

	/**
	 * 
	 * 功能说明：加入某个fragment到布局中
	 * </p>作者：ts
	 * 创建日期:2014-10-13
	 * 参数：
	 * @param fragment   需要加入的fragment
	 * @param view_id    加入的控件id
	 */
	final public void addReplaceFragment(Fragment fragment, int view_id) {
		FragmentTransaction ft = this.getChildFragmentManager().beginTransaction();
		ft.replace(view_id, fragment);
		ft.commitAllowingStateLoss();
	}

	/**
	 * 
	 * 功能说明：显示添加的fragment 
	 * </p>作者：ts 创建日期:2014-10-13 参数：
	 * @param fragment
	 * 需要显示的fragment
	 */
	abstract public void showFragment(Fragment fragment);

	/**
	 * 
	 * 功能说明：删除某一个fragment 
	 * </p>作者：ts 创建日期:2014-10-13 参数：
	 * @param fragment
	 *            传递需要被删除的fragment
	 */
	final public void removeFragment(Fragment fragment) {
		FragmentTransaction ft = this.getChildFragmentManager().beginTransaction();
		ft.remove(fragment);
		ft.commitAllowingStateLoss();
	}


}
