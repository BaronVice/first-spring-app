package baronvice.springstuff;

import baronvice.springstuff.musicplayer.utilities.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Configuration
@Controller
@ComponentScan("baronvice.springstuff.musicplayer")
@PropertySource("classpath:songs.properties")

public class SpringConfig {
    @Autowired
    Environment environment;

    @Bean
    public Song paradiseCity(@Value("${paradiseCity.name}") String name,
                             @Value("${paradiseCity.performer}") String performer,
                             @Value("${paradiseCity.lyrics}") String lyrics) {

        return new Song(name, performer, lyrics);
    }

    @Bean
    public Song mySacrifice() {
        return new Song(
                "${mySacrifice.name}",
                "${mySacrifice.performer}",
                "${mySacrifice.lyrics}"
        );
    }

    @Bean
    public Song dontStopBelievin() {
        return new Song(
                "${dontStopBelievin.name}",
                "${dontStopBelievin.performer}",
                "${dontStopBelievin.lyrics}"
        );
    }

//    @Bean
//    public Map<String, Song> rockSongs(){
//        return Map.ofEntries(
//                Map.entry(paradiseCity().getName(), paradiseCity()),
//                Map.entry(mySacrifice().getName(), mySacrifice())
//        );
//    }
//
//    @Bean
//    public Map<String, Song> bluesSongs(){
//        return Map.ofEntries(
//                Map.entry(dontStopBelievin().getName(), dontStopBelievin())
//        );
//    }
}
