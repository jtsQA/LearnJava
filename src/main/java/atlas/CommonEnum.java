package atlas;

public abstract class CommonEnum {
    private final String name;
    private final String series;
    private final String version;
    private final String plan;

    CommonEnum(String name, String series, String version, String plan) {
        this.name = name;
        this.series = series;
        this.version = version;
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public String getSeries() {
        return series;
    }

    public String getVersion() {
        return version;
    }

    public String getPlan() {
        return plan;
    }

    
}
