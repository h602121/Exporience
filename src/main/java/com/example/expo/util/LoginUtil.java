package com.example.expo.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtil {

    private final static int MAX_INTERACTIVE_INTERVAL = 180;

    public static void loggUtBruker(HttpSession session) {
        session.invalidate();
    }

    public static void loggInnBruker(HttpServletRequest request, int role) {

        loggUtBruker(request.getSession());

        HttpSession session = request.getSession();
        session.setAttribute("expo", 1);
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("role", role);


    }

    public static boolean erBrukerInnlogget(HttpSession session) {

        return session != null
                && session.getAttribute("username") != null;

    }

    public static boolean korrektRolle(HttpSession session, int role) {

        return session.getAttribute("role").equals(role);
    }


}
