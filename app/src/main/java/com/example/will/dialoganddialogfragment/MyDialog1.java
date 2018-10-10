//package com.example.will.dialoganddialogfragment;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AlertDialog;
//import android.view.Display;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyDialog1 extends AlertDialog {
//
//    private final int index;
//    private ImageView img;
//    private ViewPager m_viewPager;
//    LinearLayout ll_point;
//    private Context mContext;
//
//    int[] imageIds = new int[]{
//            R.drawable.a,
//            R.drawable.b,
//            R.drawable.c,
//            R.drawable.d,
//            R.drawable.e,
//            R.drawable.f,
//    };
//
//    String[] titles = new String[]{
//            "身征",
//            "外",
//            "信",
//            "还",
//            "人",
//            "交",
//    };
//
//    String[] contents = new String[]{
//            "您的。",
//            "您的。",
//            "您的。",
//            "您的。",
//            "您的。",
//            "您。",
//    };
//
//
//    public MyDialog1(@NonNull Activity context, int index) {
//        super(context, R.style.selfDefDialog);
//        this.mContext = context;
//        this.index = index;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dialog_layout1);
//        initView();
//        List<View> views = initData();
//        setData(views);
//
//        Display display = ((Activity) mContext).getWindowManager().getDefaultDisplay();
//        Window dialogWindow = getWindow();
//        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//        lp.width = (int) (display.getWidth() * 0.8);
//        lp.height = (int) (display.getHeight() * 0.5);
//        dialogWindow.setAttributes(lp);
//
//    }
//
//    private void setData(final List<View> views) {
//        mPagerAdapter adapter = new mPagerAdapter(views);
//        m_viewPager.setAdapter(adapter);
//        m_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                for (int i = 0; i < ll_point.getChildCount(); i++) {
//                    ImageView point = (ImageView) ll_point.getChildAt(i);
//                    point.setImageResource(R.drawable.pot);
//                }
//                ImageView v = (ImageView) ll_point.getChildAt(position);
//                v.setImageResource(R.drawable.potf);
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//    }
//
//    private void initView() {
//        findViewById(R.id.img_close).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
//        m_viewPager = (ViewPager) findViewById(R.id.m_viewpager);
//        ll_point = (LinearLayout) findViewById(R.id.ll_point);
//    }
//
//    private List<View> initData() {
//        List<PagerBean> beanList = new ArrayList<>();
//        List<View> views = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            PagerBean pagerBean = new PagerBean();
//            pagerBean.setImageid(imageIds[i]);
//            pagerBean.setStrone(titles[i]);
//            pagerBean.setStrtwo(contents[i]);
//            beanList.add(pagerBean);
//        }
//        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        for (int i = 0; i < beanList.size(); i++) {
//            View v = inflater.inflate(R.layout.pager_view, null);
//            ImageView img = (ImageView) v.findViewById(R.id.image);
//            TextView tv_1 = (TextView) v.findViewById(R.id.tv_one);
//            TextView tv_2 = (TextView) v.findViewById(R.id.tv_two);
//            img.setImageResource(beanList.get(i).getImageid());
//            tv_1.setText(beanList.get(i).getStrone());
//            tv_2.setText(beanList.get(i).getStrtwo());
//            views.add(v);
//        }
//        for (int i = 0; i < beanList.size(); i++) {
//            ImageView ima = new ImageView(mContext);
//            ima.setImageResource(R.drawable.pot);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT);
//            layoutParams.setMargins(10, 10, 10, 10);
//            ima.setLayoutParams(layoutParams);
//            ima.setMaxHeight(15);
//            ima.setAdjustViewBounds(true);
//
//            ll_point.addView(ima);
//        }
//        return views;
//    }
//
//    @Override
//    public void show() {
//        super.show();
//        // ((ImageView)ll_point.getChildAt(index)).setImageResource(R.drawable.potf);
//        m_viewPager.setCurrentItem(index);
//    }
//
//    class mPagerAdapter extends PagerAdapter {
//        private List<View> mList;
//
//        public mPagerAdapter(List<View> mList) {
//            this.mList = mList;
//        }
//
//        @Override
//        public int getCount() {
//            return mList.size();
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            container.addView(mList.get(position));
//            return mList.get(position);
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView(mList.get(position));
//        }
//
//        @Override
//        public boolean isViewFromObject(View arg0, Object arg1) {
//            return arg0 == arg1;
//        }
//
//    }
//}
