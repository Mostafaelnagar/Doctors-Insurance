package com.company.doctorsinsurance.common;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.company.doctorsinsurance.DoctorsActivity;
import com.company.doctorsinsurance.R;
import com.company.doctorsinsurance.model.insurances;
import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton;
import com.fangxu.allangleexpandablebutton.ButtonData;
import com.fangxu.allangleexpandablebutton.ButtonEventListener;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class common {
    //Navigation Menu setup to use when needed
    public static void navigationMenu(View view, Context context) {
        final AllAngleExpandableButton button = (AllAngleExpandableButton) view.findViewById(R.id.button_expandable_90_180);
        final List<ButtonData> buttonDatas = new ArrayList<>();
        int[] drawable = {R.drawable.ic_add, R.mipmap.ic_bottom_person, R.mipmap.ic_bottom_locations, R.mipmap.ic_bottom_chat, R.mipmap.ic_bottom_home};
        for (int i = 0; i <= 4; i++) {
            ButtonData buttonData;
            if (i == 0) {
                buttonData = ButtonData.buildIconButton(context, drawable[i], 10);
            } else if (i == 2) {
                buttonData = ButtonData.buildIconButton(context, drawable[i], 0);
                buttonData.setBackgroundColorId(context, R.color.colorClick);

            } else {
                buttonData = ButtonData.buildIconButton(context, drawable[i], 0);
            }
            buttonData.setBackgroundColorId(context, R.color.colorBackground);
            buttonDatas.add(buttonData);
        }
        button.setButtonDatas(buttonDatas);

        setListener(button, context);
    }

    //Actions of Navigation Menu
    public static void setListener(final AllAngleExpandableButton button, final Context context) {
        button.setButtonEventListener(new ButtonEventListener() {
            @Override
            public void onButtonClicked(int index) {
                Toast.makeText(context, "" + index, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onExpand() {
            }

            @Override
            public void onCollapse() {
            }
        });
    }

    //ToolBar setup
    public static void changeToolbarSettings(View view, int drawable, String title) {
        TextView txt_Toolbar_Title = view.findViewById(R.id.txt_Title);
        txt_Toolbar_Title.setText(title);
        txt_Toolbar_Title.setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0);
    }

    //Font Init
    public static void fontInit() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/FranklinGothic.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
}
