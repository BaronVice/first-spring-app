package baronvice.springstuff.musicplayer.utilities.music;

import baronvice.springstuff.musicplayer.utilities.Song;
import baronvice.springstuff.musicplayer.utilities.interfaces.IMusic;

import java.util.HashMap;

public abstract class Music implements IMusic {

    protected HashMap<String, Song> songsCollection;

    public Music(){
        songsCollection = new HashMap<>();
    }

    @Override
    public Song getSong(String name) {
        return songsCollection.get(name);
    }

    @Override
    public void addSongToCollection(Song song) {
        songsCollection.put(song.getName(), song);
    }

    @Override
    public void removeSongFromCollection(String name) {
        songsCollection.remove(name);
    }
}