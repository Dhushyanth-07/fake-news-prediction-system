package dhushyanth.example.demo.ml;

public class LogisticRegression {

    private final double[] weights;
    private final double lr = 0.01;

    public LogisticRegression(int size) {
        weights = new double[size];
    }

    private double sigmoid(double z) {
        return 1.0 / (1.0 + Math.exp(-z));
    }

    public void train(double[][] X, int[] y, int epochs) {
        for (int e = 0; e < epochs; e++) {
            for (int i = 0; i < X.length; i++) {
                double z = 0;
                for (int j = 0; j < weights.length; j++)
                    z += weights[j] * X[i][j];

                double pred = sigmoid(z);
                for (int j = 0; j < weights.length; j++)
                    weights[j] += lr * (y[i] - pred) * X[i][j];
            }
        }
    }

    public int predict(double[] x) {
        double z = 0;
        for (int i = 0; i < weights.length; i++)
            z += weights[i] * x[i];
        return sigmoid(z) >= 0.5 ? 1 : 0;
    }
}
