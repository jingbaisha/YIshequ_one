package com.fanwang.demo_doctor_community.commonality;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by edison on 2018/5/21.
 */

public class Mylsitview extends ListView {

    public Mylsitview(Context context) {
        super(context);
    }
    public Mylsitview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public Mylsitview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 重写该方法、达到使ListView适应ScrollView的效果
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
