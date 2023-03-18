package baronvice.springstuff;

import baronvice.springstuff.musicplayer.MusicPlayer;
import baronvice.springstuff.musicplayer.utilities.Song;
import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;


public class TestSpring {
    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        Song song = context.getBean("paradiseCity", Song.class);
        System.out.println(song);
        System.out.printf(song.getLyrics());


//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        musicPlayer.pickSong("Paradise City");
//        System.out.println(musicPlayer.getCurrentSong());
//        musicPlayer.startPlay();
//
//        Thread.sleep(2000);
//        musicPlayer.pausePlay();
//        Thread.sleep(2000);
//        musicPlayer.continuePlay();
//
//        Thread.sleep(1000);
//
//        musicPlayer.pickSong("My Sacrifice");
//        musicPlayer.startPlay();

        context.close();
    }
}
