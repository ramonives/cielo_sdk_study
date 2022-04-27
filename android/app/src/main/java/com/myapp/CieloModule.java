package com.myapp;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.HashMap;

import android.app.Activity;
import android.util.Log;


import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import cielo.sdk.order.PrinterListener;
import cielo.sdk.printer.PrinterManager;
import cielo.orders.domain.Credentials;
import cielo.sdk.order.OrderManager;
import cielo.sdk.order.ServiceBindListener;


public class CieloModule extends ReactContextBaseJavaModule {

    CieloModule(ReactApplicationContext context) {
        super(context);
    }

    Activity activity;

    private HashMap<String, Integer> alignCenter = new HashMap<>();
    PrinterListener printerListener = new PrinterListener() {
        @Override
        public void onPrintSuccess() {
            Log.d("onPrintSuccess", "onPrintSuccess");

        }

        @Override
        public void onError(@Nullable Throwable throwable) {
            Log.d("onError", "onError");

        }

        @Override
        public void onWithoutPaper() {
            Log.d("onWithoutPaper", "onWithoutPaper");

        }
    };

    @ReactMethod
    public void printSimpleText() {
        activity = getCurrentActivity();
        PrinterManager printerManager = new PrinterManager(activity);

        String textToPrint = "Texto simples a ser impresso.\n Com múltiplas linhas";
        printerManager.printText(textToPrint, alignCenter, printerListener);

        Log.d("(╯°□°）╯︵ ┻━┻", "(╯°□°）╯︵ ┻━┻");

    }


    @ReactMethod
    public void sayHello(String name, Callback callback) {
        String msg = "Hello " + name;
        callback.invoke(msg);
        Log.d("TESTANDO LOG", "TESTANDO LOG");
    }


    @Override
    public String getName() {
        return "CieloModule";
    }
}

