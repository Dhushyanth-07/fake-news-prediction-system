package dhushyanth.example.demo.ml;

public class TfIdfVectorizer {

    // FIXED FEATURE SIZE (controls memory)
    private static final int FEATURES = 3000;

    public double[][] fitTransform(java.util.List<String> docs) {
        double[][] X = new double[docs.size()][FEATURES];

        for (int i = 0; i < docs.size(); i++) {
            String[] words = docs.get(i).split("\\s+");

            for (String word : words) {
                int index = Math.abs(word.hashCode()) % FEATURES;
                X[i][index]++;
            }
        }
        return X;
    }

    public double[] transform(String text) {
        double[] vec = new double[FEATURES];
        String[] words = text.toLowerCase().split("\\s+");

        for (String word : words) {
            int index = Math.abs(word.hashCode()) % FEATURES;
            vec[index]++;
        }
        return vec;
    }
}