package ua.edu.ucu.tempseries;

import lombok.Getter;

import java.util.Arrays;
import java.util.InputMismatchException;

@Getter
public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    private int numTemps;
    private final int lowestTemp = -273;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[]{};
        this.numTemps = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        checkSeriesIsValid(temperatureSeries);
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, +
                temperatureSeries.length);
        this.numTemps = temperatureSeries.length;
    }

    public void checkSeriesIsValid(double[] series) {
        for (double temp: series) {
            if (temp < lowestTemp) {
                throw new InputMismatchException();
            }
        }
    }

    public void checkEmptySeries() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    private double tempSum() {
        checkEmptySeries();
        double tempSum = 0;
        for (double temp: temperatureSeries) {
            tempSum += temp;
        }
        return tempSum;
    }

    public double average() {
        double tempSum = tempSum();
        return tempSum / numTemps;
    }

    public double deviation() {
        checkEmptySeries();
        double quadraticSum = 0;
        double mean = average();
        for (int i = 0; i < numTemps; i++) {
            quadraticSum += (temperatureSeries[i]-mean)
                    * (temperatureSeries[i]-mean);
        }
        return Math.sqrt(quadraticSum / numTemps);
    }

    public double min() {
        return findTempClosestToValue(lowestTemp);
    }

    public double max() {
        checkEmptySeries();
        double currMax = temperatureSeries[0];
        for (int i = 1; i < numTemps; i++) {
            if (temperatureSeries[i] > currMax) {
                currMax = temperatureSeries[i];
            }
        }
        return currMax;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        checkEmptySeries();
        double minDiff = Double.POSITIVE_INFINITY;
        double closestValue = temperatureSeries[0];
        for (int i = 0; i < numTemps; i++) {
            if (Math.abs(temperatureSeries[i] - tempValue) < minDiff) {
                closestValue = temperatureSeries[i];
                minDiff = Math.abs(closestValue - tempValue);
            }
            if (temperatureSeries[i] > 0
                    && Math.abs(temperatureSeries[i] - tempValue) == minDiff) {
                closestValue = temperatureSeries[i];
                minDiff = Math.abs(closestValue - tempValue);
            }
        }
        return closestValue;
    }


    public double[] findTempsCondition(double tempValue, boolean less) {
        int size = 0;
        for (int i = 0; i < numTemps; i++) {
            if ((temperatureSeries[i] < tempValue && less)
                    || (temperatureSeries[i] >= tempValue && !less)) {
                size++;
            }
        }
        double[] tempsCondition = new double[size];
        int counter = 0;
        for (int i = 0; i < numTemps; i++) {
            if ((temperatureSeries[i] < tempValue && less)
                    || (temperatureSeries[i] >= tempValue && !less)) {
                tempsCondition[counter] = temperatureSeries[i];
                counter++;
            }
        }
        return tempsCondition;
    }


    public double[] findTempsLessThen(double tempValue) {
        return findTempsCondition(tempValue, true);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return findTempsCondition(tempValue, false);
    }

    public TempSummaryStatistics summaryStatistics() {
        checkEmptySeries();
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        checkSeriesIsValid(temps);
        int newNumTemps = numTemps;
        if (temperatureSeries.length == 0) {
            this.temperatureSeries = temps;
            newNumTemps += temps.length;
        } else {
            if (temps.length + numTemps > temperatureSeries.length) {
                this.temperatureSeries = Arrays.copyOf(temperatureSeries,
                        2 * temperatureSeries.length);
            }
            for (int i = 0; i < temps.length
                    && temperatureSeries.length > numTemps + i; i++) {
                temperatureSeries[numTemps + i] = temps[i];
                newNumTemps++;
            }
        }
        this.numTemps = newNumTemps;
        return numTemps;
    }
}
