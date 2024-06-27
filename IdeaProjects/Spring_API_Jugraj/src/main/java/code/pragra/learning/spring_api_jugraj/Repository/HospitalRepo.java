package code.pragra.learning.spring_api_jugraj.Repository;

import code.pragra.learning.spring_api_jugraj.Entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepo extends JpaRepository <Hospital,Integer> {

}
