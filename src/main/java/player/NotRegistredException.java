package player;

public class NotRegistredException extends RuntimeException {
    public NotRegistredException (String name) {
        super ("Player" + name + "не зарегистрирован");
    }

}
