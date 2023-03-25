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
                environment.getProperty("paradise-city.name"),
                environment.getProperty("paradise-city.performer"),
                environment.getProperty("paradise-city.lyrics")
        );
    }

    @Bean
    public Song mySacrifice() {
        return new Song(
                environment.getProperty("my-sacrifice.name"),
                environment.getProperty("my-sacrifice.performer"),
                environment.getProperty("my-sacrifice.lyrics")
        );
    }

    @Bean
    public Song dontStopBelievin() {
        return new Song(
                environment.getProperty("dont-stop-believin.name"),
                environment.getProperty("dont-stop-believin.performer"),
                environment.getProperty("dont-stop-believin.lyrics")
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
