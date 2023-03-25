package baronvice.springstuff.musicplayer.utilities.music;


import baronvice.springstuff.musicplayer.utilities.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BluesMusic extends Music {
    @Autowired
    public BluesMusic(@Qualifier("bluesSongs") Map<String, Song> songsCollection) {
        super(songsCollection);
    }
}
