import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class soratraService {
    private final soratraRepository repository;

    @Autowired
    public PoeticPhraseService(PoeticPhraseRepository repository) {
        this.repository = repository;
    }

    public void savePoeticPhrase(String id, String phrase) {
        repository.savePoeticPhrase(id, phrase.toLowerCase());
    }

    public String getPoeticPhrase(String id) {
        return repository.getPoeticPhrase(id);
    }
}
