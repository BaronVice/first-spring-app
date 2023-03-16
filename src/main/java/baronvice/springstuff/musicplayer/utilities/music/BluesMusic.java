package baronvice.springstuff.musicplayer.utilities.music;


import baronvice.springstuff.musicplayer.utilities.Song;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BluesMusic extends Music {
    @Autowired
    public BluesMusic(Map<String, Song> songsCollection) {
        super(songsCollection);
    }
}
