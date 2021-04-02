package exceptions;

public class DateException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private boolean state;

    public DateException(boolean render) {
        super("Dia y penultimo digito no coinciden segun lineamientos");
        this.state = render;
    }

    public boolean isState() {
        return this.state;
    }

    public boolean getState() {
        return this.state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

}
