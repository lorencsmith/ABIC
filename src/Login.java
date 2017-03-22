/**
 *
 */
public class Login {

    /**
     * userName is assumed to be unique.
     * userName is assumed to be any string within (...) range
     */
    private String userName;
    /**
     * hashedPassword is assumed to contain at least one uppercase letter and at least one number and alphabet
     */
    private String hashedPassword;

    private int numOfLoginAttemps;
    private boolean canLogin;

    private final int MAX_NUM_OF_LOGIN_ATTEMPTS = 5;

    public void requestNewPassword(){

    };

    public boolean accountLocked(){
        return canLogin;
    };

    public static void main(String[] args) {
        System.out.println("hello world!");
    }
}
