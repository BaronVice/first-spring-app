package baronvice.springstuff.musicplayer;

public interface IMusic {
    Song getSong(String name);
    void putInsideCollection(Song song);
}
