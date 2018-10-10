package com.example.will.dialoganddialogfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Dialog 和 DialogFragment
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button clk, clkf;
    private MyDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clk = (Button) findViewById(R.id.clk);
        dialog = new MyDialog(this);
//        dialog.setContentView(R.layout.dialog);
        clk.setOnClickListener(this);

        clkf = (Button) findViewById(R.id.clkf);
        clkf.setOnClickListener(this);

        findViewById(R.id.clka).setOnClickListener(this);

        //用户恢复对话框的状态
        if (savedInstanceState != null && savedInstanceState.getBoolean("dialog_show")) {
            clk.performClick();
        }
    }

    /**
     * 用于保存对话框的状态以便恢复
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (dialog != null && dialog.isShowing()) {
            outState.putBoolean("dialog_show", true);
        } else {
            outState.putBoolean("dialog_show", false);
        }
    }

    /**
     * 在Activity销毁之前，确保对话框以关闭
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clk:
                dialog.show();
                break;
            case R.id.clkf:
                MyDialogFragment mdf = new MyDialogFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                mdf.show(ft, "df");
                break;
            case R.id.clka:
                startActivity(new Intent(this, ActivityA.class));
                break;
        }
    }
}