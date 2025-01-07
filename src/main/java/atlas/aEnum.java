package atlas;

public enum aEnum {

    A_ONE("Atlas One", "One Standard", "1", "Standard"),
    A_TWO("Atlas Two", "Two Standard", "2", "Standard"),
    A_THREE("Atlas Three", "Three Standard", "3", "Premium");

    private final String name;
    private final String series;
    private final String version;
    private final String plan;

    aEnum(String name, String series, String version, String plan) {
        this.name = name;
        this.series = series;
        this.version = version;
        this.plan = plan;
    }

    public boolean isPartOfA() {
        switch (this) {
            case A_ONE:
            case A_TWO:
            case A_THREE:
                return true;
            default:
                return false;
        }
    }

}
