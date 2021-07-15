package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findAllByOrderByName();
}
