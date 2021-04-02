package exceptions;

public class UnderAgeException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UnderAgeException() {
        super("Eres menor de edad, no puedes ingresar.");
    }
}
