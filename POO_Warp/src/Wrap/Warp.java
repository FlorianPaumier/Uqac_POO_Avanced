package Wrap;

import java.util.Date;

public class Warp {

    public String time;
    private static Warp warp;

    private Warp(){
        time = "Créer le " + (new Date()).toString();
    }

    public static Warp getInstance(){
        if (warp == null) warp = new Warp();
        return warp;
    }

    private void getResponseType(){}

}
