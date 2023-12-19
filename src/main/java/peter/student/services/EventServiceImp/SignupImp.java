package peter.student.services.EventServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peter.student.model.Event;
import peter.student.model.Signup;
import peter.student.repository.EventRepository;
import peter.student.repository.SignupRepository;
import peter.student.services.SignupInterface;

import java.util.List;

@Service
public class SignupImp implements SignupInterface {

  private SignupRepository signupRepository;
  private EventRepository eventRepository;

  @Autowired
  public SignupImp(SignupRepository signupRepository, EventRepository eventRepository) {
    this.signupRepository = signupRepository;
    this.eventRepository = eventRepository;
  }
   @Override
    public Signup saveAccount(Signup signup) {
        return signupRepository.save(signup);
    }

    @Override
    public Signup findAccount(String email) {
        return signupRepository.findById(email).get();
    }
    @Override
    public List<Event> getAllEvent() {
            return eventRepository.findAll();
    }
}
