package com.fanwang.demo_doctor_community.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.CommentExpandAdapter;
import com.fanwang.demo_doctor_community.bean.CommentBean;
import com.fanwang.demo_doctor_community.bean.CommentDetailBean;
import com.fanwang.demo_doctor_community.bean.Data_item;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.custom.CommentDialog;
import com.fanwang.demo_doctor_community.custom.CommentExpandableListView;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/7.
 */

public class Leave_Massage extends Populace_Activity {

    private static final String TAG = Leave_Massage.class.getSimpleName();
    @BindView(R.id.tv_name_commet)
    TextView tvNameCommet;
    @BindView(R.id.cel_)
    CommentExpandableListView expandableListView;
    @BindView(R.id.detail_page_do_comment)
    TextView detailPageDoComment;
    @BindView(R.id.lin_layoyt_down)
    LinearLayout linLayoytDown;

    private CommentExpandAdapter adapter;
    private CommentBean commentBean;
    private List<CommentDetailBean> commentsList;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leave_massage);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("医生留言", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        commentsList = generateTestData();
        initExpandableListView(commentsList);
    }

    @OnClick({R.id.detail_page_do_comment})
    public void Onclick(View view){
        switch (view.getId()){
            case R.id.detail_page_do_comment:
                showCommentDialog_a();
                break;
        }
    }

    /**
     * 初始化评论和回复列表
     */
    private void initExpandableListView(final List<CommentDetailBean> commentList) {
        expandableListView.setGroupIndicator(null);
        //默认展开所有回复
        adapter = new CommentExpandAdapter(this, commentList);
        expandableListView.setAdapter(adapter);

        for (int i = 0; i < commentList.size(); i++) {
            expandableListView.expandGroup(i);
        }

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                boolean isExpanded = expandableListView.isGroupExpanded(groupPosition);
                Log.e(TAG, "onGroupClick: 当前的评论id>>>" + commentList.get(groupPosition).getId());

                return true;
            }
        });
    }

    /**
     * by moos on 2018/04/20
     * func:生成测试数据
     * @return 评论数据
     */
    private List<CommentDetailBean> generateTestData(){
        Gson gson = new Gson();
        commentBean = gson.fromJson(Data_item.testJson, CommentBean.class);
        List<CommentDetailBean> commentList = commentBean.getData().getList();
        return commentList;
    }


    public void showCommentDialog_a(){
        new CommentDialog("发表评论:", new CommentDialog.SendListener() {
            @Override
            public void sendComment(String inputText) {
                if(!TextUtils.isEmpty(inputText)){
                    //commentOnWork(commentContent);
                    CommentDetailBean detailBean = new CommentDetailBean("测试:", inputText,"刚刚");
                    adapter.addTheCommentData(detailBean);
                    Toast.makeText(Leave_Massage.this,"评论成功",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Leave_Massage.this,"评论内容不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        }).show(getSupportFragmentManager(),"ok");
    }
}
