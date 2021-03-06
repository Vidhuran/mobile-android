package me.openphoto.android.app.common;

import me.openphoto.android.app.util.CommonUtils;
import me.openphoto.android.app.util.TrackerUtils;

import org.holoeverywhere.preference.PreferenceActivity;

import android.os.Bundle;

/**
 * Common preference activity with lifecycle tracking
 * 
 * @author Eugene Popovich
 */
public class CommonPreferenceActivity extends PreferenceActivity {
    static final String TAG = CommonPreferenceActivity.class.getSimpleName();
    static final String CATEGORY = "Preference Activity Lifecycle";

    void trackLifecycleEvent(String event)
    {
        CommonUtils.debug(TAG, event + ": " + getClass().getSimpleName());
        TrackerUtils.trackEvent(CATEGORY, event, getClass().getSimpleName());
    }
    @Override
    protected void onStart() {
        super.onStart();
        trackLifecycleEvent("onStart");
        TrackerUtils.activityStart(this);
        TrackerUtils.trackView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        trackLifecycleEvent("onStop");
        TrackerUtils.activityStop(this);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        trackLifecycleEvent("onCreate");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        trackLifecycleEvent("onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        trackLifecycleEvent("onSaveInstanceState");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        trackLifecycleEvent("onResume");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        trackLifecycleEvent("onPause");
    }

}
