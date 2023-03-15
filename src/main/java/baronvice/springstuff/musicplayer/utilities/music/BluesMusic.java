package baronvice.springstuff.musicplayer.utilities.music;


import baronvice.springstuff.musicplayer.utilities.Song;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class BluesMusic extends Music {
    public BluesMusic(Map<String, Song> songsCollection) {
        this.songsCollection = songsCollection;
    }
}
