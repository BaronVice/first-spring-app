package baronvice.springstuff.musicplayer;

import lombok.SneakyThrows;

/** Concept is: while song is played print lyrics line every second. Probably should do it with threads.
 * When I want it to pause .await() more likely */

public class MusicPlayer implements IMusicPlayer {
    private Music music;
    private Song currentSong;
    private Thread thread;
    public MusicPlayer(Music music){
        this.music = music;
    }

    @Override
    public void playSong(String name) {
        currentSong = music.getSong(name);
        if (currentSong == null){
            System.out.println("No match");
            return;
        }

        thread = new Thread(this::startSong);
    }

    public void startSong(){

    }

    @SneakyThrows
    @Override
    public void pauseSong() {
        thread.wait();
    }

    @Override
    public void continueSong(){
        thread.notifyAll();
    }
}
