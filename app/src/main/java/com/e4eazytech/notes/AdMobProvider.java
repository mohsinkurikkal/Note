package com.e4eazytech.notes;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.e4eazytech.notes.util.Constants;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AdMobProvider extends Fragment {
    private AdView adView;

    public AdMobProvider() {
    }

    public static AdMobProvider getInstance() {
        return new AdMobProvider();
    }

    public void initializeMobileAds(AppCompatActivity activity) {
        if (activity == null) {
            return;
        }
        MobileAds.initialize(activity, Constants.AdMobAppPublishId.ADMOB_PUBLISH_ID);
    }

    public void displayBannerAds(AppCompatActivity activity) {
        if (activity == null) {
            return;
        }
        activity.getSupportFragmentManager().beginTransaction().add(R.id.adView, this).commitAllowingStateLoss();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mob_adview, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View adContainer = getView().findViewById(R.id.adView);
        adView = new AdView(getContext());
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setAdUnitId(Constants.AdMobBannerId.ADMOB_BANNER_ID);
        ((RelativeLayout) adContainer).addView(adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}