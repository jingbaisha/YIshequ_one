package com.fanwang.demo_doctor_community.custom;

/**
 * Group需要实现的接口
 * 
 * @author 巍
 * 
 */
public interface OnGroupScrollListener {
	/**
	 * 询问Child是否还需要滚动
	 * 
	 * @return
	 */
	 boolean isGroupScroll();

	void onScrollChanged(int left, int top);
}
