package com.wangkun.weixinui.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangkun.weixinui.R;
import com.wangkun.weixinui.fragment.Fragment_Find;
import com.wangkun.weixinui.fragment.Fragment_Home;
import com.wangkun.weixinui.fragment.Fragment_List;
import com.wangkun.weixinui.fragment.Fragment_Me;


public class MainActivity extends FragmentActivity {


    // 声明碎片: 首页, 通讯录,发现,我
    Fragment fragment_home,fragment_list,fragment_find,fragment_me;
    Fragment[] fragments;// 碎片数组
    TextView tv_home,tv_list,tv_find, tv_me;
    TextView[] arr_tv;// 文本的数组
    ImageView iv_home,iv_list,iv_find, iv_me;
    ImageView[] arr_iv;// 图标的数组

    // 下面的两个数组是分别装资源ID
    // 点击的ID
    int[] arr_id_box = {
            R.id.box1,
            R.id.box2,
            R.id.box3,
            R.id.box4
    };
    // 默认的ID(白色的图片)
    int[] arr_id_default = {
            R.drawable.weixin_normal,
            R.drawable.contact_list_normal,
            R.drawable.find_normal,
            R.drawable.profile_normal,
    };
    // 选中的ID(绿色的图片)
    int[] arr_id_selected = {
            R.drawable.weixin_pressed,
            R.drawable.contact_list_pressed,
            R.drawable.find_pressed,
            R.drawable.profile_pressed,
    };


    // 右上角"+", 左上角的头像
    ImageView iv_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 保持屏幕常亮
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
        );

        setContentView(R.layout.activity_main);

        initView();
        initFragment();
        change(fragments[3]);// "我"
        checkHighLight(3);// 设定高亮
    }

    private void initView() {
        tv_home = (TextView) findViewById(R.id.tv_home);
        tv_list = (TextView) findViewById(R.id.tv_list);
        tv_find = (TextView) findViewById(R.id.tv_find);
        tv_me = (TextView) findViewById(R.id.tv_me);

        arr_tv = new TextView[4];
        arr_tv[0] = tv_home;
        arr_tv[1] = tv_list;
        arr_tv[2] = tv_find;
        arr_tv[3] = tv_me;

        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_list = (ImageView) findViewById(R.id.iv_list);
        iv_find = (ImageView) findViewById(R.id.iv_find);
        iv_me   = (ImageView) findViewById(R.id.iv_me);

        arr_iv = new ImageView[4];
        arr_iv[0] = iv_home;
        arr_iv[1] = iv_list;
        arr_iv[2] = iv_find;
        arr_iv[3] = iv_me;


        iv_menu = (ImageView) findViewById(R.id.iv_menu);


    }

    /**
     * 初始化碎片
     */
    private void initFragment(){
        fragment_home = new Fragment_Home();
        fragment_list = new Fragment_List();
        fragment_find = new Fragment_Find();
        fragment_me = new Fragment_Me();

        fragments = new Fragment[4];
        fragments[0] = fragment_home;
        fragments[1] = fragment_list;
        fragments[2] = fragment_find;
        fragments[3] = fragment_me;
    }

    /**
     * 切换碎片的方法
     * @param f
     */
    private void change(Fragment f){
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content,f)
                .commit();// 提交事务

    }

    // 点击按钮
    public void clickBox(View v){
        // 循环遍历,检查id
        for (int i = 0; i< arr_id_box.length; i++){
            if (v.getId() == arr_id_box[i]){
                change(fragments[i]);// 切换碎片
                checkHighLight(i);// 添加高亮
            }
        }
    }

    /**
     * 选中高亮
     * @param index
     */
    private void checkHighLight(int index){
        // 高亮字体
        for (int i = 0; i< arr_tv.length; i++){
            arr_tv[i].setTextColor(Color.BLACK);// 黑色
        }
        arr_tv[index].setTextColor(getResources().getColor(R.color.green));//绿色
        // 高亮图标
        // 全部的图标要先统一程默认的图标
        setAllImageDefault();
        arr_iv[index].setImageResource(arr_id_selected[index]);
    }

    // 设置默认图片资源
    private void setAllImageDefault() {
        for (int i = 0; i< arr_iv.length; i++){
            arr_iv[i].setImageResource(arr_id_default[i]);
        }
    }

}
