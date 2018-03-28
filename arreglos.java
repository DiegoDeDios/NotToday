package programacionorientada;
import java.io.File;
import java.util.*;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
public class arreglos extends Application{
	private static Media sound;
	private static MediaPlayer mediaPlayer;
	public static void main(String[] args) {
		arreglos rep= new arreglos();
		rep.reproducir();
	}

	public void reproducir(){
		String musicFile = "18 Last Surprise.mp3";     
		sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setAutoPlay(true);
	}
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

