package me.simple.multitype.sample;

import android.view.View;
import android.widget.TextView;

import me.simple.multitype.ItemViewBinder;

public class TextBinder extends ItemViewBinder<String> {

    @Override
    protected int getLayoutId() {
        return R.layout.item_text;
    }

    @Override
    protected void convert(View view, int position, String item) {
        TextView text = view.findViewById(R.id.text);
        text.setText(item);
    }
}
