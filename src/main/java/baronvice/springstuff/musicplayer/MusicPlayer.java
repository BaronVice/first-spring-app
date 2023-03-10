package baronvice.springstuff.musicplayer;

/** So concept is: while song is played print lyrics line every second. Probably should do it with threads.
 * When I want it to pause .await() more likely */

public class MusicPlayer implements IMusicPlayer {
    private Music music;
    private Song currentSong;
    public MusicPlayer(Music music){
        this.music = music;
    }

    @Override
    public void playSong(String name) {
        currentSong = music.getSong(name);
        System.out.println(currentSong == null ? "No match" : currentSong);
    }

    @Override
    public void pauseSong() {
        // .await()
    }
}
