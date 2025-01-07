package atlas;

public enum bEnum {

    B_ONE("Buss One", "One Standard", "1", "Standard"),
    B_TWO("Buss Two", "Two Standard", "2", "Standard"),
    B_THREE("Buss Three", "Three Standard", "3", "Premium");

    private final String name;
    private final String series;
    private final String version;
    private final String plan;

    bEnum(String name, String series, String version, String plan) {
        this.name = name;
        this.series = series;
        this.version = version;
        this.plan = plan;
    }

    public boolean isPartOfB() {
        switch (this) {
            case B_ONE:
            case B_TWO:
            case B_THREE:
                return true;
            default:
                return false;
        }
    }

}
