package baronvice.springstuff.musicplayer.utilities.interfaces;

import baronvice.springstuff.musicplayer.utilities.Song;

public interface IMusic {
    Song getSong(String name);
    void addSongToCollection(Song song);
    void removeSongFromCollection(String name);
}
