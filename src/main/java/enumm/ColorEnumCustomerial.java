package enumm;

public enum ColorEnumCustomerial {
    RED("红色"), BLUE("蓝色"), GREEN("绿色");
    private final String value;

    ColorEnumCustomerial(String value) {
        this.value = value;
    }

    public String getColor() {
        return value;
    }
}
