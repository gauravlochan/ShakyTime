package com.tochanshashank.shakytime;

import android.graphics.Point;

//pig: 114,11: 210, 114
//dog: 5, 131: 107, 225
//duck: 18, 251: 96,345
//horse: 121, 365: 200, 458
//sheep: 215, 250: 305, 345
//cat: 220, 131: 303, 226

public enum Animal {
	PIG {
		public String getName() { return "pig"; }
		public int getImage() { return R.drawable.pig_highlight; }
		public Point getTopLeft()  { return new Point(114, 11); }
		public Point getBtmRight() { return new Point(210, 114); }
	},
	DOG {
		public String getName() { return "dog"; }
		public int getImage() { return R.drawable.dog_highlight; }
		public Point getTopLeft()  { return new Point(5, 131); }
		public Point getBtmRight() { return new Point(107, 225); }
	},
	DUCK {
		public String getName() { return "duck"; }
		public int getImage() { return R.drawable.duck_highlight; }
		public Point getTopLeft()  { return new Point(18, 251); }
		public Point getBtmRight() { return new Point(96, 345); }
	},
	HORSE {
		public String getName() { return "horse"; }
		public int getImage() { return R.drawable.horse_highlight; }
		public Point getTopLeft()  { return new Point(121, 365); }
		public Point getBtmRight() { return new Point(200, 458); }
	},
	SHEEP {
		public String getName() { return "sheep"; }
		public int getImage() { return R.drawable.sheep_highlight; }
		public Point getTopLeft()  { return new Point(215, 250); }
		public Point getBtmRight() { return new Point(305, 345); }
	},
	CAT {
		public String getName() { return "cat"; }
		public int getImage() { return R.drawable.cat_highlight; }
		public Point getTopLeft()  { return new Point(220, 131); }
		public Point getBtmRight() { return new Point(303, 226); }
	};
	
	public String getName() {
		return "";
	}
	public Point getTopLeft() {
		return null;
	}
	public Point getBtmRight() {
		return null;
	}
	public String getMp3File() {
		return "sounds/" + getName() + ".mp3"; 
	}
	public int getImage() {
		return 0;
	}

}
