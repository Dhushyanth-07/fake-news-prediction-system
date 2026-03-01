package dhushyanth.example.demo.controller;

import dhushyanth.example.demo.ml.ModelTrainer;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PredictController {

    @GetMapping("/")
    public String home() {
        return "Fake News Prediction Backend Running";
    }

    @PostMapping("/predict")
    public String predict(@RequestBody String text) {

        if (text == null || text.trim().length() < 150) {
            return "Enter detailed news text (minimum 150 characters) for accurate prediction.";
        }

        String lower = text.toLowerCase();

        String[] fakeTriggers = {
                "shocking", "secret", "exposed", "revealed", "miracle","Unbelievable","Share before it’s deleted",
                "instantly", "cures", "guaranteed", "you won’t believe","Amazing","amazing!!",
                "Oh my god","ohhh my god!!!","!!","over night",
                "doctors hate", "what happens next", "gone viral",
                "breaking truth", "hidden truth", "one simple trick",
                "scientists prove", "banned video", "before it’s deleted",
                "wake up people", "big pharma", "media won’t tell"
        };

        for (String trigger : fakeTriggers) {
            if (lower.contains(trigger)) {
                return "FAKE NEWS";
            }
        }

        // ML prediction (fallback)
        double[] vector = ModelTrainer.vectorizer.transform(text);
        int prediction = ModelTrainer.model.predict(vector);

        return prediction == 1 ? "REAL NEWS" : "FAKE NEWS";
    }
}
