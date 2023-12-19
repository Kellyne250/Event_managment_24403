package peter.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peter.student.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,String> {
}
