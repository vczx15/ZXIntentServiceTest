package com.example.god.zxintentservicetest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    private Button normal;
    private Button Special;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        normal= (Button) findViewById(R.id.startNormalService);
        Special= (Button) findViewById(R.id.startIntentService);
        normal.setOnClickListener(this);
        Special.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.startNormalService:
            {
                Intent intent=new Intent(MainActivity.this,MyService.class);
                startService(intent);
            }
            break;
            case R.id.startIntentService:
                Intent intent=new Intent(MainActivity.this,MyIntentService.class);
                startService(intent);
                break;
            default:
                break;
        }
    }
}
