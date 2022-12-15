package ru.intelogis.auth.data;

import lombok.Value;

public class DataGenerator {
    private DataGenerator() {
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getValidAuthInfo() {
        return new AuthInfo("rekame2869@seinfaq.com", "XRCa91zn4fsJzcHW");
    }

    public static AuthInfo getInvalidLogin() {
        return new AuthInfo("rekame2869@seinfaq", "XRCa91zn4fsJzcHW");
    }

    public static AuthInfo getInvalidPassword() {
        return new AuthInfo("rekame2869@seinfaq.com", "XRCa91zn4fsJzc");
    }
}

