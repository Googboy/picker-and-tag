package com.example.tag;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得TabHost的对象，并进行初始化setup()
        final TabHost tabs = (TabHost) findViewById(R.id.tabHost);
        tabs.setup();
        //通过tabhost.tabspec增加tab的一页，通过setcontent()增加内容,通过setIndicator增加页的标签
        //增加第一页
        TabHost.TabSpec spec = tabs.newTabSpec("Tag1");
        spec.setContent(R.id.acTab);
        spec.setIndicator("Clock");
        tabs.addTab(spec);
        //增加第二页
        spec = tabs.newTabSpec("Tag2");
        spec.setContent(R.id.btnTab);
                                                                     /*Button b = new Button(this);
                                                                      b.setText("标签");
                                                                      spec.setIndicator(b);这里使用b的话就是显示 "标签" 两字 不然就是显示 "Button"
                                                                      */
        Resources resources = getResources();
        spec.setIndicator("Button",resources.getDrawable(R.drawable.picture_selector));
        //spec.setIndicator("Button");
        tabs.addTab(spec);
                                                                    //通过setcurrenttab(index)指定显示的页，从0开始计算
                                                                    //tabs.setCurrentTab(1);

    }
}
