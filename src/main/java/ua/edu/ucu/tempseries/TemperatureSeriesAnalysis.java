package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[]{};
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        checkSeriesIsValid(temperatureSeries);
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
    }

    public void checkSeriesIsValid(double[] temperatureSeries) {
        for (double temp: temperatureSeries) {
            if (temp < -273) {
                throw new InputMismatchException();
            }
        }
    }

    public void checkEmptySeries() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double average() {
        checkEmptySeries();
        double tempSum = 0;
        for (double temp: temperatureSeries) {
            tempSum += temp;
        }
        return tempSum / temperatureSeries.length;
    }

    public double deviation() {
        checkEmptySeries();
        double quadraticSum = 0;
        double mean = average();
        for (double temp: temperatureSeries) {
            quadraticSum += Math.pow(temp-mean, 2);
        }
        return Math.sqrt(quadraticSum / temperatureSeries.length);
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
        checkEmptySeries();
        double minDiff = Double.POSITIVE_INFINITY;
        double closestValue = temperatureSeries[0];
        for (double temp: temperatureSeries) {
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
