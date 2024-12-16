package edu.i202221615.EF_Crud_Api.repository;

import edu.i202221615.EF_Crud_Api.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
