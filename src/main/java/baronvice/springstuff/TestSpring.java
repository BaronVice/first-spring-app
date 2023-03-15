package baronvice.springstuff;

import baronvice.springstuff.musicplayer.MusicPlayer;
import baronvice.springstuff.musicplayer.utilities.Song;
import lombok.SneakyThrows;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @SneakyThrows
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        // That's how we can take bean (first arg - bean id, second arg - class name)
        // Music music = context.getBean("musicBean", Music.class);
        // MusicPlayer musicPlayer = new MusicPlayer(music);

        // Hell yeah!!! Now I don't need to create Music manually - Spring does it by itself!
        // Just need to set reference (ref) inside context, that's all!
        MusicPlayer musicPlayer = context.getBean("musicPlayerBean", MusicPlayer.class);

        musicPlayer.getMusic().addSongToCollection(context.getBean("paradiseCityBean", Song.class));
        musicPlayer.getMusic().addSongToCollection(context.getBean("dontStopBelievinBean", Song.class));

        musicPlayer.pickSong("Paradise City");
        musicPlayer.startPlay();

        Thread.sleep(4000);
        musicPlayer.pausePlay();

        Thread.sleep(3000);

        musicPlayer.pickSong("Don't Stop Believin");
        musicPlayer.startPlay();

//        musicPlayer.continuePlay();

        // After you've finished with application context it should be closed
        context.close();
    }
}
