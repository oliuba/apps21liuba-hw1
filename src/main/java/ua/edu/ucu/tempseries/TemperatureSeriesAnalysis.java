package ua.edu.ucu.tempseries;

import java.util.Arrays;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[]{};
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        checkSeriesIsValid();
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
    }

    public void checkSeriesIsValid() {
        // exception check
    }

    public double average() {
        return -1;
    }

    public double deviation() {
        return 0;
    }

    public double min() {
        return findTempClosestToValue(Double.NEGATIVE_INFINITY);
    }

    public double max() {
        return findTempClosestToValue(Double.POSITIVE_INFINITY);
    }

    public double findTempClosestToZero() throws IllegalArgumentException {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double minDiff = Double.POSITIVE_INFINITY;
        double closestValue = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            if (Math.abs(temp - tempValue) < minDiff) {
                closestValue = temp;
                minDiff = Math.abs(closestValue - tempValue);
            }
            if (temp > 0 && Math.abs(temp - tempValue) == minDiff) {
                closestValue = temp;
                minDiff = Math.abs(closestValue - tempValue);
            }
        }
        return closestValue;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
