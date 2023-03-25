package baronvice.springstuff;

import baronvice.springstuff.musicplayer.MusicPlayer;
import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestSpring {
    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.pickSong("Paradise City");
        musicPlayer.startPlay();

        Thread.sleep(2000);
        musicPlayer.pausePlay();
        Thread.sleep(2000);
        musicPlayer.continuePlay();

        Thread.sleep(1000);

        musicPlayer.pickSong("My Sacrifice");
        musicPlayer.startPlay();

        context.close();
    }
}
