package peter.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peter.student.model.Signup;

@Repository
public interface SignupRepository extends JpaRepository <Signup,String> {

}
