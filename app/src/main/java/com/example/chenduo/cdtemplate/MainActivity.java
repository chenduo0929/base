
package com.example.chenduo.cdtemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.chenduo.cdtemplate.demo.recyclerviewRtrofitGreendao.SampleActivity;
import com.example.chenduo.cdtemplate.demo.supportDesign.DemoSupportDesignActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.DemoRRG, R.id.DemoSD
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.DemoRRG:
                startActivity(new Intent(this, SampleActivity.class));
                break;
            case R.id.DemoSD:
                startActivity(new Intent(this, DemoSupportDesignActivity.class));
                break;
        }
    }
}
