package com.example.mypubliclibrary.util;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

import com.example.mypubliclibrary.base.BasesActivity;

/**
 * function:
 * describe:
 * Created By LiQiang on 2019/7/18.
 */
public class StringUtils {
//    //字符串颜色工具类
//    public static StringColor newStringColor() {
//        return new StringColor();
//    }
//
//    public static final class StringColor {
//        //开始位置,下标从0开始,包含开始位置
//        private int startIndex;
//        //结束位置，下标从0开始，不包含结束位置
//        private int endIndex;
//        //颜色
//        private int color;
//        //显示的内容
//        private String value;
//
//
//        public StringColor setStartIndex(int startIndex) {
//            this.startIndex = startIndex;
//            return this;
//        }
//
//        public StringColor setEndIndex(int endIndex) {
//            this.endIndex = endIndex;
//            return this;
//        }
//
//        public StringColor setColor(int color) {
//            this.color = color;
//            return this;
//        }
//
//        public StringColor setValue(String value) {
//            this.value = value;
//            return this;
//        }
//
//        /**
//         * 给字符串设置区间的颜色
//         *
//         * @param context context
//         * @return 直接复制给TextView.setText()即可
//         */
//        public SpannableStringBuilder create(Context context) {
//            SpannableStringBuilder style = new SpannableStringBuilder(value);
//            style.setSpan(new ForegroundColorSpan(context.getResources().getColor(color)), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            return style;
//        }
//    }

    /**
     * 给部分文本增加颜色
     *
     * @param value         完整字符串
     * @param addColorValue 要添加颜色的文本
     * @param color         颜色
     * @return 直接赋值给TextView.setText()即可
     */
    public static SpannableStringBuilder addColorToText(String value, String addColorValue, int color) {
        SpannableStringBuilder style = new SpannableStringBuilder(value);
        int start = value.indexOf(addColorValue);
        style.setSpan(new ForegroundColorSpan(color), start, start + addColorValue.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return style;
    }


    public static String getIndexString(String value, int start, int length) {
        return value.substring(start, start + length);
    }

    public static boolean equals(String value, String equalsValue) {
        return value != null && value.equals(equalsValue);
    }


    /**
     * 字符串去除指定内容
     *
     * @param value    字符串
     * @param replaceS 去除的内容
     * @return 去除后的值
     */
    public static String removeString(String value, String... replaceS) {
        for (String replace : replaceS) {
            value = value.replace(replace, "");
        }
        return value;
    }

    public static boolean isEmpty(String value) {
        if (value == null) return true;
        return value.isEmpty();
    }
}
