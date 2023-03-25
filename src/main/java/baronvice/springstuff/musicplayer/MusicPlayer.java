package baronvice.springstuff.musicplayer;

import baronvice.springstuff.musicplayer.utilities.Song;
import baronvice.springstuff.musicplayer.utilities.interfaces.IMusicPlayer;
import baronvice.springstuff.musicplayer.utilities.music.Music;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.StringReader;


@Component
@Scope("prototype")
@Getter
@Setter
public class MusicPlayer implements IMusicPlayer {
    @Qualifier("rockMusic")
    @NonNull private Music music;
    private Song currentSong;
    private Thread player;
    private volatile boolean isPaused;

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") @NonNull Music music) {
        this.music = music;
    }

    @PostConstruct
    private void sendStartMessage(){
        System.out.println("*Weird machine sounds*");
    }

    @Override
    public void pickSong(String name) {
        Song nextSong = music.getSong(name);
        if (nextSong == null)
            return;

        if (player != null)
            resetSong();

        currentSong = nextSong;
        System.out.printf("--- New song selected. %s - %s ---%n",
                currentSong.getPerformer(), currentSong.getName());

        player = new Thread(this::playSong);

    }

    @Override
    public void startPlay() {
        System.out.println("--- Play ---");
        player.start();
    }

    @Override
    public void playSong() {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(String.format(currentSong.getLyrics())));
        for (String line : bufferedReader.lines().toList()){
            try {
                printLine(line);
            }
            catch (InterruptedException e){
                return;
            }
        }

    }

    private void printLine(String line) throws InterruptedException {

        while (isPaused) {
            Thread.onSpinWait();
        }

        if (player.isInterrupted())
            throw new InterruptedException();

        System.out.println(line);
        Thread.sleep(1000);
    }

    private void resetSong() {
        player.interrupt();
        isPaused = false;
    }

    @Override
    public void pausePlay() {
        System.out.println("--- Pause ---");
        isPaused = true;
    }

    @Override
    public void continuePlay() {
        System.out.println("--- Continue ---");
        isPaused = false;
    }
}
