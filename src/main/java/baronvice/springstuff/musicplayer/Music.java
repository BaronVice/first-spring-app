package baronvice.springstuff.musicplayer;

import java.util.HashMap;

public abstract class Music implements IMusic {

    protected HashMap<String, Song> songs;

    public Music(){
        songs = new HashMap<>();
    }

    @Override
    public Song getSong(String name) {
        return songs.get(name);
    }

    @Override
    public void putInsideCollection(Song song) {
        songs.put(song.getName(), song);
    }

    @Override
    public String toString() {
        return "Rock";
    }
}