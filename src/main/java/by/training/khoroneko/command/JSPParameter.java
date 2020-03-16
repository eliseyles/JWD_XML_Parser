package by.training.khoroneko.command;

public enum JSPParameter {
    COMMAND("command"),
    FILE("file");

    private String value;

    JSPParameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
