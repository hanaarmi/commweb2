package gon.study.springboot.commweb.domain.enums;

public enum BoardType {
    notice("Notice"),
    free("Free Board");

    private String value;

    BoardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
