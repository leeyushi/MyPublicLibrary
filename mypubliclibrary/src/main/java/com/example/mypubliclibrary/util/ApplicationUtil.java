package com.example.mypubliclibrary.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.core.app.NotificationManagerCompat;

import com.example.mypubliclibrary.BuildConfig;


public class ApplicationUtil {
    /**
     * 是否为debug模式
     *
     * @return
     */
    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    /**
     * 如果没有通知权限，则提示去打开
     */
    public static void openNotice(Context context) {
        //判断是否打开通知，true打开,false没打开
//        NotificationManagerCompat notification = NotificationManagerCompat.from(context);
//        boolean isEnabled = notification.areNotificationsEnabled();
        //提示打开通知
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle("提示")
                .setMessage("请在“通知”中打开通知权限")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent intent = new Intent();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  //5.0
                            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                            intent.putExtra("app_package", context.getPackageName());
                            intent.putExtra("app_uid", context.getApplicationInfo().uid);
                            context.startActivity(intent);
                        } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {  //4.4
                            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            intent.addCategory(Intent.CATEGORY_DEFAULT);
                            intent.setData(Uri.parse("package:" + context.getPackageName()));
                        } else if (Build.VERSION.SDK_INT >= 15) {
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                        }
                        context.startActivity(intent);
                    }
                })
                .create();
        alertDialog.show();
        alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
    }
}
