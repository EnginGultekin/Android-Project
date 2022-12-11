package com.engleg.tablayout;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabview);
        Resources res =getResources();
        TabHost tabhost = getTabHost();
        TabHost.TabSpec spec;

        Intent intent;
        intent =new Intent().setClass(this,TabArama.class);
        spec = tabhost.newTabSpec("arama").setIndicator("Arama",
                res.getDrawable(R.drawable.tabselector_arama)).setContent(intent);
        tabhost.addTab(spec);

        intent =new Intent().setClass(this,TabSms.class);
        spec = tabhost.newTabSpec("sms").setIndicator("SMS",
                res.getDrawable(R.drawable.tabselector_sms)).setContent(intent);
        tabhost.addTab(spec);

        intent =new Intent().setClass(this,TabEposta.class);
        spec = tabhost.newTabSpec("eposta").setIndicator("E-Posta",
                res.getDrawable(R.drawable.tabselector_eposta)).setContent(intent);
        tabhost.addTab(spec);
    }

    public TabHost getTabHost() {
        return null;
    }


}
