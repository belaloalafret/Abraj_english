package cn.jeesoft.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import cn.jeesoft.widget.pickerview.CharacterPickerView;
import cn.jeesoft.widget.pickerview.CharacterPickerWindow;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 用View的方式实现
        showView();
        // 用PopupWindow的方式实现
        //showWindow();

    }

    private void showView() {
        RelativeLayout layout = new RelativeLayout(this);
        setContentView(layout);

        layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        CharacterPickerView pickerView = new CharacterPickerView(this);
        layout.addView(pickerView, layoutParams);

        List<String> d = new ArrayList<>();
        d.add("ahmad");
        d.add("ahmad2");
        d.add("ahmad3");
        d.add("ahmad4");


        List<List<String>> d1 = new ArrayList<>();
        d1.add(d);
        d1.add(d);
        d1.add(d);
        d1.add(d);


        pickerView.setPicker(d,d1);

        //初始化选项数据
        //OptionsWindowHelper.setPickerData(pickerView);

        //设置监听事件
        pickerView.setOnOptionChangedListener(new CharacterPickerView.OnOptionChangedListener() {
            @Override
            public void onOptionChanged(CharacterPickerView view, int option1, int option2, int option3) {
                Log.e("test", option1 + "," + option2 + "," + option3);
            }
        });

    }

    private void showWindow() {
        Button button = new Button(this);
        button.setText("ahmad");

        setContentView(button);

        //初始化
        final CharacterPickerWindow window = OptionsWindowHelper.builder(MainActivity.this, new OptionsWindowHelper.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(String province, String city, String area) {
                Log.e("main", province + "," + city + "," + area);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 弹出
                window.showAtLocation(v, Gravity.BOTTOM, 0, 0);
            }
        });

    }

}
