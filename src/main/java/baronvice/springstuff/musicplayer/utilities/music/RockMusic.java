package baronvice.springstuff.musicplayer.utilities.music;


import baronvice.springstuff.musicplayer.utilities.Song;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class RockMusic extends Music {
    public RockMusic(Map<String, Song> songsCollection) {
        super(songsCollection);
    }
}
