import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class soratraRepository {
    private final Map<String, String> poeticPhrases = new HashMap<>();

    public void savePoeticPhrase(String id, String phrase) {
        poeticPhrases.put(id, phrase);
    }

    public String getPoeticPhrase(String id) {
        return poeticPhrases.get(id);
    }
}

