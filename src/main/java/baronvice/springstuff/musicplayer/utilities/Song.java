package baronvice.springstuff.musicplayer.utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    private String name;

    private String performer;

    private String lyrics;

    @Override
    public String toString() {
        return String.format(
                """
                Name: %s
                Performer: %s
                """, name, performer);
    }
}
