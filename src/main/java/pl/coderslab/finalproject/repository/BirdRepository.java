package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Bird;

import java.util.List;


public interface BirdRepository extends JpaRepository<Bird,Long> {

    List<Bird> findAllByUserEmail(String email);
}
