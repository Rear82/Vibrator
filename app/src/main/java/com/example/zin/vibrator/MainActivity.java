package com.example.zin.vibrator;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.zin.vibrator.R.id.b1;
import static com.example.zin.vibrator.R.id.b2;
import static com.example.zin.vibrator.R.id.b3;
import static com.example.zin.vibrator.R.id.b4;

public class MainActivity extends AppCompatActivity {
	int wopen=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final t1 t2 = new t1();
		final Button b = (Button) findViewById(b1);
		b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				t2.step = 2000;
				t2.ju = 1;
				if(wopen==0){t2.start();wopen=1;}
			}
		});

		Button c = (Button) findViewById(b2);
		c.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				t2.step = 1000;
				t2.ju = 1;
				if(wopen==0){t2.start();wopen=1;}
			}
		});

		Button d = (Button) findViewById(b3);
		d.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				t2.step = 500;
				t2.ju = 1;
				if(wopen==0){t2.start();wopen=1;}
			}
		});



		final Button e = (Button) findViewById(b4);
		e.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				t2.ju = 0;
			}
		});
	}

	class t1 extends Thread {
		public final Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		public int ju;
		public int step;

		@Override
		public void run() {
			while (1 == 1) {
				if (ju == 1) {
					vb.cancel();
					vb.vibrate(500);
					try {
						sleep(step);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}


		}


	}

}
