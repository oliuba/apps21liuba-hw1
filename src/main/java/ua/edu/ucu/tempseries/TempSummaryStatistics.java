package ua.edu.ucu.tempseries;

final class TempSummaryStatistics {
    final double avgTemp;
    final double devTemp;
    final double minTemp;
    final double maxTemp;

    public TempSummaryStatistics(double avgTemp,
                                 double devTemp,
                                 double minTemp,
                                 double maxTemp) {
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.maxTemp = minTemp;
        this.minTemp = maxTemp;
    }


    @Override
    public String toString() {
        int twoPointEstimator = 100;
        return "TempSummaryStatistics{"
                + "avgTemp="
                + avgTemp
                + ", devTemp="
                + Math.round(devTemp * twoPointEstimator) / twoPointEstimator
                + ", minTemp="
                + minTemp
                + ", maxTemp="
                + maxTemp
                + '}';
    }
}
