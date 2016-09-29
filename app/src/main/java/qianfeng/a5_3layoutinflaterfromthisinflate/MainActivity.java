package qianfeng.a5_3layoutinflaterfromthisinflate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

//        View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, linearLayout, false);
//        linearLayout.addView(view);
        // 以上两行代码相当于View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, linearLayout, true);
        // 以上一行代码相当于 View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, linearLayout);

//        View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, linearLayout, true);
//        linearLayout.addView(view);// 这个子控件已经有一个父容器了，不能添加两次。
        //Caused by: java.lang.IllegalStateException: The specified child already has a parent. You must call removeView() on the child's parent first.

        // 以下这种方式没有给R.lanyout.btn_layout指定一个父容器，相当于里面的LinearLayout就是根节点，那么根节点中的布局参数是无效的，即layout_width=200dp是无效的
//        View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, null, true);

//        linearLayout.addView(view);

        // 虽然这个 View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, linearLayout, false);也没有把R.layout.btn_layout添加进父容器linearLayout里，
        // 但是它利用了这个父容器生成了自己的布局参数对象LayoutParams,使里面的laoyut_width=200dp变成有效，这样才可以生成你指定的视图，否则，你可以点击运行看看效果。
//        View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, linearLayout, false);
//        linearLayout.addView(view);

        View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, null);// 在一个activity。xml布局里面加入另一个布局btn_layout的情况，如果第二个参数是null，那么另一个布局里面根节点所写的布局参数全部无效，
        // 因为另一个布局里面的LinearLayout是根节点，根节点的布局参数是无效的，要想这个LinearLayout的布局参数(200dp)生效,
        // 就要把它放进一个父容器里面，让父容器协助它生成自己的布局参数。
        linearLayout.addView(view);
        // 注意测试的时候，把这两行代码和上面两行代码进行对比。


        /*
        老师笔记：
         LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content);
        //不将btn_layout添加到linearLayout中，linearLayout的存在只是为了协助btn_layout的根节点生成LayoutParams
//        View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, linearLayout, false);
        //如果第三个参数为true，表示将第一个参数所指定的View添加到第二个参数所指定的容器中
//        View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, linearLayout, true);
        //如果第二个参数为null，则btn_layout的根节点的宽高属性无效，且不会添加到任何容器中，此时第三个参数true和false显示效果一致
//        View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, null, true);
//        linearLayout.addView(view);

//        LayoutInflater.from(this).inflate(R.layout.btn_layout, null);//等同于View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, null, true);
        LayoutInflater.from(this).inflate(R.layout.btn_layout, linearLayout);//等同于View view = LayoutInflater.from(this).inflate(R.layout.btn_layout, linearLayout, true);
         */

    }
}
