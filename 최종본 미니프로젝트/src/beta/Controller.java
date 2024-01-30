package beta;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class Controller {
	MP3Player mp3 = new MP3Player();

	MP3Player mp3_2 = new MP3Player();
	public void musicPlay(int index, ArrayList<Music> mL) {

		mp3.play(mL.get(index).getPath());
	}
	
	public void musicPlay2(int index, ArrayList<Music> mL) {

		mp3_2.play(mL.get(index).getPath());
	}
}
