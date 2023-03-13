package baronvice.springstuff.musicplayer;

import baronvice.springstuff.musicplayer.utilities.Song;
import baronvice.springstuff.musicplayer.utilities.interfaces.IMusicPlayer;
import baronvice.springstuff.musicplayer.utilities.music.Music;


public class MusicPlayer implements IMusicPlayer {
    private Music music;
    private Song currentSong;
    private Thread player;
    public MusicPlayer(Music music){
        this.music = music;
    }

    @Override
    public void pickSong(String name) {
        Song nextSong = music.getSong(name);
        if (nextSong == null)
            return;

        resetSong();
        System.out.println(String.format("New song selected. %s - %s",
                currentSong.getPerformer(), currentSong.getName()));
        player = new Thread(this::playSong);
    }

    @Override
    public void startPlay() {
        player.start();
    }

    @Override
    public void playSong() {
        currentSong.getLyrics().lines().forEach(this::printLine);
    }

    private void printLine(String line){
        System.out.println(line);
        try {
            this.wait(1000);
        } catch (InterruptedException ignored) {

        }
    }

    private void resetSong() {
        player.interrupt();
    }

    @Override
    public void pausePlay() {
        try {
            System.out.println("Paused.");
            player.wait();
        } catch (InterruptedException ignored) {

        }
    }

    @Override
    public void continuePlay() {
        System.out.println("Continued.");
        player.notify();
    }
}
