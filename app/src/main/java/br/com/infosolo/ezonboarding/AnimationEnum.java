package br.com.infosolo.ezonboarding;

/**
 * Created by mateus brandão on 8/13/2015.
 */
public enum AnimationEnum {
    Animation1("1"), Animation2("2"), Animation3("3");

    private final String value;

    AnimationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
