package com.fanwang.demo_doctor_community.commonality;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * 顶部停留的listview 结合hoverLayout一起使用
 * 
 * @author 巍
 * 
 */
public class SideTopListView extends ListView {

	private OnChildScrollListener mAction;

	public SideTopListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		return mAction != null && mAction.isChildScroll() && super.onTouchEvent(ev);
	}

	public void setOnChildScrollListener(OnChildScrollListener action) {
		this.mAction = action;
	}

	/**
	 * 判断是否滑动到了第一条数据
	 */
	public boolean isChildScrollToEnd() {
		if (getFirstVisiblePosition() == 0) {
			View view = getChildAt(0);
			if (view != null) {
				return view.getTop() == getPaddingTop();
			} else {
				return true;
			}
		}
		return false;
	}
	
	

}
