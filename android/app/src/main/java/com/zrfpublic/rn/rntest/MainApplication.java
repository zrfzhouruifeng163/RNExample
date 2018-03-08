package com.zrfpublic.rn.rntest;

/**
 * 描述：
 * 作者：zhourf on 2018/3/8
 * 邮箱：zhourf@glodon.com
 */

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }
        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage()
            );
        }
        @Override
        protected String getJSMainModuleName() {
            return "index.android";
        }
    };
    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        //配置本机ip和端口号
        SharedPreferences mPreferences =    PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mPreferences.edit().putString("debug_http_host","192.168.92.47:8081").commit();//这里要配置下自己的ip地址
    }
}
