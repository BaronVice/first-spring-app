package baronvice.springstuff;

import baronvice.springstuff.musicplayer.utilities.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Map;

@Configuration
@ComponentScan("baronvice.springstuff.musicplayer")
@PropertySource("classpath:songs.properties")
public class SpringConfig {
    @Autowired
    Environment environment;

    @Bean
    public Song paradiseCity() {
        return new Song(
                environment.getProperty("paradiseCity.name"),
                environment.getProperty("paradiseCity.performer"),
                environment.getProperty("paradiseCity.lyrics")
        );
    }

    @Bean
    public Song mySacrifice() {
        return new Song(
                environment.getProperty("mySacrifice.name"),
                environment.getProperty("mySacrifice.performer"),
                environment.getProperty("mySacrifice.lyrics")
        );
    }

    @Bean
    public Song dontStopBelievin() {
        return new Song(
                environment.getProperty("dontStopBelievin.name"),
                environment.getProperty("dontStopBelievin.performer"),
                environment.getProperty("dontStopBelievin.lyrics")
        );
    }

    @Bean
    public Map<String, Song> rockSongs(){
        return Map.ofEntries(
                Map.entry(paradiseCity().getName(), paradiseCity()),
                Map.entry(mySacrifice().getName(), mySacrifice())
        );
    }

    @Bean
    public Map<String, Song> bluesSongs(){
        return Map.ofEntries(
                Map.entry(dontStopBelievin().getName(), dontStopBelievin())
        );
    }
}
