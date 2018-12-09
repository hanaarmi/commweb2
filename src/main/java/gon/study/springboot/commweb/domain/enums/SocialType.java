package gon.study.springboot.commweb.domain.enums;

public enum SocialType {
    GOOGLE("google"),
    KAKAO("kakao"),
    FACEBOOK("facebook");

    private final String ROLE_PREFIX = "ROLE_";
    private String name;

    SocialType(String name) {
        this.name = name;
    }

    public String getRoleType() {
        return ROLE_PREFIX + name.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public boolean isEquals(String authority) {
        return this.name.equals(authority);
    }
}
