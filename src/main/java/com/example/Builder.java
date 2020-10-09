package com.example;

import java.util.function.Function;

/**
 * Play with enabling/disabling the @Api annotations here and running again.
 */
public class Builder {

    @Api
    public Builder addOption(String message, Function handler) {
        System.out.println("message = " + message + ", handler = " + handler);
        return this;
    }

//    @Api
    public Builder addOption(String message, int index, Function handler) {
        System.out.println("message = " + message + ", index = " + index + ", handler = " + handler);
        return this;
    }

//    @Api
    public Builder addOption(String message, String voice, String voiceLanguage, Function handler) {
        System.out.println("message = " + message + ", voice = " + voice + ", voiceLanguage = " + voiceLanguage + ", handler = " + handler);
        return this;
    }

//    @Api
    public Builder addOption(String message, String voice, String voiceLanguage, int index, Function handler) {
        System.out.println("message = " + message + ", voice = " + voice + ", voiceLanguage = " + voiceLanguage + ", index = " + index + ", handler = " + handler);
        return this;
    }
}
