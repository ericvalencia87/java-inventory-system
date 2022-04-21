package com.tesda;

import com.tesda.models.User;
import com.tesda.views.LoginView;
import com.tesda.views.MainView;

public class Main {

    public static void main(String[] args) {

        /* The login view is the first window to appear in our application
        *  before the user can use the system, the user must be authenticated first */
        LoginView loginView = new LoginView();

        //Show the login screen
        loginView.setVisible(true);

        //Pinag iisipan ko kung si Login View ang Mag open ng Main Screen or dito.

    }
}
