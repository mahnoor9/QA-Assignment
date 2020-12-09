package constants;

import java.io.IOException;

import static utils.ReadWriteFileData.ReadFile;

public class Constants {
    public static String postFlyerAppLink;
    public static String googleLink;
    public static String IMBdLink;
    public static String postLoginURL;
    public static String postLoginPayload;
    public static String postLoginTime;
    public static String postLoginSize;
    public static String postSignUpURL;
    public static String postSignUpPayload;
    public static String postSignUpTime;
    public static String postSignUpSize;


    static {
        try {

            googleLink="www.google.com";
            postFlyerAppLink= "https://emumba-test.herokuapp.com/";
            IMBdLink= "https://www.imdb.com/title/tt8398600/";
            postLoginURL= ReadFile( 4,0,1);
            postLoginPayload= ReadFile( 4,2,1);
            postLoginTime= ReadFile (4,4,1);
            postLoginSize= ReadFile (4,5,1);
            postSignUpURL= ReadFile( 3,0,1);
            postSignUpPayload= ReadFile( 3,2,1);
            postSignUpTime= ReadFile (4,4,1);
            postSignUpSize= ReadFile (3,5,1);



        } catch (IOException e) {
            e.printStackTrace ();
        }
    }




}
