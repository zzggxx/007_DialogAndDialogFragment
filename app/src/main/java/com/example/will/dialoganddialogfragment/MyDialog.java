package com.example.will.dialoganddialogfragment;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class MyDialog extends Dialog {

    public MyDialog(@NonNull Context context) {
//        想要背景也是升起来的需要style和initDialog();
        super(context, R.style.Dialog_FullScreen);
//        initDialog();
        setContentView(R.layout.fragment_dialog);
    }

    /*---------------------------------实现全屏并且有出入动画---------------------------------------*/
    private void initDialog() {
        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.dialogStyle);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }
}
