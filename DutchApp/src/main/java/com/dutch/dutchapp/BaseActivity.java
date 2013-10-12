package com.dutch.dutchapp;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by abhinavtrivedi on 10/10/13.
 */
public abstract class BaseActivity extends Activity {

    protected String getServerUrl(int pathId) {
        StringBuilder sb = new StringBuilder();
        sb.append(getBaseUrl());
        String context = getString(pathId);
        if (context != null) {
            sb.append(context);
        }
        return sb.toString();
    }

    private String getServerUrl() {
        return getBaseUrl();
    }

    private String getBaseUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append("http");
        if (getResources().getBoolean(R.bool.DUTCH_SERVER_SECURE)) {
            sb.append("s");
        }
        sb.append("://").append(getString(R.string.DUTCH_SERVER_HOST));
        if (getResources().getInteger(R.integer.DUTCH_SERVER_PORT) > 0) {
            sb.append(":").append(getResources().getInteger(R.integer.DUTCH_SERVER_PORT));
        }
        return sb.toString();
    }

    protected String getVersion() {
        try {
            Context context = getApplicationContext();
            PackageManager manager = context.getPackageManager();
            return manager.getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "N/A";
        }
    }
}
