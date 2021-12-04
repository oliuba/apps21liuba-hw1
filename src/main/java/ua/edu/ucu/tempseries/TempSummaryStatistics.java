package ua.edu.ucu.tempseries;

final class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

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
        final int twoPointEstimator = 100;
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
