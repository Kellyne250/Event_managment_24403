package peter.student.services;

import peter.student.model.Event;
import peter.student.model.Signup;

import java.util.List;

public interface SignupInterface {
    public Signup saveAccount(Signup signup);
    public Signup findAccount(String email);
    public List<Event> getAllEvent();

}
