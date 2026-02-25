package edu.ieselgrao.javadoc;
import java.time.LocalDate;

public class Atmosphere {
    // Constants for error messages
    public static final String INVALID_COMPOSITION = "[ERROR] Composition cannot be null or empty";
    public static final String INVALID_LAST_OBSERVATION = "[ERROR] Last observation cannot be null or in the future";
    public static final String INVALID_PRESSURE = "[ERROR] Pressure cannot be negative";
    public static final String INVALID_DENSITY = "[ERROR] Density cannot be negative";

    // Attributes
    private String composition;
    private LocalDate lastObservation;
    private int airQuality;
    private double pressure;
    private double density;
    private boolean hasClouds;

    // Constructor
    public Atmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setComposition(composition);
        setLastObservation(lastObservation);
        setAirQuality(airQuality);
        setPressure(pressure);
        setDensity(density);
        setHasClouds(hasClouds);
    }

    // Getters and setters
    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        if (composition == null || composition.trim().isEmpty() || !composition.matches("[a-zA-Z0-9, ]+")) {
            throw new IllegalArgumentException(INVALID_COMPOSITION);
        }
        this.composition = composition;
    }

    public LocalDate getLastObservation() {
        return lastObservation;
    }

    public void setLastObservation(LocalDate lastObservation) {
        // LocalDate.now() can be setted
        if (lastObservation == null || lastObservation.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_LAST_OBSERVATION);
        }
        this.lastObservation = lastObservation;
    }

    public int getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(int airQuality) {
        // Adjust to range [0, 100]
        if (airQuality < 0) {
            this.airQuality = 0;
        } else if (airQuality > 100) {
            this.airQuality = 100;
        } else {
            this.airQuality = airQuality;
        }
    }


    public double getPressure() {
        return pressure;
    }

    /**
     *
     * @param pressure
     */

    public void setPressure(double pressure) {
        if (pressure < 0) {
            throw new IllegalArgumentException(INVALID_PRESSURE);
        }
        this.pressure = pressure;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        if (density < 0) {
            throw new IllegalArgumentException(INVALID_DENSITY);
        }
        this.density = density;
    }
    public boolean hasClouds() {
        return hasClouds;
    }
    public void setHasClouds(boolean hasClouds) {
        this.hasClouds = hasClouds;
    }

}
