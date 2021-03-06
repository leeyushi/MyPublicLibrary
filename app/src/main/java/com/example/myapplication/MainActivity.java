package com.example.myapplication;

import android.graphics.Color;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mypubliclibrary.base.BasesActivity;
import com.example.mypubliclibrary.base.bean.EventMsg;
import com.example.mypubliclibrary.base.interfaces.WebCall;
import com.example.mypubliclibrary.util.CodeUtils;
import com.example.mypubliclibrary.util.EventBusUtils;
import com.example.mypubliclibrary.util.ListUtils;
import com.example.mypubliclibrary.util.NumberUtil;
import com.example.mypubliclibrary.util.SharedPreferencesUtils;
import com.example.mypubliclibrary.util.ToastUtils;
import com.example.mypubliclibrary.util.WebUtils;
import com.example.mypubliclibrary.util.style.PublicLibraryStyle;
import com.example.mypubliclibrary.widget.dialog.basic.WarningDialog;
import com.example.mypubliclibrary.widget.dialog.build.BuildPasswordAttribute;
import com.example.mypubliclibrary.widget.dialog.build.BuildSelectTextAttribute;
import com.example.mypubliclibrary.widget.dialog.build.BuildWarningAttribute;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BasesActivity<TestPre> {

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventMsg message) {
//        if (message.getType().equals("test")) {
//            mPresenter.test(this);
//        }
    }

    @Override
    protected int onRegistered() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        EventBusUtils.register(this);
        PublicLibraryStyle.colorThemes = new int[]{Color.parseColor("#f50116"), Color.parseColor("#f95532")};
        PublicLibraryStyle.colorTheme = Color.parseColor("#f50116");
//        showLoading("正在上传图片中...", false);
        Log.i("testId", bindId(R.id.ctl_content).getId() + "");
//        int colors[] = { Color.parseColor("#ee0a1f") ,Color.parseColor("#f15628") };//分别为开始颜色，中间夜色，结束颜色
//        setBackground(R.id.tv_test1, getBackRadius(Color.parseColor("#EE0E1F"), 6).setDefaultGdColor(colors).create());
        SharedPreferencesUtils.getInstance().init(this);

    }

    @Override
    protected void initStyle() {

    }

    @Override
    protected void getPageRequestData() {

    }

    @Override
    protected void initData() {
        mPresenter.test(this);
//        EventBusUtils.post(new EventMsg<>().setType("test"));
    }

    @Override
    protected void initListener() {
        bindClick(new ListUtils<Integer>().add(R.id.tv_test, R.id.tv_test1));
    }

    @Override
    protected void mayRefreshData() {

    }


    boolean test;
    Timer mTimer;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_test:
//                new BuildPasswordAttribute(this) {
//                    @Override
//                    protected void onDone(String password) {
//                        ToastUtils.showLongToast(MainActivity.this, "输入了" + password);
//                    }
//                }.setTitle("请输入支付密码")
//                        .setHintText("使用会员卡余额支付需要验证身份。")
//                        .setMoney("￥ 100.00")
//                        .createWindow()
//                        .show();
//                new BuildWarningAttribute(this) {
//                    @Override
//                    protected void oneClick() {
//
//                    }
//
//                    @Override
//                    protected void twoClick() {
//
//                    }
//                }.setTitle("登录")
//                        .setShowValue("登录后才可以继续，是否现在去登录？")
//                        .createWindow()
//                        .show();
//                WebUtils.jumpWeb(this, "http://live.polyv.cn/watch/443540", "直播");
                WebUtils.jumpWeb(this, "https://live.polyv.cn/watch/443540/set-nickname?nickname=A+lq&_=1579335546000", "直播", ()->
                        Log.i("onLoadDone", "onLoadDone加载完成"));
//                ImageUtils.previewPhoto(this, new ListUtils<>().add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548756837006&di=551df0dcf59d1d71673c3d46b33f0d93&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201308%2F04%2F20130804155912_wCRnE.thumb.700_0.jpeg",
//                        "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2279952540,2544282724&fm=26&gp=0.jpg", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=851052518,4050485518&fm=26&gp=0.jpg"));
//                CodeUtils.getInstance().startTiming("", bindId(R.id.tv_test), "点击重发验证码");
//                jumpActivity(Main2Activity.class);

//                jumpActivity(Main2Activity.class);
//                new BottomIosDialog(this) {
//                    @Override
//                    protected List<String> getItems() {
//                        return new ListUtils<String>().add("播放完当前声音结束", "5分钟", "15分钟", "30分钟", "60分钟");
//                    }
//
//                    @Override
//                    protected void itemClicks(Button button, int position) {
//
//                    }
//                }.setBackgroundColor(Color.parseColor("#000000")).setLineColor(Color.parseColor("#565656")).setCancelShow(false).show();
                break;
            case R.id.tv_test1:
//                mTimer.cancel();
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        CodeUtils.getInstance().cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onQuestError(EventMsg message) {

    }

    @Override
    public void onQuestSuccess(EventMsg message) {

    }
}
