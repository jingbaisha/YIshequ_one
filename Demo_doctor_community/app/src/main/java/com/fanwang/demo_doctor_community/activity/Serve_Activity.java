package com.fanwang.demo_doctor_community.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.Serve_Adapter;
import com.fanwang.demo_doctor_community.adapter.Serve_Adapter_dialog_a;
import com.fanwang.demo_doctor_community.bean.JsonBean;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.custom.SearchView;
import com.fanwang.demo_doctor_community.dialog.Dialog_xuanze;
import com.fanwang.demo_doctor_community.utils.GetJsonDataUtil;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/5/29.
 */

public class Serve_Activity extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.tv_servre_moren)
    Button tvServreMoren;
    @BindView(R.id.tv_servre_xiaoliang)
    Button tvServreXiaoliang;
    @BindView(R.id.tv_servre_pingjia)
    Button tvServrePingjia;
    @BindView(R.id.tv_servre_fujin)
    Button tvServreFujin;
    @BindView(R.id.tv_ssq)
    TextView tvSsq;
    @BindView(R.id.tv_sq)
    TextView tvSq;
    @BindView(R.id.rcv_serve)
    RecyclerView rcvServe;
    @BindView(R.id.searchview)
    SearchView searchview;
    @BindView(R.id.lin_xiala)
    LinearLayout linXiala;
    @BindView(R.id.lin_lay_search)
    RelativeLayout linLaySearch;
    @BindView(R.id.lin_liandong)
    LinearLayout linLiandong;
    @BindView(R.id.lin_shequ)
    LinearLayout linShequ;
    @BindView(R.id.rl_doctor)
    RelativeLayout layout;

    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;
    private boolean isLoaded = false;

    private TitleBackFragment titleBackFragment;
    String[] data = {"默认", "销量", "评价", "附近"};
    List<Fragment> mFragmentList = new ArrayList<>();
    ArrayList<CustomTabEntity> list = new ArrayList<>();
    private Serve_Adapter adapter;
    private Intent intent;
    private String tx = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serve_activity);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("呼吸内科", "#23b1a5");
        addTitleFragment(titleBackFragment);
        tvServreMoren.setSelected(true);
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread == null) {   //如果已创建就不再重新创建子线程了
//                        Toast.makeText(Serve_Activity.this, "Begin Parse Data", Toast.LENGTH_SHORT).show();
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // 子线程中解析省市区数据
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;

                case MSG_LOAD_SUCCESS:
//                    Toast.makeText(Serve_Activity.this, "Parse Succeed", Toast.LENGTH_SHORT).show();
                    isLoaded = true;
                    break;

                case MSG_LOAD_FAILED:
//                    Toast.makeText(Serve_Activity.this, "Parse Failed", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    public void initData() {
        mHandler.sendEmptyMessage(MSG_LOAD_DATA);
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_item));
        rcvServe.addItemDecoration(divider);

        adapter = new Serve_Adapter(this);
        rcvServe.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvServe.setAdapter(adapter);
        adapter.GetOnclickItems(new Serve_Adapter.OnclickItem() {
            @Override
            public void SetOnclickItems(int position, View view) {
                intent = new Intent(Serve_Activity.this, Details_a.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }

    @OnClick({R.id.tv_servre_moren, R.id.tv_servre_xiaoliang, R.id.tv_servre_pingjia,
            R.id.tv_servre_fujin, R.id.lin_liandong, R.id.lin_shequ, R.id.rl_doctor})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.tv_servre_moren:
                initOnclick(1);
                break;
            case R.id.tv_servre_xiaoliang:
                initOnclick(2);
                break;
            case R.id.tv_servre_pingjia:
                initOnclick(3);
                break;
            case R.id.tv_servre_fujin:
                initOnclick(4);
                break;
            case R.id.lin_liandong:
                showPickerView();
                break;
            case R.id.lin_shequ:
                if (!tx.equals("")) {
                    MaterialDialog dialog = new MaterialDialog.Builder(this)
                            .customView(R.layout.dialog_b, false)
                            .build();

                    ListView list = (ListView) dialog.findViewById(R.id.lv_dialog_a);
                    Serve_Adapter_dialog_a adapter_dialog_a = new Serve_Adapter_dialog_a(this);
                    list.setAdapter(adapter_dialog_a);

                    dialog.show();
                } else {
                    Toast.makeText(this, "请先选择区域", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rl_doctor:
                new Dialog_xuanze().ShowDialog(layout, this);
                break;
        }
    }

    private void initOnclick(int i) {
        if (i == 1) {
            tvServreMoren.setSelected(true);
        } else {
            tvServreMoren.setSelected(false);
        }
        if (i == 2) {
            tvServreXiaoliang.setSelected(true);
        } else {
            tvServreXiaoliang.setSelected(false);
        }
        if (i == 3) {
            tvServrePingjia.setSelected(true);
        } else {
            tvServrePingjia.setSelected(false);
        }
        if (i == 4) {
            tvServreFujin.setSelected(true);
        } else {
            tvServreFujin.setSelected(false);
        }

    }

    private void showPickerView() {
        // 弹出选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                tx = options1Items.get(options1).getPickerViewText() +
                        options2Items.get(options1).get(options2) +
                        options3Items.get(options1).get(options2).get(options3);

//                Toast.makeText(Serve_Activity.this, "" + tx, Toast.LENGTH_SHORT).show();
                tvSsq.setText(tx);
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    private void initJsonData() {//解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(this, "province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市
                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {
                    City_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }

        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS);

    }

    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }
}
