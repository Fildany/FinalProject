package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Bird;


public interface BirdRepository extends JpaRepository<Bird,Long> {


}
