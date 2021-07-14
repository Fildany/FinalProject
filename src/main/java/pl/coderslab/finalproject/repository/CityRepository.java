package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {
}
