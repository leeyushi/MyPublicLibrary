package com.example.mypubliclibrary.util;

import android.content.Context;

import com.example.mypubliclibrary.base.BasesActivity;
import com.example.mypubliclibrary.base.bean.EventMsg;
import com.example.mypubliclibrary.util.constant.DataInterface;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import org.greenrobot.eventbus.EventBus;

/**
 * function:
 * describe:
 * Created By LiQiang on 2019/8/6.
 */
public class EventBusUtils {
    /**
     * 解绑
     *
     * @param subscriber 对象
     */
    public static void unregister(Object subscriber) {
        if (EventBus.getDefault().isRegistered(subscriber))
            EventBus.getDefault().unregister(subscriber);
    }

    /**
     * 注册
     *
     * @param subscriber context
     */
    public static void register(Object subscriber) {
        if (!EventBus.getDefault().isRegistered(subscriber))
            EventBus.getDefault().register(subscriber);
    }

    /**
     * API是否请求成功
     *
     * @param context  context
     * @param eventMsg 消息
     * @return true请求成功
     */
    public static boolean isSuccess(Context context, EventMsg eventMsg, String initiator, SmartRefreshLayout... srlRefreshHead) {
        boolean result = eventMsg.getRequest() != null && eventMsg.getMessage() != null && eventMsg.getMessage().equals(DataInterface.SUCCESS);
        if (!result && eventMsg.getRequest() != null && !StringUtils.isEmpty(eventMsg.getMessage()) && initiator.equals(eventMsg.getInitiator()))
            ToastUtils.showLongToast(context, eventMsg.getMessage());
        if (srlRefreshHead.length > 0 && srlRefreshHead[0] != null && eventMsg.getRequest() != null) {
            srlRefreshHead[0].finishRefresh(result);
            srlRefreshHead[0].finishLoadMore(result);
        }
        return result;
    }


    public static void post(EventMsg eventMsg) {
        EventBus.getDefault().post(eventMsg);
    }

}
