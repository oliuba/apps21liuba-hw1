package ua.edu.ucu.tempseries;

final public class TempSummaryStatistics {
    final private double avgTemp;
    final private double devTemp;
    final private double minTemp;
    final private double maxTemp;

    public TempSummaryStatistics(double avgTemp, double devTemp, double minTemp, double maxTemp) {
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.maxTemp = minTemp;
        this.minTemp = maxTemp;
    }


    @Override
    public String toString() {
        return "TempSummaryStatistics{" +
                "avgTemp=" + avgTemp +
                ", devTemp=" + Math.round(devTemp * 100.0) / 100.0 +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                '}';
    }
}
