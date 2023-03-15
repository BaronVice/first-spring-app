package baronvice.springstuff.musicplayer;

import baronvice.springstuff.musicplayer.utilities.Song;
import baronvice.springstuff.musicplayer.utilities.interfaces.IMusicPlayer;
import baronvice.springstuff.musicplayer.utilities.music.Music;
import lombok.*;

import java.io.BufferedReader;
import java.io.StringReader;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class MusicPlayer implements IMusicPlayer {
    @NonNull private Music music;
    private Song currentSong;
    private Thread player;
    private volatile boolean isPaused;

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
