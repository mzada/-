package com.my.barrage_unite;


public class Main {
	public static String floder = "C:\\live stream\\utils\\ffmpeg\\bin";
	
	public static String cmdPath = "C:\\live stream\\utils\\ffmpeg\\bin";
	
	public static void main(String[] args) {
		int tot;
		tot = new ChangeName().changeName(floder);
		new Cmd().unite(cmdPath, tot);
	}
} 