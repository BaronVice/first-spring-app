package baronvice.springstuff;

import baronvice.springstuff.musicplayer.MusicPlayer;
import baronvice.springstuff.musicplayer.utilities.Song;
import baronvice.springstuff.musicplayer.utilities.music.Music;
import lombok.SneakyThrows;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @SneakyThrows
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        // That's how we can take bean (first arg - bean id, second arg - class name)
        Music music = context.getBean("musicBean", Music.class);

        MusicPlayer musicPlayer = new MusicPlayer(music);

        music.addSongToCollection(new Song("Big Bobby", "Bobby",
                "Well that Bob\nIs a big Boy\nThe end", music));

        musicPlayer.pickSong("Big Bobby");
        musicPlayer.startPlay();

        Thread.sleep(1500);

        musicPlayer.pausePlay();

        Thread.sleep(2500);

        musicPlayer.continuePlay();

        // After you've finished with application context it should be closed
        context.close();
    }
}
