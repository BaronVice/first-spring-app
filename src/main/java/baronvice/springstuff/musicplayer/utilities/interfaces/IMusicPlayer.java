package baronvice.springstuff.musicplayer.utilities.interfaces;

public interface IMusicPlayer {
    void pickGenre(String name);
    void pickSong(String name);
    void playSong();
    void startPlay();
    void pausePlay();
    void continuePlay();
}
