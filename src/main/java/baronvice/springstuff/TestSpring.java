package baronvice.springstuff;

import baronvice.springstuff.musicplayer.MusicPlayer;
import lombok.SneakyThrows;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @SneakyThrows
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayerBean", MusicPlayer.class);

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
