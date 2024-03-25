import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class soratraController {

    private final soratraService service;

    @Autowired
    public PoeticPhraseController(PoeticPhraseService service) {
        this.service = service;
    }

    @PutMapping("/soratra/{id}")
    public ResponseEntity<Void> putPoeticPhrase(@PathVariable String id, @RequestBody Map<String, String> requestBody) {
        String phrase = requestBody.get("phrase");
        if (phrase == null) {
            return ResponseEntity.badRequest().build(); 
        }

        service.savePoeticPhrase(id, phrase);

        return ResponseEntity.ok().build(); 
    }

    @GetMapping("/soratra/{id}")
    public ResponseEntity<Map<String, String>> getPoeticPhrase(@PathVariable String id) {
        String phrase = service.getPoeticPhrase(id);
        if (phrase == null) {
            return ResponseEntity.notFound().build(); 
        }

        String originalUrl = "https://original.url/" + id;
        String transformedUrl = "https://transformed.url/" + id;

        Map<String, String> responseBody = Map.of(
                "original_url", originalUrl,
                "transformed_url", transformedUrl
        );

        return ResponseEntity.ok(responseBody);
    }
}
