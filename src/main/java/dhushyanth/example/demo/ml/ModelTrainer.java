package dhushyanth.example.demo.ml;

import dhushyanth.example.demo.util.CSVReader;
import java.util.*;

public class ModelTrainer {

    public static TfIdfVectorizer vectorizer;
    public static LogisticRegression model;

    static {
        try {
            List<String> fake = CSVReader.readCSV("dataset/Fake.csv");
            List<String> real = CSVReader.readCSV("dataset/True.csv");

            List<String> all = new ArrayList<>();
            all.addAll(fake);
            all.addAll(real);

            int[] y = new int[all.size()];
            for (int i = fake.size(); i < y.length; i++)
                y[i] = 1;

            vectorizer = new TfIdfVectorizer();
            double[][] X = vectorizer.fitTransform(all);

            model = new LogisticRegression(X[0].length);
            model.train(X, y, 100);
            System.out.println("Fake news count: " + fake.size());
            System.out.println("Real news count: " + real.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
