package me.simple.multitype.sample;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import me.simple.multitype.ItemViewBinder;

public class Text2Binder extends ItemViewBinder<String> {

    @Override
    protected int getLayoutId() {
        return R.layout.item_text;
    }

    @Override
    protected void convertItem(View view, int position, String item) {
        TextView textView = view.findViewById(R.id.text);
        textView.setText("Text2Binder");
        textView.setTextColor(Color.BLUE);
    }
}
