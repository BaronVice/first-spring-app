package baronvice.springstuff.musicplayer;

import java.util.HashMap;

public class RockMusic implements IMusic {

    private HashMap<String, Song> songs;

    public RockMusic(){
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
