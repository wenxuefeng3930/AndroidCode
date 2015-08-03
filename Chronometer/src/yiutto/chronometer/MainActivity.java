package yiutto.chronometer;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
public class MainActivity extends Activity {
	Chronometer ch;
	Button start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 获取计时器组件
		ch = (Chronometer) findViewById(R.id.test);
		// 获取“开始”按钮
		start = (Button) findViewById(R.id.start);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				// 设置开始计时时间
				ch.setBase(SystemClock.elapsedRealtime());
				// 启动计时器
				ch.start();
				start.setEnabled(false);
			}
		});
		// 为Chronometer绑定事件监听器
		ch.setOnChronometerTickListener(new OnChronometerTickListener() {

			@Override
			public void onChronometerTick(Chronometer ch) {
				// 如果从开始计时到现在超过20s
				if (SystemClock.elapsedRealtime() - ch.getBase() > 20 * 1000) {
					ch.stop();
					start.setEnabled(true);
				}

			}
		});

	}

}
