package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // expect exception here
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.741657;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindClosestToZero() {
        // setup input data and expected result
        double[] temperatureSeries = {-0.2, 0.2, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.2;
        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();
        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToValue(1.0);
    }

    @Test
    public void testMin() {
        // setup input data and expected result
        double[] temperatureSeries = {0.1, -10.0, -0.2, 0.2, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -10.0;
        // call tested method
        double actualResult = seriesAnalysis.min();
        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
    }

    @Test
    public void testMax() {
        // setup input data and expected result
        double[] temperatureSeries = {0.1, -10.0, 100.0, -0.2, 0.2, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 100.0;
        // call tested method
        double actualResult = seriesAnalysis.max();
        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.max();
    }

    @Test
    public void testFindTempsLessEmpty() {
        // setup input data and expected result
        double[] temperatureSeries = {0.1, -10.0, 100.0, -0.2, 0.2, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(-20.0);
        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessNormal() {
        // setup input data and expected result
        double[] temperatureSeries = {0.1, -10.0, 100.0, -0.2, 0.2, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {0.1, -10.0, -0.2, 0.2, -0.2};
        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(20.0);
        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterEmpty() {
        // setup input data and expected result
        double[] temperatureSeries = {0.1, -10.0, 100.0, -0.2, 0.2, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(200.0);
        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterNormal() {
        // setup input data and expected result
        double[] temperatureSeries = {0.1, -10.0, 100.0, -0.2, 0.2, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {100.0};
        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(20.0);
        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testSummaryStatistics() {
        // setup input data and expected result
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics expected = new TempSummaryStatistics(1.0, 3.741657, -5.0, 5.0);
        // call tested method
        TempSummaryStatistics actual = seriesAnalysis.summaryStatistics();
        // compare expected result with actual result
        String expString = expected.toString();
        String actualString = actual.toString();
        assertEquals(expString, actualString);
    }

    @Test
    public void testAddTempsEmpty() {
        // setup input data and expected result
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        // call tested method
        int numTemps = seriesAnalysis.addTemps(1.0, 2.0);
        // compare expected result with actual result
        double[] expectedArray = {1.0, 2.0};
        double[] actualArray = seriesAnalysis.getTemperatureSeries();
        assertArrayEquals(expectedArray, actualArray, 0.00001);
        assertEquals(numTemps, 2);
    }

    @Test
    public void testAddTempsNormal() {
        // setup input data and expected result
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // call tested method
        int numTemps = seriesAnalysis.addTemps(1.0, 2.0);
        // compare expected result with actual result
        double[] expectedArray = {3.0, -5.0, 1.0, 5.0, 1.0, 2.0, 0, 0};
        double[] actualArray = seriesAnalysis.getTemperatureSeries();
        assertArrayEquals(expectedArray, actualArray, 0.00001);
        assertEquals(numTemps, 6);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddImpossibleTemps() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        // expect exception here
        seriesAnalysis.addTemps(100.0, -300.0);
    }
}
