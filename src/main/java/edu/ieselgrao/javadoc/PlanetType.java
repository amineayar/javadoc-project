package edu.ieselgrao.javadoc;

public enum PlanetType {
    //ROCKY, GAS_GIANT, ICE_GIANT;
    ROCKY("Rocky Planet", 15.0, 1000.0, 300.0),
    GAS_GIANT("Gas Giant", 50.0, 3000.0, -150.0),
    ICE_GIANT("Ice Giant", 40.0, 5000.0, -200.0);

    private final String description;
    private final double magneticFieldStrength;
    private final double averageDistanceFromStar;
    private final double averageTemperature;

    PlanetType(String description, double magneticFieldStrength, double averageDistanceFromStar, double averageTemperature) {
        this.description = description;
        this.magneticFieldStrength = magneticFieldStrength;
        this.averageDistanceFromStar = averageDistanceFromStar;
        this.averageTemperature = averageTemperature;
    }

    public String getDescription(){
        return description;
    }
    public double getMagneticFieldStrength(){
        return magneticFieldStrength;
    }
    public double getAverageDistanceFromStar(){
        return averageDistanceFromStar;
    }
    public double getAverageTemperature(){
        return averageTemperature;
    }
    public static PlanetType getType(String description){
        for(PlanetType type : PlanetType.values()){
            if(type.description.equals(description)){
                return type;
            }
        }
        return null;
    }
    public PlanetType getNextExpectedType(){
        PlanetType nextType = switch (this) {
            case ROCKY -> PlanetType.GAS_GIANT;
            case GAS_GIANT -> PlanetType.ICE_GIANT;
            case ICE_GIANT -> PlanetType.ROCKY;
        };
        return nextType;
    }



}
