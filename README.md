# MultiTypePagerAdapter

多视图类型的ViewPager Adapter

## 引入依赖

```gr
implementation 'me.simple:multi-type-pager-adapter:1.0.0'
```

## ItemViewBinder

```java
public class TextBinder extends ItemViewBinder<String> {

    @Override
    protected int getLayoutId() {
        return R.layout.item_text;
    }

    @Override
    protected void convertItem(View view, int position, String item) {
        TextView text = view.findViewById(R.id.text);
        text.setTextColor(Color.RED);
        text.setText(item);
    }
}
```

```java
public class ImageBinder extends ItemViewBinder<Integer> {

    @Override
    protected int getLayoutId() {
        return R.layout.item_image;
    }

    @Override
    protected void convertItem(View view, int position, String item) {
       
    }
  
    @Override
    protected void destroyItem(View itemView, int position, Object item) {
        super.destroyItem(itemView, position, item);
    }
}
```

## One To One

```java
Items items = new Items();
MultiTypePagerAdapter adapter = new MultiTypePagerAdapter(items);
adapter.register(Integer.class, new ImageBinder());
adapter.register(String.class, new TextBinder());

items.add(1);
items.add("Java");
items.add(1);
items.add("Python");
items.add(1);
items.add("C++");
items.add(1);
items.add("Go");
items.add(1);
items.add("Rust");

viewPager.setAdapter(adapter);
```

## One To Many

```java
Items items = new Items();
MultiTypePagerAdapter adapter = new MultiTypePagerAdapter(items);
adapter.register(String.class)
       .to(
                new TextBinder(),
                new Text2Binder()
           )
        .withLinker(new Linker<String>() {
                    @Override
                    public Class<? extends ItemViewBinder<String>> index(int position, String s) {
                        return TextUtils.equals(s, "Text2Binder")
                                ? Text2Binder.class
                                : TextBinder.class;
                    }
                });

items.add("TextBinder");
items.add("Text2Binder");
items.add("TextBinder");
items.add("Text2Binder");
items.add("TextBinder");

viewPager.setAdapter(adapter);
```

