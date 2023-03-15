package baronvice.springstuff.musicplayer.utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Song {
    private String name;
    private String performer;
    private String lyrics;

    public Song (String name, String performer, String lyrics) {
        this.name = name;
        this.performer = performer;
        this.lyrics = lyrics;
    }

    @Override
    public String toString() {
        return String.format(
                """
                        Name: %s
                        Performer: %s
                """, name, performer);
    }
}
