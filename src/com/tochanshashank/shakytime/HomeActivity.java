package com.tochanshashank.shakytime;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends Activity {

	ImageView animalFarm;
	int height;
	int width;
	MediaPlayer oldplayer = null;;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_home);
		
		animalFarm = (ImageView) findViewById(R.id.imageView1);
		animalFarm.setOnTouchListener(new AnimalTouchListener());
		
		getScreenDimensions();
	}
	
	private void getScreenDimensions() {
		if (android.os.Build.VERSION.SDK_INT >= 13) {
			Display display = getWindowManager().getDefaultDisplay();
			Point size = new Point();
			display.getSize(size);
			width = size.x;
			height = size.y;
		} else {
			Display display = getWindowManager().getDefaultDisplay(); 
			width = display.getWidth();  // deprecated
			height = display.getHeight();  // deprecated
		}
	}
	
	
	
	class AnimalTouchListener implements OnTouchListener {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            	String text = "Touch coordinates : " +
//                        String.valueOf(event.getX()) + "x" + String.valueOf(event.getY());
            	
            	Animal animal = getAnimal(event.getX(), event.getY());
            	if (animal == null) {
                	Toast.makeText(getApplicationContext(), "no matching", Toast.LENGTH_SHORT).show();
                	return false;
            	}
//            	Toast.makeText(getApplicationContext(), animal.getName(), Toast.LENGTH_SHORT).show();

            	animalFarm.setImageResource(animal.getImage());
    			testSound(animal.getMp3File());
            }
            return true;
		}
		
	}
	
	// 320 x 480 
	private Animal getAnimal(float x, float y) {
		// Scale x and y to the image
		float scaledX = x * 320 / width;
		float scaledY = y * 480 / height;
				
		for (Animal animal : Animal.values()) {
			Point topLeft = animal.getTopLeft();
			Point btmRight = animal.getBtmRight();
			
			if ((scaledX >= topLeft.x) && (scaledX <= btmRight.x)) {
				if ((scaledY >= topLeft.y) && (scaledY <= btmRight.y)) {
					return animal;
				}
			}
		}
		
		return null;
	}
	
	
	private void testSound(String soundfile) {
		AssetFileDescriptor afd;

		if (oldplayer != null) {
			oldplayer.stop();
		}
		try {
			afd = getAssets().openFd(soundfile);
			MediaPlayer player = new MediaPlayer();
			player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
			player.prepare();

			player.setVolume(1.0f, 1.0f);
			player.start();
			oldplayer = player;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
