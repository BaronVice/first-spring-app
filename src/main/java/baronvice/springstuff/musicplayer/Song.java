package baronvice.springstuff.musicplayer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Song {
    private String name;
    private String performer;
    private String lyrics;
    private IMusic genre;

    public Song (String name, String performer, String lyrics, IMusic genre) {
        this.name = name;
        this.performer = performer;
        this.lyrics = lyrics;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format(
                """
                        Name: %s
                        Performer: %s
                        Genre: %s
                """, name, performer, genre);
    }
}
