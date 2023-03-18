package baronvice.springstuff.musicplayer.utilities.music;

import baronvice.springstuff.musicplayer.utilities.Song;
import baronvice.springstuff.musicplayer.utilities.interfaces.IMusic;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.TreeMap;

@NoArgsConstructor
@AllArgsConstructor
public abstract class Music implements IMusic {

    protected Map<String, Song> songsCollection = new TreeMap<>();

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